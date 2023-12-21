package api.service.impl;

import java.util.List;
import java.util.Locale;

import api.entities.JobSeeker;
import api.service.inter.IJobSeekerService;
import api.dto.JobSeekerCvDto;
import api.repository.JobSeekerRepository;
import api.service.inter.*;
import api.utilities.mernisadapters.UserCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.service.inter.*;
import api.utilities.result.DataResult;
import api.utilities.result.ErorResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;

@Service
public class JobSeekerManager implements IJobSeekerService {

    private final JobSeekerRepository jobSeekerRepository;
    private final UserCheckService userCheckService;
    private final IJobExperienceService jobExperienceService;
    private final ILanguageService languageService;
    private final ILinkService linkService;
    private final ISkillService skillService;
    private final ISchoolService schoolService;
    private final IPreliminaryExplanationService preliminaryExplanationService;

    @Autowired
    public JobSeekerManager(JobSeekerRepository jobSeekerRepository, UserCheckService userCheckService,
                            IJobExperienceService jobExperienceService, ILanguageService languageService,
                            ILinkService linkService, ISkillService skillService, ISchoolService schoolService,
                            IPreliminaryExplanationService preliminaryExplanationService) {
        super();
        this.jobSeekerRepository = jobSeekerRepository;
        this.userCheckService = userCheckService;
        this.jobExperienceService = jobExperienceService;
        this.languageService = languageService;
        this.linkService = linkService;
        this.skillService = skillService;
        this.schoolService = schoolService;
        this.preliminaryExplanationService = preliminaryExplanationService;
    }

    @Override
    public DataResult<JobSeeker> getByNationalIdentity(String nationalIdentity) {
        return new SuccessDataResult<JobSeeker>(
                this.jobSeekerRepository.findByNationalIdentity(nationalIdentity)
        );
    }

    @Override
    public DataResult<JobSeeker> getById(int jobSeekerId) {
        return new SuccessDataResult<JobSeeker>(
                this.jobSeekerRepository.findById(jobSeekerId)
        );
    }

    @Override
    public DataResult<JobSeekerCvDto> getDtoById(int cvId) {
        JobSeekerCvDto cvDto = new JobSeekerCvDto();

        cvDto.jobExperiences = this.jobExperienceService.getAllByCvId(cvId).getData();
        cvDto.preliminaryExplanations = this.preliminaryExplanationService.getAllByCvId(cvId).getData();
        cvDto.skills = this.skillService.getAllByCvId(cvId).getData();
        cvDto.links = this.linkService.getAllByCvId(cvId).getData();
        cvDto.languages = this.languageService.getAllByCvId(cvId).getData();
        cvDto.schools = this.schoolService.getAllByCvId(cvId).getData();
        return new SuccessDataResult<JobSeekerCvDto>(cvDto);
    }

    @Override
    public DataResult<List<JobSeeker>> getAll() {
        return new SuccessDataResult<List<JobSeeker>>(
                this.jobSeekerRepository.findAll()
        );
    }

    @Override
    public Result add(JobSeeker jobSeeker) {
        if (!checkIfRealPerson(jobSeeker)) {
            return new ErorResult("Invalid person ! ");
        }
        if (!checkIfNationalityId(jobSeeker.getNationalIdentity())) {
            return new ErorResult("Nationality already exist ! ");
        }
        this.jobSeekerRepository.save(jobSeeker);
        return new SuccessResult("Job seeker added... ");
    }

    @Override
    public Result update(JobSeeker jobSeeker) {
        this.jobSeekerRepository.save(jobSeeker);
        return new SuccessResult("Job seeker updated... ");
    }

    @Override
    public Result delete(JobSeeker jobSeeker) {
        this.jobSeekerRepository.delete(jobSeeker);
        return new SuccessResult("Job seeker deleted... ");
    }

    private boolean checkIfNationalityId(String nationalityId) {
        return this.jobSeekerRepository.findByNationalIdentity(nationalityId) == null;
    }

    private boolean checkIfRealPerson(JobSeeker jobSeeker) {
        return this.userCheckService.checkIfRealPerson(Long.parseLong(jobSeeker.getNationalIdentity()), jobSeeker.getFirstName().toUpperCase(new Locale("id")), jobSeeker.getLastName().toLowerCase(new Locale("id")),
                jobSeeker.getYearsOfBirth());
    }
}