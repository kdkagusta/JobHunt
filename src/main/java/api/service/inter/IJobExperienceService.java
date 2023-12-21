package api.service.inter;

import java.util.List;

import api.entities.JobExperience;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

public interface IJobExperienceService {
    DataResult<List<JobExperience>> getAllByCvId(int cvId);
    DataResult<List<JobExperience>> getAll();
    Result add(JobExperience jobExperinence);
    Result update(JobExperience jobExperinence);
    Result delete(JobExperience jobExperinence);
}