package com.developer.employeemanagement.controller;
import com.developer.employeemanagement.entity.CompanyEntity;
import com.developer.employeemanagement.service.CompanyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }


    @GetMapping
    public List<CompanyEntity> findAllCompany() {
        return companyService.findAllCompany();
    }

    @GetMapping("/{id}")
    public Optional<CompanyEntity> findCompanyById(@PathVariable("id") Long id) {
        return companyService.findById(id);
    }

    @PostMapping
    public CompanyEntity saveCompany(@RequestBody CompanyEntity companyEntity) {
        return companyService.saveCompany(companyEntity);
    }

    @PutMapping
    public CompanyEntity updateCompany(@RequestBody CompanyEntity companyEntity) {
        return companyService.updateEmployee(companyEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteCompany(id);
    }



}
