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
public class EmployeePayrollService {
    @Autowired
    private EmployeePayrollRepository repository;

    public ResponseDto addEmployee(EmployeePayrollDto employeePayrollDto) {
        Employee empData = new Employee(employeePayrollDto);
        return new ResponseDto("Employee added successfully!", repository.save(empData));
    }

    public ResponseDto getEmployee(int empId) {
        Employee data = repository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
        return new ResponseDto("Here you go", data);
    }

    public ResponseDto updateEmployee(int empId, EmployeePayrollDto updated) {
        Employee old = repository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
        old.setName(updated.name);
        old.setSalary(updated.salary);
        old.setDepartments(updated.departments);
        old.setGender(updated.gender);
        old.setNote(updated.note);
        old.setProfilePic(updated.profilePic);
        old.setStartDate(updated.startDate);
        return new ResponseDto("Updated!", old);
    }

    public void deleteEmployee(int empId) {
        Employee data = repository.findById(empId)
                .orElseThrow(() -> new EmployeePayrollException("Employee Not Found"));
        repository.delete(data);
    }

    public ResponseDto getAll() {
        List<Employee> all = repository.findAll();
        return new ResponseDto("Gotcha!", all);
    }
}
