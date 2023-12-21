package api.service.inter;

import java.util.List;

import api.entities.PreliminaryExplanation;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

public interface IPreliminaryExplanationService {
    DataResult<List<PreliminaryExplanation>> getAllByCvId(int cvId);
    DataResult<List<PreliminaryExplanation>> getAll();
    Result add(PreliminaryExplanation preliminaryExplanation);
    Result update(PreliminaryExplanation preliminaryExplanation);
    Result delete(PreliminaryExplanation preliminaryExplanation);
}