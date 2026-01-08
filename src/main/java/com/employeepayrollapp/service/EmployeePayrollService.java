package com.employeepayrollapp.service;

import com.employeepayrollapp.dto.EmployeePayrollDto;
import com.employeepayrollapp.dto.ResponseDto;
import com.employeepayrollapp.exception.EmployeePayrollException;
import com.employeepayrollapp.model.Employee;
import com.employeepayrollapp.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeePayrollService implements IEmployeePayrollService{
    @Autowired
    private EmployeePayrollRepository repository;

    @Override
    public Employee createEmployeePayrollData(EmployeePayrollDto employeePayrollDto) {
        return new Employee(employeePayrollDto);
    }

    @Override
    public Employee getEmployeePayrollDataById(int empId) {
        return repository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String department) {
        return repository.findEmployeeByDepartment(department);
    }

    @Override
    public Employee updateEmployeePayrollData(int empId, EmployeePayrollDto updated) {
        Employee old = repository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
        old.setName(updated.name);
        old.setSalary(updated.salary);
        old.setDepartments(updated.departments);
        old.setGender(updated.gender);
        old.setNote(updated.note);
        old.setProfilePic(updated.profilePic);
        old.setStartDate(updated.startDate);
        return old;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        Employee data = repository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
        repository.delete(data);
    }

    @Override
    public List<Employee> getEmployeePayrollData() {
        return repository.findAll();
    }
}
