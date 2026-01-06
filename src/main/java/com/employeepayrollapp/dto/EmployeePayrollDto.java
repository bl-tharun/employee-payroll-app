package com.employeepayrollapp.dto;

public class EmployeePayrollDto {
    private int empId;
    private String name;

    public EmployeePayrollDto() {
    }

    public EmployeePayrollDto(int empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "id="+empId+":name="+name;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
