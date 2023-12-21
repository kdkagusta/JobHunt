package api.controller;

import java.util.List;


import api.service.inter.ILanguageService;
import api.entities.Language;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Language", description = "Language APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/language")
public class LanguageController {
    private final ILanguageService languageService;

    @Autowired
    public LanguageController(ILanguageService languageService) {
        super();
        this.languageService = languageService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody @Valid Language language) {
        return this.languageService.add(language);
    }


    @PostMapping("/update")
    public Result update(@RequestBody Language language) {
        return this.languageService.update(language);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Language language) {
        return this.languageService.delete(language);
    }

    @GetMapping("/get-all")
    public DataResult<List<Language>> getall(@RequestParam int candidateId) {
        return this.languageService.getAllByCvId(candidateId);
    }
}
