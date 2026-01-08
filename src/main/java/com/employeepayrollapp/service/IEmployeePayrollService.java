package com.employeepayrollapp.service;

import com.employeepayrollapp.dto.EmployeePayrollDto;
import com.employeepayrollapp.model.Employee;

import java.util.List;

public interface IEmployeePayrollService {
    List<Employee> getEmployeePayrollData();
    Employee getEmployeePayrollDataById(int empId);
    List<Employee> getEmployeesByDepartment(String department);
    Employee createEmployeePayrollData(EmployeePayrollDto employeePayrollDto);
    Employee updateEmployeePayrollData(int empId,
                                       EmployeePayrollDto employeePayrollDto);
    void deleteEmployeePayrollData(int empId);
}
