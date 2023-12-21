package api.service.impl;

import java.util.List;

import api.entities.City;
import api.service.inter.ICityService;
import api.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import api.utilities.result.DataResult;
import api.utilities.result.ErorResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;

@Service
public class CityManager implements ICityService {

    private final CityRepository cityRepository;

    @Autowired
    public CityManager(CityRepository cityDao) {
        super();
        this.cityRepository = cityDao;
    }

    @Override
    public DataResult<City> getById(int id) {
        return new SuccessDataResult<City>(
                this.cityRepository.getOne(id)
        );
    }

    @Override
    public DataResult<City> getByName(String name) {
        return new SuccessDataResult<City>(
                this.cityRepository.findByCityName(name)
        );
    }

    @Override
    public DataResult<List<City>> getAll() {
        return new SuccessDataResult<List<City>>(
                this.cityRepository.findAll()
        );
    }

    @Override
    public Result add(City city) {
        if (!this.isCityExists(city.getCityName()).isSuccess()) {
            return new ErorResult("City already exists ! ");
        }
        this.cityRepository.save(city);
        return new SuccessResult("City added... ");
    }

    @Override
    public Result update(City city) {
        this.cityRepository.save(city);
        return new SuccessResult("City updated... ");
    }

    @Override
    public Result delete(City city) {
        this.cityRepository.delete(city);
        return new SuccessResult("City deleted... ");
    }

    public Result isCityExists(String name) {

        if (this.cityRepository.findByCityName(name) != null) {
            return new ErorResult();

        }
        return new SuccessResult();
    }
}
