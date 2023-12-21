package api.service.inter;

import java.util.List;

import api.entities.Language;
import api.utilities.result.DataResult;
import api.utilities.result.Result;

public interface ILanguageService {
    DataResult<List<Language>> getAllByCvId(int cvId);
    DataResult<List<Language>> getAll();
    Result add(Language language);
    Result update(Language language);
    Result delete(Language language);
}