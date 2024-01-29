package com.developer.employeemanagement.repository;

import com.developer.employeemanagement.entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<CompanyEntity, Long> {
}
