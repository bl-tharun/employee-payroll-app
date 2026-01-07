package com.employeepayrollapp.service;

import com.employeepayrollapp.dto.EmployeePayrollDto;
import com.employeepayrollapp.dto.ResponseDto;
import com.employeepayrollapp.exception.EmployeePayrollException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService {
    private final List<EmployeePayrollDto> empList = new ArrayList<>();

    public ResponseDto addEmployee(EmployeePayrollDto data) {
        empList.add(data);
        return new ResponseDto("Employee added successfully!", data);
    }

    public ResponseDto getEmployee(int empId) {
        EmployeePayrollDto data = empList.stream().filter(emp -> emp.getEmpId() == empId)
                .findFirst()
                .orElseThrow(() -> new EmployeePayrollException("Employee not found"));
        return new ResponseDto("Here you go", data);
    }

    public ResponseDto updateEmployee(int empId, EmployeePayrollDto updated) {
        EmployeePayrollDto old = empList
                .stream()
                .filter(emp -> emp.getEmpId() == empId)
                .findAny().orElse(null);
        empList.remove(old);
        if (old != null) {
            old.setName(updated.getName());
            return new ResponseDto("Update successful for id " + empId, updated);
        }
        return new ResponseDto("Not found", null);
    }

    public void deleteEmployee(int empId) {
        empList.removeIf(emp -> emp.getEmpId() == empId);
    }

    public List<EmployeePayrollDto> getAll() {
        return empList;
    }
}
