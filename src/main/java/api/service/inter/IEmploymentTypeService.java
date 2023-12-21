package api.service.inter;

import java.util.List;

import api.entities.EmploymentType;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

public interface IEmploymentTypeService {
    DataResult<List<EmploymentType>> getAll();
    Result add(EmploymentType employmentType);
}