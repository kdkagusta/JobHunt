package api.controller;

import java.util.List;

import api.service.inter.IEmployeesService;
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
import api.entities.Employees;
@Tag(name = "Employees", description = "Employees APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/employees")
public class EmployeesController {
    private final IEmployeesService employeesService;

    @Autowired
    public EmployeesController(IEmployeesService employeesService) {
        super();
        this.employeesService = employeesService;
    }


    @GetMapping("/get-all")
    public DataResult<List<Employees>> getAll() {
        return this.employeesService.getAll();
    }

    @GetMapping("get-byid")
    public DataResult<Employees> getById(@RequestParam("id") int employeesId) {
        return this.employeesService.getById(employeesId);
    }

    @PostMapping("/add")
    public Result add(@RequestBody Employees employees) {
        return this.employeesService.add(employees);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Employees employees) {
        return this.employeesService.update(employees);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Employees employees) {
        return this.employeesService.delete(employees);
    }
}
