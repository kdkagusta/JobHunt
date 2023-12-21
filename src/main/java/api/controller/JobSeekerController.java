package api.controller;

import java.util.List;

import api.service.inter.IJobSeekerService;
import api.entities.JobSeeker;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import api.dto.JobSeekerCvDto;
@Tag(name = "Job Seeker", description = "Job Seeker APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/jobseeker")
public class JobSeekerController {
    private final IJobSeekerService jobSeekerService;

    @Autowired
    public JobSeekerController(IJobSeekerService jobSeekerService) {
        super();
        this.jobSeekerService = jobSeekerService;
    }


    @GetMapping("/get-all")
    public DataResult<List<JobSeeker>> getAll() {
        return this.jobSeekerService.getAll();
    }

    @GetMapping("getCVById")
    public DataResult<JobSeekerCvDto> getCvById(@RequestParam int jobSeekerId) {

        return this.jobSeekerService.getDtoById(jobSeekerId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.add(jobSeeker);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.update(jobSeeker);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobSeeker jobSeeker) {
        return this.jobSeekerService.delete(jobSeeker);
    }
}
