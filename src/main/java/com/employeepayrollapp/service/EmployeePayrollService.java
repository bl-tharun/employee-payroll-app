package com.employeepayrollapp.service;

import com.employeepayrollapp.dto.EmployeePayrollDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeePayrollService {
    private final List<EmployeePayrollDto> empList = new ArrayList<>();

    public String addEmployee(EmployeePayrollDto employeePayrollDto) {
        empList.add(employeePayrollDto);
        return employeePayrollDto.toString();
    }

    public String getEmployee(int empId) {
        EmployeePayrollDto data = empList.stream().filter(emp -> emp.getEmpId() == empId)
                .findAny().orElse(null);
        return data.toString();
    }

    public String updateEmployee(int empId, EmployeePayrollDto updated) {
        EmployeePayrollDto old = empList
                .stream()
                .filter(emp -> emp.getEmpId() == empId)
                .findAny().orElse(null);
        empList.remove(old);
        if (old != null)
            old.setName(updated.getName());
        return updated.toString();
    }

    public void deleteEmployee(int empId) {
        empList.removeIf(emp -> emp.getEmpId() == empId);
    }

    public List<EmployeePayrollDto> getAll() {
        return empList;
    }
}
