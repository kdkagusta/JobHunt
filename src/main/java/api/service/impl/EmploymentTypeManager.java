package api.service.impl;

import java.util.List;

import api.entities.EmploymentType;
import api.service.inter.IEmploymentTypeService;
import api.repository.EmploymentTypeRepository;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;
import org.springframework.stereotype.Service;

@Service
public class EmploymentTypeManager implements IEmploymentTypeService {

    private final EmploymentTypeRepository employmentTypeRepository;

    public EmploymentTypeManager(EmploymentTypeRepository employmentDao) {
        super();
        this.employmentTypeRepository = employmentDao;
    }

    @Override
    public DataResult<List<EmploymentType>> getAll() {
        return new SuccessDataResult<List<EmploymentType>>(
                this.employmentTypeRepository.findAll()
        );
    }

    @Override
    public Result add(EmploymentType employmentType) {
        this.employmentTypeRepository.save(employmentType);
        return new SuccessResult("Employment type added... ");
    }
}
