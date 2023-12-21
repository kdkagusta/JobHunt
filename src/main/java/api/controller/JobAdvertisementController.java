package api.controller;

import java.util.List;

import api.service.inter.IJobAdvertisementService;
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
import api.entities.JobAdvertisement;

@Tag(name = "Job Advertisment", description = "Job Advertisment APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/job-advertisement")
public class JobAdvertisementController {
    private final IJobAdvertisementService jobAdvertisementService;

    @Autowired
    public JobAdvertisementController(IJobAdvertisementService jobAdvertisementService) {
        super();
        this.jobAdvertisementService = jobAdvertisementService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.add(jobAdvertisement);
    }


    @GetMapping("/getByIsActive")
    public DataResult<List<JobAdvertisement>> getByIsActive() {
        return this.jobAdvertisementService.getByIsActive();
    }


    @GetMapping("/getByAppealDeadline")
    public DataResult<List<JobAdvertisement>> getByAppealDeadline() {
        return this.jobAdvertisementService.getAllSortedByReleaseDate();
    }

    @GetMapping("/employeeVerified")
    public Result toggleVerifiedByEmployee(@RequestParam int adminId) {
        return this.jobAdvertisementService.enableAdmin(adminId);
    }

    @GetMapping("/toggle-active")
    public Result update(@RequestParam int adminId) {
        return this.jobAdvertisementService.changeVerifiedByAdmin(adminId);
    }

    @PostMapping("/update")
    public Result update(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.update(jobAdvertisement);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody JobAdvertisement jobAdvertisement) {
        return this.jobAdvertisementService.delete(jobAdvertisement);
    }

    @GetMapping("/get-all")
    public DataResult<List<JobAdvertisement>> getAll() {
        return this.jobAdvertisementService.getAll();
    }
}
