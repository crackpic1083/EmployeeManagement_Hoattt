package com.developer.employeemanagement.service;
import com.developer.employeemanagement.entity.EmployeeEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Page<EmployeeEntity> findAllEmployee(Integer pageNumber, Integer pageSize, String sort);
    Optional<EmployeeEntity> findById(Long id);
    EmployeeEntity saveEmployee(EmployeeEntity employeeEntity);
    EmployeeEntity updateEmployee(EmployeeEntity employeeEntity);
    void deleteEmployee(Long id);

    List<EmployeeEntity> findByCompanyNameAndCompanyAddress(String companyName, String companyAddress);

    List<EmployeeEntity> findEmployeeEntitiesByCompanyNameAndCourses(String companyName, String courseName);

    List<EmployeeEntity> findEmployeeEntitiesByCompanyNameAndAddressStartsWith(String companyName, String startWith);



}
