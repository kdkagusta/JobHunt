package api.controller;

import java.util.List;

import api.service.inter.ICityService;
import api.entities.City;
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
@Tag(name = "City", description = "City APIs")
@RestController
@CrossOrigin
@RequestMapping("/api/city")
public class CityController {
    private final ICityService cityService;

    @Autowired
    public CityController(ICityService cityService) {
        super();
        this.cityService = cityService;
    }


    @GetMapping("/getall")
    public DataResult<List<City>> getAll() {
        return this.cityService.getAll();
    }

    @GetMapping("/getByCityId")
    public DataResult<City> getByCityId(@RequestParam("cityId") int cityId) {
        return this.cityService.getById(cityId);
    }


    @PostMapping("/add")
    public Result add(@RequestBody City city) {
        return this.cityService.add(city);
    }

    @PostMapping("/update")
    public Result update(@RequestBody City city) {
        return this.cityService.update(city);
    }

    @PostMapping("/delete")
    public Result delete(@RequestBody City city) {
        return this.cityService.delete(city);
    }
}
