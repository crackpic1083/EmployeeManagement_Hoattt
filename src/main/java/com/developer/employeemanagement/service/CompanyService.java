package com.developer.employeemanagement.service;
import com.developer.employeemanagement.entity.CompanyEntity;
import com.developer.employeemanagement.entity.EmployeeEntity;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    List<CompanyEntity> findAllCompany();
    Optional<CompanyEntity> findById(Long id);
    CompanyEntity saveCompany(CompanyEntity companyEntity);
    CompanyEntity updateEmployee(CompanyEntity companyEntity);
    void deleteCompany(Long id);



}
