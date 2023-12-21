package api.controller;

import api.service.inter.ISchoolService;
import api.entities.School;
import api.utilities.result.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "School", description = "School APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/school")
public class SchoolController {
    private final ISchoolService schoolService;

    @Autowired
    public SchoolController(ISchoolService schoolService) {
        super();
        this.schoolService = schoolService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody School school) {
        return this.schoolService.add(school);
    }

    @PostMapping("/update")
    public Result update(@RequestBody School school) {
        return this.schoolService.update(school);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody School school) {
        return this.schoolService.delete(school);
    }
}