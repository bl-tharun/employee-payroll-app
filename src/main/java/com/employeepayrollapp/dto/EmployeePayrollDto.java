package com.employeepayrollapp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public @Data class EmployeePayrollDto {
    public int empId;
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    public String name;
    @Min(value = 500, message = "Min wage should be more than 500")
    public long salary;
    @Pattern(regexp = "male|female", message = "Gender needs to be male or female")
    public String gender;
    @JsonFormat(pattern = "dd MM yyyy")
    @NotNull(message = "StartDate should not be empty")
    @PastOrPresent(message = "StartDate should be past or today's date")
    public LocalDate startDate;
    @NotBlank(message = "Note cannot be empty")
    public String note;
    @NotBlank(message = "ProfilePic cannot be empty")
    public String profilePic;
    @NotNull(message = "Departments cannot be empty")
    public List<String> departments;
}
