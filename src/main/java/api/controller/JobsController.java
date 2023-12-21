package api.controller;

import java.util.List;

import api.service.inter.IJobsService;
import api.entities.Jobs;
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
@Tag(name = "Jobs", description = "Jobs APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/jobs")
public class JobsController {
    private final IJobsService jobsService;

    @Autowired
    public JobsController(IJobsService jobsService) {
        super();
        this.jobsService = jobsService;
    }


    @GetMapping("/get-all")
    public DataResult<List<Jobs>> getAll() {
        return this.jobsService.getAll();
    }


    @PostMapping("/add")
    public Result registerCandidate(@RequestBody Jobs jobs) {
        return this.jobsService.add(jobs);
    }

    @GetMapping("/getByJobTitleId")
    public DataResult<Jobs> getByCityId(@RequestParam("jobsId") int jobsId) {
        return this.jobsService.getJobsId(jobsId);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Jobs jobs) {
        return this.jobsService.update(jobs);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Jobs jobs) {
        return this.jobsService.delete(jobs);
    }
}
