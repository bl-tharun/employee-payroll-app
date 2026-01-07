package com.employeepayrollapp.dto;

import lombok.Data;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;
import java.util.List;

public @Data class EmployeePayrollDto {

    public int empId;

    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;

    @Min(value = 500, message = "Min wage should be more than 500")
    public long salary;

    public String gender;
    public LocalDate startDate;
    public String note;
    public String profilePic;
    public List<String> departments;
}
