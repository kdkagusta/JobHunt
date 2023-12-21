package api.service.impl;

import java.util.List;

import api.entities.JobExperience;
import api.service.inter.IJobExperienceService;
import api.repository.JobExperienceRepository;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobExperienceManager implements IJobExperienceService {

    public JobExperienceRepository jobExperienceRepository;

    @Autowired
    public JobExperienceManager(JobExperienceRepository jobExperienceRepository) {
        super();
        this.jobExperienceRepository = jobExperienceRepository;
    }

    @Override
    public DataResult<List<JobExperience>> getAllByCvId(int cvId) {
        return new SuccessDataResult<List<JobExperience>>(
                this.jobExperienceRepository.findByCv_Id(cvId)
        );
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return new SuccessDataResult<List<JobExperience>>(
                this.jobExperienceRepository.findAll()
        );
    }

    @Override
    public Result add(JobExperience jobExperience) {
        this.jobExperienceRepository.save(jobExperience);
        return new SuccessResult("Job experience added... ");
    }

    @Override
    public Result update(JobExperience jobExperience) {
        this.jobExperienceRepository.save(jobExperience);
        return new SuccessResult("Job experience updated... ");
    }

    @Override
    public Result delete(JobExperience jobExperience) {
        this.jobExperienceRepository.delete(jobExperience);
        return new SuccessResult("Job experience deleted... ");
    }
}
