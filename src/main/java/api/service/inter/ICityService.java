package api.service.inter;

import java.util.List;

import api.entities.City;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

public interface ICityService {
    DataResult<City> getById(int id);
    DataResult<City> getByName(String name);
    DataResult<List<City>> getAll();
    Result add(City city);
    Result update(City city);
    Result delete(City city);
}