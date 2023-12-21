package api.service.impl;

import api.entities.Employer;
import api.entities.JobSeeker;
import api.entities.VerifiedCode;
import api.dto.EmployerRegisterDto;
import api.dto.JobSeekerRegisterDto;
import api.service.inter.IAuthService;
import api.service.inter.*;
import api.utilities.result.ErorResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessResult;
import api.utilities.verify.IVerifiadService;
import api.service.inter.IEmployerService;
import api.service.inter.IJobSeekerService;
import api.service.inter.IVerifiedCodeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AuthManager implements IAuthService {

    private final IJobSeekerService jobSeekerService;
    private final IEmployerService employerService;
    private final IVerifiedCodeService codeService;
    private final IVerifiadService verifiedService;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthManager(IJobSeekerService jobSeekerService,
                       IEmployerService employerService,
                       IVerifiedCodeService codeService,
                       IVerifiadService verifiedService,
                       ModelMapper modelMapper) {
        super();
        this.jobSeekerService = jobSeekerService;
        this.employerService = employerService;
        this.codeService = codeService;
        this.verifiedService = verifiedService;
        this.modelMapper = modelMapper;
    }

    @Override
    public Result registerEmployer(EmployerRegisterDto employerRegisterDto) {
        if (checkIfEqualPasswordAndConfirmPassword(employerRegisterDto.getPassword(),
                employerRegisterDto.getConfirmPassword())) {
            return new ErorResult("Your password or email is incorrect. Please try again...");
        }

        Employer employer = modelMapper.map(employerRegisterDto, Employer.class);
        var result = this.employerService.add(employer);
        System.out.println(result);

        if (result.isSuccess()) {
            this.generateVerificationCode(employer.getId());
        }

        return new ErorResult("Error! Try again...");
    }

    @Override
    public Result registerJobSeeker(JobSeekerRegisterDto jobSeekerRegisterDto) {
        if (checkIfEqualPasswordAndConfirmPassword(jobSeekerRegisterDto.getPassword(),
                jobSeekerRegisterDto.getConfirmedPassword())) {
            return new ErorResult("Your password or email is incorrect. Please try again...");
        }

        JobSeeker jobSeeker = modelMapper.map(jobSeekerRegisterDto, JobSeeker.class);
        var result = this.jobSeekerService.add(jobSeeker);
        System.out.println(result);

        if (result.isSuccess()) {
            this.generateVerificationCode(jobSeeker.getId());
        }

        return new ErorResult(result.getMessage());
    }

    @Override
    public Result verifyEmail(int userId, String activationCode) {

        var result = this.codeService.getByUserIdAndVerificationCode(userId, activationCode);

        if (!this.isVerificationCodeExist(userId, activationCode).isSuccess()
                || !this.isVerificationCodeActive(userId, activationCode).isSuccess()
                || !isExpired(userId, activationCode).isSuccess()) {
            return new ErorResult("-");
        }
        if (!this.setCandidateActivationCode(userId).isSuccess()
                && !this.setEmployerActivationCode(userId).isSuccess()) {
            return new ErorResult("User couldn't find ");
        }

        VerifiedCode verifiedCode = result.getData();
        verifiedCode.setConfirmedDate(LocalDate.now());
        verifiedCode.setIsActivate(true);
        this.codeService.update(verifiedCode);

        return new SuccessResult("Verified !");
    }

    private boolean checkIfEqualPasswordAndConfirmPassword(String password, String confirmPassword) {
        return !password.equals(confirmPassword);
    }

    private Result setEmployerActivationCode(int userId) {

        if (this.employerService.getById(userId).getData() != null) {

            Employer employer = this.employerService.getById(userId).getData();

            employer.setIsEmailVerified(true);

            this.employerService.update(employer);

            return new SuccessResult();
        }

        return new ErorResult();
    }

    private Result setCandidateActivationCode(int userId) {
        if (this.jobSeekerService.getById(userId).getData() != null) {

            JobSeeker jobSeeker = this.jobSeekerService.getById(userId).getData();

            jobSeeker.setIsEmailVerified(true);

            this.jobSeekerService.update(jobSeeker);

            return new SuccessResult();
        }

        return new ErorResult();
    }

    private Result isVerificationCodeExist(int user_id, String activationCode) {

        if (this.codeService.getByUserIdAndVerificationCode(user_id, activationCode).getData() == null) {
            return new ErorResult("Verification Code is wrong !");
        }
        return new SuccessResult();

    }

    private Result isVerificationCodeActive(int user_id, String activationCode) {

        if (this.codeService.getByUserIdAndVerificationCode(user_id, activationCode).getData().getIsActivate()) {

            return new ErorResult("Verification Code is already active");
        }
        return new SuccessResult();
    }

    private Result isExpired(int user_id, String activationCode) {

        if (this.codeService.getByUserIdAndVerificationCode(user_id, activationCode).getData().getExpiredDate()
                .isBefore(LocalDate.now())) {

            return new ErorResult("Verification Code is Expired");
        }
        return new SuccessResult();
    }

    private void generateVerificationCode(int userId) {
        String code = this.verifiedService.codeGenerator();
        this.verifiedService.sendVerificationCode(code);
        VerifiedCode verifiedCode = new VerifiedCode(userId, code, LocalDate.now().plusDays(1));
        this.codeService.add(verifiedCode);
        new SuccessResult("User Registered !");
    }
}
