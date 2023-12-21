package api.controller;

import java.util.List;

import api.service.inter.IJobExperienceService;
import api.entities.JobExperience;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Job Experience", description = "Job Experience APIs")
@RestController
@RequestMapping("/api/job-experience")
public class JobExperienceController {
    private final IJobExperienceService jobExperienceService;

    @Autowired
    public JobExperienceController(IJobExperienceService jobExperienceService) {
        super();
        this.jobExperienceService = jobExperienceService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.add(jobExperience);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobExperience jobExperience) {
        return this.jobExperienceService.update(jobExperience);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobExperience jobExperience) {

        return this.jobExperienceService.delete(jobExperience);
    }

    @GetMapping("/getall")
    public DataResult<List<JobExperience>> getAll() {
        return this.jobExperienceService.getAll();
    }
}
