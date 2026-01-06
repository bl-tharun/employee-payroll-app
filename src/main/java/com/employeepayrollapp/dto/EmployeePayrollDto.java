package com.employeepayrollapp.dto;

public class EmployeePayrollDto {
    public String name;
    public long salary;

    public EmployeePayrollDto() {
    }

    public EmployeePayrollDto(String name, long salary) {
        this.name = name;
        this.salary = salary;
    }
}
