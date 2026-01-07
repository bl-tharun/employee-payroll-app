package com.employeepayrollapp.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

public @Data class Employee {
    private int employeeId;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilePic;
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
}
