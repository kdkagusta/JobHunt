package api.service.inter;

import java.util.List;

import api.entities.Skill;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

public interface ISkillService {
    DataResult<List<Skill>> getAllByCvId(int cvId);
    DataResult<List<Skill>> getAll();
    Result add(Skill skill);
    Result update(Skill skill);
    Result delete(Skill skill);
}