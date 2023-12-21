package api.service.impl;

import java.util.List;

import api.entities.Language;
import api.service.inter.ILanguageService;
import api.repository.LanguageRepository;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LanguageManager implements ILanguageService {

    private final LanguageRepository languageRepository;

    @Autowired
    public LanguageManager(LanguageRepository languageRepository) {
        super();
        this.languageRepository = languageRepository;
    }

    @Override
    public DataResult<List<Language>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<Language>>(
                this.languageRepository.findAllByCv_Id(jobSeekerId)
        );
    }

    @Override
    public DataResult<List<Language>> getAll() {
        return new SuccessDataResult<List<Language>>(
                this.languageRepository.findAll()
        );
    }

    @Override
    public Result add(Language language) {
        this.languageRepository.save(language);
        return new SuccessResult("Language added... ");
    }

    @Override
    public Result update(Language language) {
        this.languageRepository.save(language);
        return new SuccessResult("Language updated... ");
    }

    @Override
    public Result delete(Language language) {
        this.languageRepository.delete(language);
        return new SuccessResult("Language deleted... ");
    }
}
