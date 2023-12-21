package api.service.inter;

import api.entities.Employees;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

import java.util.List;

public interface IEmployeesService {
    DataResult<Employees> getById(int employeesId);
    DataResult<List<Employees>> getAll();
    Result add(Employees employees);
    Result update(Employees employees);
    Result delete(Employees employees);
}
