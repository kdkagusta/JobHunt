package api.service.impl;

import java.util.List;

import api.entities.Jobs;
import api.service.inter.IJobsService;
import api.repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import api.utilities.result.DataResult;
import api.utilities.result.ErorResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;

@Service
public class JobsManager implements IJobsService {

    private final JobsRepository jobsRepository;

    @Autowired
    public JobsManager(JobsRepository jobsRepository) {
        super();
        this.jobsRepository = jobsRepository;
    }

    @Override
    public DataResult<Jobs> getByExplanation(String explanation) {
        return new SuccessDataResult<Jobs>(
                this.jobsRepository.findByExplanation(explanation)
        );
    }

    @Override
    public DataResult<Jobs> getJobsId(int jobsId) {
        return new SuccessDataResult<Jobs>(
                this.jobsRepository.getOne(jobsId)
        );
    }

    @Override
    public DataResult<List<Jobs>> getAll() {
        return new SuccessDataResult<List<Jobs>>(
                this.jobsRepository.findAll()
        );
    }

    @Override
    public Result add(Jobs jobs) {
        if (!this.isTitleExist(jobs.getExplanation())) {

            return new ErorResult("Jobs exist ! ");
        }

        this.jobsRepository.save(jobs);
        return new SuccessResult("Jobs added... ");
    }

    @Override
    public Result update(Jobs jobs) {
        this.jobsRepository.save(jobs);
        return new SuccessResult("Jobs updated... ");
    }

    @Override
    public Result delete(Jobs jobs) {
        this.jobsRepository.delete(jobs);
        return new SuccessResult("Jobs deleted... ");
    }

    private boolean isTitleExist(String explanation) {
        return this.jobsRepository.findByExplanation(explanation) == null;

    }
}
