package com.employeepayrollapp.controller;

import com.employeepayrollapp.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/emp")
public class EmployeePayrollController {
    private static final AtomicLong counter = new AtomicLong();

    @GetMapping("/get")
    public String testGet() {
        return "Hello world";
    }

    @PostMapping("/post")
    public Employee testPost(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Employee(counter.incrementAndGet(), name);
    }

    @PutMapping("/put/{id}")
    public String testPut(
            @PathVariable Long id,
            @RequestBody Employee employee
    ) {
        return "Employee " + id + " updated with name: " + employee.getName();
    }

    @DeleteMapping("/delete/{id}")
    public String testDelete(@PathVariable Long id) {
        return "Employee " + id + " got yeeted!";
    }

}
