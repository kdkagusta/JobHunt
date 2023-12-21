package api.service.impl;

import java.util.List;

import api.entities.Employees;
import api.service.inter.IEmployeesService;
import api.repository.EmployeesRepository;
import api.utilities.result.DataResult;
import api.utilities.result.Result;
import api.utilities.result.SuccessDataResult;
import api.utilities.result.SuccessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeesManager implements IEmployeesService {

    private final EmployeesRepository employeesRepository;

    @Autowired
    public EmployeesManager(EmployeesRepository employeesDao) {
        super();
        this.employeesRepository = employeesDao;
    }

    @Override
    public DataResult<Employees> getById(int employeesId) {
        return new SuccessDataResult<Employees>(
                this.employeesRepository.findById(employeesId)
        );
    }

    @Override
    public DataResult<List<Employees>> getAll() {
        return new SuccessDataResult<List<Employees>>(
                this.employeesRepository.findAll()
        );
    }

    @Override
    public Result add(Employees employees) {
        this.employeesRepository.save(employees);
        return new SuccessResult("Employees added... ");
    }

    @Override
    public Result update(Employees employees) {
        this.employeesRepository.save(employees);
        return new SuccessResult("Employees updated... ");
    }

    @Override
    public Result delete(Employees employees) {
        this.employeesRepository.delete(employees);
        return new SuccessResult("Employees deleted... ");
    }
}
