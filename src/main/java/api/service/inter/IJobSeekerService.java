package api.service.inter;
import api.entities.JobSeeker;
import api.dto.JobSeekerCvDto;
import api.entities.*;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

import java.util.List;

public interface IJobSeekerService {
    DataResult<JobSeeker> getByNationalIdentity(String nationalIdentity);
    DataResult<JobSeeker> getById(int jobSeekerId);
    DataResult<JobSeekerCvDto> getDtoById(int jobSeekerId);
    DataResult<List<JobSeeker>> getAll();
    Result add(JobSeeker jobSeeker);
    Result update(JobSeeker jobSeeker);
    Result delete(JobSeeker jobSeeker);
}