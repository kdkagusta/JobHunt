package api.service.inter;

import api.dto.EmployerRegisterDto;
import api.dto.JobSeekerRegisterDto;
import api.utilities.result.Result;

public interface IAuthService {
    Result registerEmployer(EmployerRegisterDto employerRegisterDto);
    Result registerJobSeeker(JobSeekerRegisterDto jobSeekerRegisterDto);
    Result verifyEmail(int userId, String activationCode);
}