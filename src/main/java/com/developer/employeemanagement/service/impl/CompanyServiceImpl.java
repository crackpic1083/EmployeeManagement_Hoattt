package com.developer.employeemanagement.service.impl;

import com.developer.employeemanagement.entity.CompanyEntity;
import com.developer.employeemanagement.repository.CompanyRepository;
import com.developer.employeemanagement.service.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyEntity> findAllCompany() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<CompanyEntity> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public CompanyEntity saveCompany(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    @Override
    public CompanyEntity updateEmployee(CompanyEntity companyEntity) {
        return companyRepository.save(companyEntity);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
