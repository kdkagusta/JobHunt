package api.service.inter;

import api.entities.Employer;
import api.entities.*;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

import java.util.List;

public interface IEmployerService {
    DataResult<Employer> getById(int id);
    DataResult<Employer> getByEmail(String email);
    DataResult<List<Employer>> getAll();
    Result add(Employer employer);
    Result update(Employer employer);
    Result delete(Employer employer);
}