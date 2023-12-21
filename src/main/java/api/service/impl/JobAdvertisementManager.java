package api.service.impl;

import java.util.List;

import api.entities.JobAdvertisement;
import api.service.inter.IJobAdvertisementService;
import api.repository.JobAdvertisementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import api.utilities.result.DataResult;
import api.utilities.result.ErorResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;

@Service
public class JobAdvertisementManager implements IJobAdvertisementService {
    private final JobAdvertisementRepository jobAdvertisementRepository;

    @Autowired
    public JobAdvertisementManager(JobAdvertisementRepository jobAdvertisementRepository) {
        super();
        this.jobAdvertisementRepository = jobAdvertisementRepository;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getByIsActive() {
        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementRepository.findByIsActive()
        );
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAllSortedByReleaseDate() {
        Sort sort = Sort.by(Sort.Direction.DESC, "appealDeadline");

        return new SuccessDataResult<List<JobAdvertisement>>(
                this.jobAdvertisementRepository.findAll(sort)
        );
    }

    @Override
    public Result enableAdmin(int adminId) {
        JobAdvertisement jobAdvertisement = this.jobAdvertisementRepository.findById(adminId);
        if (isJobAdvertisementExists(jobAdvertisement)) {

            return new ErorResult("Job Advertisement doesn't exists");

        }

        jobAdvertisement.setIsActive(!jobAdvertisement.getIsActive());
        this.jobAdvertisementRepository.save(jobAdvertisement);
        return new SuccessResult("Toggled");
    }

    @Override
    public Result changeVerifiedByAdmin(int adminId) {
        JobAdvertisement jobAdvertisement = this.jobAdvertisementRepository.findById(adminId);
        if (isJobAdvertisementExists(jobAdvertisement)) {

            return new ErorResult("Job Advertisement doesn't exists");

        }

        jobAdvertisement.setIsVerifiedByEmployees(true);
        this.jobAdvertisementRepository.save(jobAdvertisement);
        return new SuccessResult("Verified by Employee");
    }

    @Override
    public Result add(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementRepository.save(jobAdvertisement);
        return new SuccessResult("Job advertisement added... ");
    }

    @Override
    public Result update(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementRepository.save(jobAdvertisement);
        return new SuccessResult("Job advertisement updated... ");
    }

    @Override
    public Result delete(JobAdvertisement jobAdvertisement) {
        this.jobAdvertisementRepository.delete(jobAdvertisement);
        return new SuccessResult("Job advertisement deleted... ");
    }

    private boolean isJobAdvertisementExists(JobAdvertisement jobAdvertisement) {
        return jobAdvertisement == null;
    }

    @Override
    public DataResult<List<JobAdvertisement>> getAll() {
        return new SuccessDataResult<List<JobAdvertisement>>(
            this.jobAdvertisementRepository.findAll()
        );
    }
}
