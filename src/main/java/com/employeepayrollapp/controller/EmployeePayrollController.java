package com.employeepayrollapp.controller;

import com.employeepayrollapp.dto.EmployeePayrollDto;
import com.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService service;

    @RequestMapping(value = {"", "/", "/get"})
    public ResponseEntity<String> getEmployeePayrollData() {
        return new ResponseEntity<>("Get call success", HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<List<EmployeePayrollDto>> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/get/{empId}")
    public ResponseEntity<String> getEmployeePayrollData(@PathVariable int empId) {
        String response = service.getEmployee(empId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> addEmployeePayrollData(
            @RequestBody EmployeePayrollDto employeePayrollDto
    ) {
        String response = service.addEmployee(employeePayrollDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<String> updateEmployeePayrollData(
            @PathVariable int empId,
            @RequestBody EmployeePayrollDto employeePayrollDto
    ) {
        String response = service.updateEmployee(empId, employeePayrollDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable int empId) {
        service.deleteEmployee(empId);
        return new ResponseEntity<>("Deleted employee with id " + empId, HttpStatus.OK);
    }
}
