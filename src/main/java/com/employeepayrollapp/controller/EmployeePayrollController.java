package com.employeepayrollapp.controller;

import com.employeepayrollapp.dto.EmployeePayrollDto;
import com.employeepayrollapp.dto.ResponseDto;
import com.employeepayrollapp.service.EmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/employeepayrollservice")
public class EmployeePayrollController {

    @Autowired
    private EmployeePayrollService service;

    @GetMapping("/get/{empId}")
    public ResponseEntity<ResponseDto> getEmployeePayrollDataById(@PathVariable int empId) {
        ResponseDto responseDto = new ResponseDto
                ("Found!", service.getEmployeePayrollDataById(empId));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/get/department")
    public ResponseEntity<ResponseDto> getEmployeeByDepartments(
            @RequestParam(value = "department") String department
    ) {
        ResponseDto responseDto = new ResponseDto
                ("Got it!", service.getEmployeesByDepartment(department));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @GetMapping("/getall")
    public ResponseEntity<ResponseDto> getAll() {
        ResponseDto responseDto = new ResponseDto
                ("Got all!", service.getEmployeePayrollData());
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> addEmployeePayrollData(
            @Valid @RequestBody EmployeePayrollDto empData
    ) {
        ResponseDto responseDto = new ResponseDto
                ("Created Employee!", service.createEmployeePayrollData(empData));
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<ResponseDto> updateEmployeePayrollData(
            @PathVariable int empId,
            @RequestBody EmployeePayrollDto empData
    ) {
        ResponseDto responseDto = new ResponseDto
                ("Edited!", service.updateEmployeePayrollData(empId, empData));
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{empId}")
    public ResponseEntity<String> deleteEmployeePayrollData(@PathVariable int empId) {
        service.deleteEmployeePayrollData(empId);
        return new ResponseEntity<>("Deleted employee with id " + empId, HttpStatus.OK);
    }
}
