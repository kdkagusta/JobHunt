package api.controller;

import api.service.inter.ILinkService;
import api.entities.Link;
import api.utilities.result.Result;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Tag(name = "Link", description = "Link APIs")
@RestController
@RequestMapping("/api/link")
public class LinkController {
    private final ILinkService linkService;

    @Autowired
    public LinkController(ILinkService linkService) {
        super();
        this.linkService = linkService;
    }


    @PostMapping("/add")
    public Result add(@RequestBody Link link) {
        return this.linkService.add(link);
    }

    @PostMapping("/update")
    public Result update(@RequestBody Link link) {
        return this.linkService.update(link);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody Link link) {
        return this.linkService.delete(link);
    }
}
