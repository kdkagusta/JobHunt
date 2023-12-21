package api.service.inter;

import java.util.List;

import api.entities.School;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

public interface ISchoolService {
    DataResult<List<School>> getAllByCvId(int cvId);
    DataResult<List<School>> getAll();
    Result add(School school);
    Result update(School school);
    Result delete(School school);
}
