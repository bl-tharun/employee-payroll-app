import java.io.FileWriter;
import java.io.IOException;

/*
 * ---------------- Employee Class ----------------
 *
 * This class represents an Employee entity.
 *
 * Core OOP concept introduced here:
 * - Encapsulation
 *
 * Data is kept private and controlled through the class.
 */
public class Employee {

    private String empId;
    private String name;
    private String email;
    private String phone;

    // Employee HAS a UserAccount
    private UserAccount account;

    /*
     * Constructor is used to create a fully initialized Employee object.
     *
     * Important idea:
     * - Object creation happens only after validation succeeds
     */
    public Employee(String empId, String name, String email, String phone, UserAccount account) {
        this.empId = empId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.account = account;
    }

    public Employee(String empId, String name) {
        this.empId = empId;
        this.name = name;
    }

    /*
     * Converts Employee data into a readable format.
     *
     * This avoids printing details manually in main().
     */
    @Override
    public String toString() {
        return "Employee Registered Successfully:\n" +
                "Employee ID : " + empId + "\n" +
                "Name        : " + name + "\n" +
                "Email       : " + email + "\n" +
                "Phone       : " + phone + "\n" +
                "Username    : " + account.getUsername();
    }

    /*
     * Saves employee data into a file.
     *
     * Purpose:
     * - Simulates persistence
     * - Shows that objects can manage their own data
     *
     */
    public void persist() throws IOException {
        FileWriter writer = new FileWriter("employee_data.txt", true);
        writer.write(empId + "," + name + "," + email + "," + phone + "," + account.getUsername() + "\n");
        writer.close();
    }

    public String getEmpId() {
        return empId;
    }

    public String getName() {
        return name;
    }
}