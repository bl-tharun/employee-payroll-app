package com.employeepayrollapp.dto;

import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

public @Data class EmployeePayrollDto {

    private int empId;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    private String name;

    @Min(value = 500, message = "Min wage should be more than 500")
    private long salary;

    @Override
    public String toString() {
        return "name="+name+":salary"+salary;
    }
}
