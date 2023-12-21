package api.service.inter;

import java.util.List;

import api.entities.Jobs;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

public interface IJobsService {
    DataResult<Jobs> getByExplanation(String explanation);
    DataResult<Jobs> getJobsId(int jobsId);
    DataResult<List<Jobs>> getAll();
    Result add(Jobs jobs);
    Result update(Jobs jobs);
    Result delete(Jobs jobs);
}