package api.controller;

import api.service.inter.ISkillService;
import api.entities.Skill;
import api.utilities.result.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Skill", description = "Skill APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/skill")
public class SkillController {
    private final ISkillService skillService;

    @Autowired
    public SkillController(ISkillService skillService) {
        super();
        this.skillService = skillService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody Skill skill) {
        return this.skillService.add(skill);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Skill skill) {
        return this.skillService.update(skill);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Skill skill) {
        return this.skillService.delete(skill);
    }
}
