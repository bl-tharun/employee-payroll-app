import java.util.ArrayList;
import java.util.Scanner;

// =============== Main App ===================
/*
 * Main runner class for Use Case 5.
 *
 * Role of main():
 * - Collect user input
 * - Prepare data
 * - Request appropriate dashboard
 * - Display dashboard
 */
public class UseCase5Dashboard {

    /**
     * Entry point for dashboard display.
     *
     * Execution Flow:
     * 1. Capture employee details
     * 2. Prepare payslip data
     * 3. Select dashboard at runtime
     * 4. Display dashboard output
     *
     * @author Developer
     * @version 5.0
     */
    public static void main(String[] args) {

        System.out.println("=== USE CASE 5: DASHBOARD DISPLAY ===");

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Employee Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Role (EMPLOYEE/MANAGER): ");
        String role = sc.nextLine();

        Employee emp = new Employee(id, name);

        // Sample payslip data for demonstration
        ArrayList payslips = new ArrayList();
        payslips.add(new Payslip("Jan", 30000));
        payslips.add(new Payslip("Feb", 32000));
        payslips.add(new Payslip("Mar", 31000));
        payslips.add(new Payslip("Apr", 33000));
        payslips.add(new Payslip("May", 34000));

        // Request dashboard based on role
        Dashboard dashboard = DashboardFactory.getDashboard(role);

        if (dashboard != null) {
            dashboard.display(payslips, emp);
        } else {
            System.out.println("Invalid Role");
        }
    }
}