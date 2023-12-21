package api.service.impl;

import java.util.List;

import api.entities.School;
import api.service.inter.ISchoolService;
import api.repository.SchoolRepository;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchoolManager implements ISchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolManager(SchoolRepository schoolRepository) {
        super();
        this.schoolRepository = schoolRepository;
    }

    @Override
    public DataResult<List<School>> getAllByCvId(int jobSeekerId) {
        return new SuccessDataResult<List<School>>(
                this.schoolRepository.findAllByCv_Id(jobSeekerId)
        );
    }

    @Override
    public Result add(School school) {
        this.schoolRepository.save(school);
        return new SuccessResult("School added... ");
    }

    @Override
    public Result update(School school) {
        this.schoolRepository.save(school);
        return new SuccessResult("School updated... ");
    }

    @Override
    public Result delete(School school) {
        this.schoolRepository.save(school);
        return new SuccessResult("School deleted... ");
    }

    @Override
    public DataResult<List<School>> getAll() {
        return new SuccessDataResult<List<School>>(
                this.schoolRepository.findAll()
        );
    }
}
