import java.util.Scanner;

/*
 * ======================================================
 * USE CASE 3: PAYSLIP GENERATION
 * ======================================================
 *
 * Goal of this Use Case:
 * - Understand how multiple objects collaborate
 * - Learn HAS-A relationships between classes
 * - Separate calculation logic from data representation
 *
 * New ideas introduced in UC3:
 * - Aggregation
 * - Composition
 * - Service class for business logic
 *
 * This use case builds on:
 * - UC1: Object creation
 * - UC2: Object roles and responsibilities
 */

// ============== MAIN APP =================
/*
 * Main runner class for Use Case 3.
 *
 * Role of main():
 * - Collect input
 * - Create required objects
 * - Delegate calculations
 * - Display final output
 *
 * main() does NOT perform calculations itself.
 */
public class Usecase3PayslipGeneration {

    /**
     * Entry point for payslip generation.
     *
     * Execution Flow:
     * 1. Capture employee details
     * 2. Capture salary components
     * 3. Generate payslip via service
     * 4. Display formatted payslip
     *
     * @author Developer
     * @version 3.0
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== USE CASE 3: PAYSLIP GENERATION ===");

        // Employee details (assumed authenticated earlier)
        System.out.print("Enter Employee ID: ");
        String empId = sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        Employee employee = new Employee(empId, name);

        System.out.print("Enter Month (e.g., January 2026): ");
        String month = sc.nextLine();

        // Salary inputs
        System.out.print("Enter Basic Salary: ");
        double basic = sc.nextDouble();

        System.out.print("Enter HRA: ");
        double hra = sc.nextDouble();

        System.out.print("Enter DA: ");
        double da = sc.nextDouble();

        System.out.print("Enter Allowances: ");
        double allowances = sc.nextDouble();

        PayrollService payrollService = new PayrollService();

        Payslip payslip = payrollService.generatePayslip(
                employee,
                month,
                basic,
                hra,
                da,
                allowances
        );

        // Display final payslip
        System.out.println(payslip);
        sc.close();
    }
}