package com.employeepayrollapp.model;

import com.employeepayrollapp.dto.EmployeePayrollDto;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employee_payroll")
public @Data class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private int employeeId;
    private String name;
    private long salary;
    private String gender;
    @Column(name = "start_date")
    private LocalDate startDate;
    private String note;
    @Column(name = "profile_pic")
    private String profilePic;
    @ElementCollection
    @CollectionTable(name = "employee_department", joinColumns = @JoinColumn(name = "id"))
    @Column(name = "departments")
    private List<String> departments;

    public Employee() {
    }

    public Employee(int employeeId, String name, long salary, String gender, LocalDate startDate, String note, String profilePic, List<String> departments) {
        this.employeeId = employeeId;
        this.name = name;
        this.salary = salary;
        this.gender = gender;
        this.startDate = startDate;
        this.note = note;
        this.profilePic = profilePic;
        this.departments = departments;
    }

    public Employee(EmployeePayrollDto employeePayrollDto) {
        this.updateEmployeeData(employeePayrollDto);
    }

    private void updateEmployeeData(EmployeePayrollDto employeePayrollDto) {
        this.name = employeePayrollDto.name;
        this.salary = employeePayrollDto.salary;
        this.departments = employeePayrollDto.departments;
        this.gender = employeePayrollDto.gender;
        this.note = employeePayrollDto.note;
        this.profilePic = employeePayrollDto.profilePic;
        this.startDate = employeePayrollDto.startDate;
    }
}
