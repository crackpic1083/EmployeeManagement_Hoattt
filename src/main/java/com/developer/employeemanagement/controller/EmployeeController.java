package com.developer.employeemanagement.controller;
import com.developer.employeemanagement.entity.EmployeeEntity;
import com.developer.employeemanagement.service.EmployeeService;
import com.developer.employeemanagement.utils.AppConstants;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping
    public List<EmployeeEntity> findAllEmployee(
            @RequestParam(value = "pageNo", defaultValue = AppConstants.DEFAULT_PAGE_NUMBER, required = false) Integer pageNo,
            @RequestParam(value = "pageSize", defaultValue = AppConstants.DEFAULT_PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(value = "sortBy", defaultValue = AppConstants.DEFAULT_SORT_BY, required = false) String sortBy
    ) {
        Page< EmployeeEntity > data = employeeService.findAllEmployee(pageNo, pageSize, sortBy);
        return data.getContent();
    }

    @GetMapping("/{id}")
    public Optional<EmployeeEntity> findEmployeeById(@PathVariable("id") Long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public EmployeeEntity saveEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.saveEmployee(employeeEntity);
    }

    @PutMapping
    public EmployeeEntity updateEmployee(@RequestBody EmployeeEntity employeeEntity) {
        return employeeService.updateEmployee(employeeEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

//    @GetMapping("/{name}/{address}")
//    public List<EmployeeEntity> findByCompanyNameAndCompanyAddress(@PathVariable String name, @PathVariable String address) {
//        return employeeService.findByCompanyNameAndCompanyAddress(name,address);
//    }

//    @GetMapping("/{companyName}/{courseName}")
//    public List<EmployeeEntity> getByCompanyNameAndCourseName(@PathVariable String companyName, @PathVariable String courseName){
//        return employeeService.findEmployeeEntitiesByCompanyNameAndCourses(companyName, courseName);
//    }



    @GetMapping("/test")
    public List<EmployeeEntity> getEmployees(
            @RequestParam(required = false) String companyName,
            @RequestParam(required = false) String character) {
        return employeeService.findEmployeeEntitiesByCompanyNameAndAddressStartsWith(companyName, character);
    }



}
