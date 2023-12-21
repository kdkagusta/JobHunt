package api.controller;

import java.util.List;

import api.service.inter.IEmploymentTypeService;
import api.entities.EmploymentType;
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
@Tag(name = "Employer", description = "Employer Type APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/employment-type")
public class EmploymentTypeController {
    private final IEmploymentTypeService employmentService;

    @Autowired
    public EmploymentTypeController(IEmploymentTypeService employmentService) {
        super();
        this.employmentService = employmentService;
    }

    @GetMapping("/get-all")
    public DataResult<List<EmploymentType>> getAll() {
        return this.employmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody EmploymentType employmentType) {
        return this.employmentService.add(employmentType);
    }
}
