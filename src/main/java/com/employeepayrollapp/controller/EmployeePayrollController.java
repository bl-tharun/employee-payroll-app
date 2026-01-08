package com.employeepayrollapp.controller;

import com.employeepayrollapp.dto.EmployeePayrollDto;
import com.employeepayrollapp.dto.ResponseDto;
import com.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService service;

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollDataById(@PathVariable int empId) {
        return new ResponseEntity<>(service.getEmployee(empId), HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<ResponseDto> getAll() {
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDto empData
    ) {
        return new ResponseEntity<>(service.addEmployee(empData), HttpStatus.CREATED);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(
            @PathVariable int empId,
            @RequestBody EmployeePayrollDto empData
    ) {
        return new ResponseEntity<>(service.updateEmployee(empId, empData), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable int empId) {
        service.deleteEmployee(empId);
        return new ResponseEntity<>("Deleted employee with id " + empId, HttpStatus.OK);
    }
}
