package api.controller;

import java.util.List;

import api.service.inter.IEmployerService;
import api.entities.Employer;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Employer", description = "Employer APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/employer")
public class EmployerController {
    private final IEmployerService employerService;

    @Autowired
    public EmployerController(IEmployerService employerService) {
        super();
        this.employerService = employerService;
    }


    @GetMapping("/get-all")
    public DataResult<List<Employer>> getAll() {
        return this.employerService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employer employer) {
        return this.employerService.add(employer);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Employer employer) {
        return this.employerService.update(employer);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Employer employer) {
        return this.employerService.delete(employer);
    }
}