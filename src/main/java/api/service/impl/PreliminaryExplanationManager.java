package api.service.impl;

import java.util.List;

import api.entities.PreliminaryExplanation;
import api.service.inter.IPreliminaryExplanationService;
import api.repository.PreliminaryExplanationRepository;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PreliminaryExplanationManager implements IPreliminaryExplanationService {

    private final PreliminaryExplanationRepository preliminaryExplanationRepository;

    @Autowired
    public PreliminaryExplanationManager(PreliminaryExplanationRepository preliminaryExplanationRepository) {
        super();
        this.preliminaryExplanationRepository = preliminaryExplanationRepository;
    }

    @Override
    public DataResult<List<PreliminaryExplanation>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<PreliminaryExplanation>>(
                this.preliminaryExplanationRepository.findAllByCv_Id(jobSeekerId)
        );
    }

    @Override
    public Result add(PreliminaryExplanation preliminaryExplanation) {
        this.preliminaryExplanationRepository.save(preliminaryExplanation);
        return new SuccessResult("Preliminary explanation added... ");
    }

    @Override
    public Result update(PreliminaryExplanation preliminaryExplanation) {
        this.preliminaryExplanationRepository.save(preliminaryExplanation);
        return new SuccessResult("Preliminary explanation updated... ");
    }

    @Override
    public Result delete(PreliminaryExplanation preliminaryExplanation) {
        this.preliminaryExplanationRepository.delete(preliminaryExplanation);
        return new SuccessResult("Preliminary explanation deleted... ");
    }

    @Override
    public DataResult<List<PreliminaryExplanation>> getAll() {
        return new SuccessDataResult<List<PreliminaryExplanation>>(
                this.preliminaryExplanationRepository.findAll()
        );
    }
}
