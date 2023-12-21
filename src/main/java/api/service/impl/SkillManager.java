package api.service.impl;

import java.util.List;

import api.entities.Skill;
import api.service.inter.ISkillService;
import api.repository.SkillRepository;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillManager implements ISkillService {

    private final SkillRepository skillRepository;

    @Autowired
    public SkillManager(SkillRepository skillRepository) {
        super();
        this.skillRepository = skillRepository;
    }

    @Override
    public DataResult<List<Skill>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<Skill>>(
                this.skillRepository.findAllByCv_Id(jobSeekerId)
        );
    }

    @Override
    public Result add(Skill skill) {
        this.skillRepository.save(skill);
        return new SuccessResult("Skill added... ");
    }

    @Override
    public Result update(Skill skill) {
        this.skillRepository.save(skill);
        return new SuccessResult("Skill updated... ");
    }

    @Override
    public Result delete(Skill skill) {
        this.skillRepository.save(skill);
        return new SuccessResult("Skill deleted... ");
    }

    @Override
    public DataResult<List<Skill>> getAll() {
        return new SuccessDataResult<List<Skill>>(
                this.skillRepository.findAll()
        );
    }
}
