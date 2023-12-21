package api.service.impl;

import java.util.List;

import api.entities.Employer;
import api.service.inter.IEmployerService;
import api.repository.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.utilities.result.DataResult;
import api.utilities.result.ErorResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;

@Service
public class EmployerManager implements IEmployerService {

    private final EmployerRepository employerRepository;

    @Autowired
    public EmployerManager(EmployerRepository employerRepository) {
        super();
        this.employerRepository = employerRepository;
    }

    @Override
    public DataResult<Employer> getById(int id) {
        return new SuccessDataResult<Employer>(
                this.employerRepository.findById(id)
        );
    }

    @Override
    public DataResult<Employer> getByEmail(String email) {
        return new SuccessDataResult<Employer>(
                this.employerRepository.findByEmployerEmail(email)
        );
    }

    @Override
    public DataResult<List<Employer>> getAll() {
        return new SuccessDataResult<List<Employer>>(
                this.employerRepository.findAll()
        );
    }

    @Override
    public Result add(Employer employer) {
        if (!this.checkIfEmailExists(employer.getEmployerEmail())) {
            return new ErorResult("Email already exist ! ");
        }

        // if(!this.checkIfEqualEmailAndDomain(employer.getEmployerEmail(),employer.getEmployerWebsite())) {
        //     return new ErorResult("Invalid mail adress ! ");
        // }

        this.employerRepository.save(employer);
        return new SuccessResult("Employer added... ");
    }

    @Override
    public Result update(Employer employer) {
        this.employerRepository.save(employer);
        return new SuccessResult("Employer updated... ");
    }

    @Override
    public Result delete(Employer employer) {
        this.employerRepository.delete(employer);
        return new SuccessResult("Employer deleted... ");
    }

    private boolean checkIfEmailExists(String email) {
        return this.employerRepository.findByEmployerEmail(email) == null;

    }

    private boolean checkIfEqualEmailAndDomain(String email, String website) {
        String[] emailArr = email.split("@", 2);
        String domain = website.substring(4);
        return emailArr[1].equals(domain);
    }
}
