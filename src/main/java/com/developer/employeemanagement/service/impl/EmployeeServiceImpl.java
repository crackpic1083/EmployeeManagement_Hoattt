package com.developer.employeemanagement.service.impl;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.repository.EmployeeRepository;
import com.developer.employeemanagement.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Page<EmployeeEntity> findAllEmployee(Integer pageNumber, Integer pageSize, String sort) {
        Pageable pageable = null;
        if (sort != null) {
            // with sorting
            pageable = PageRequest.of(pageNumber, pageSize, Sort.Direction.ASC, sort);
        } else {
            // without sorting
            pageable = PageRequest.of(pageNumber, pageSize);
        }
        return employeeRepository.findAll(pageable);
    }

    @Override
    public Optional<EmployeeEntity> findById(Long id) {
        return employeeRepository.findById(id);
    }

    @Override
    public EmployeeEntity saveEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity updateEmployee(EmployeeEntity employeeEntity) {
        return employeeRepository.save(employeeEntity);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeEntity> findByCompanyNameAndCompanyAddress(String companyName, String companyAddress) {
        return employeeRepository.findByCompanyNameAndCompanyAddress(companyName, companyAddress);
    }

    public List<EmployeeEntity> findEmployeeEntitiesByCompanyNameAndCourses(String companyName, String courseName){
        return employeeRepository.findEmployeeEntitiesByCompanyNameAndCourses(companyName, courseName);
    }

    @Override
    public List<EmployeeEntity> findEmployeeEntitiesByCompanyNameAndAddressStartsWith(String companyName, String startWith) {
        return employeeRepository.findEmployeeEntitiesByCompanyNameAndAddressStartsWith(companyName, startWith);
    }


}
