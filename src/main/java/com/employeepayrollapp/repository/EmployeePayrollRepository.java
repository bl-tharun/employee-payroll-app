package com.employeepayrollapp.repository;

import com.employeepayrollapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeePayrollRepository extends JpaRepository<Employee, Integer> {
    @Query(
            value = """
    SELECT ep.*
    FROM employee_payroll ep
    JOIN employee_department ed
      ON ep.employee_id = ed.id
    WHERE ed.departments = :department
  """,
            nativeQuery = true
    )
    List<Employee> findEmployeeByDepartment(@Param("department") String department);

}
