package com.developer.employeemanagement.repository;

import com.developer.employeemanagement.entity.CompanyEntity;
import com.developer.employeemanagement.entity.CourseEntity;
import com.developer.employeemanagement.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository <EmployeeEntity, Long> {
    List<EmployeeEntity> findByCompanyNameAndCompanyAddress(String companyName, String companyAddress);

    //Danh sach nhan vien hoc 1 khoa hoc trong 1 cong ty
    @Query("Select e from EmployeeEntity e\n" +
            "inner join CompanyEntity c on c.id = e.company.id\n" +
            "inner join CourseEntity co on co.company.id = c.id\n" +
            "where c.name = :companyName and co.name= :courseName")
    List<EmployeeEntity> findEmployeeEntitiesByCompanyNameAndCourses(String companyName, String courseName);

    @Query("SELECT e FROM EmployeeEntity e " +
            "WHERE (:companyName IS NULL OR e.company.name = :companyName)" +
            "and (:startWith IS NULL OR SUBSTRING(e.name, 1, 1) = :startWith)")
    List<EmployeeEntity> findEmployeeEntitiesByCompanyNameAndAddressStartsWith(String companyName, String startWith);



}
