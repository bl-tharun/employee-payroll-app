import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

// =============== Employee Dashboard ===================
/*
 * EmployeeDashboard provides a personal view of payslip data.
 *
 * Focus:
 * - Recent payslips
 * - Year-to-date earnings
 */
public class EmployeeDashboard implements Dashboard {

    /*
     * Displays employee-specific dashboard.
     *
     * Steps performed:
     * - Sort payslips
     * - Display top entries
     * - Calculate total earnings
     */
    public void display(ArrayList payslips, Employee employee) {

        System.out.println("\n=== EMPLOYEE DASHBOARD ===");
        System.out.println("Welcome, " + employee.getName());

        // Display runtime implementation information
        System.out.println("Dashboard Type: " + this.getClass().getName());

        // Sort payslips in descending order of net pay
        Collections.sort(payslips, new Comparator() {
            public int compare(Object o1, Object o2) {
                Payslip p1 = (Payslip) o1;
                Payslip p2 = (Payslip) o2;
                return (int)(p2.getNetPay() - p1.getNetPay());
            }
        });

        // Display only top 3 payslips
        System.out.println("\nRecent Payslips (Top 3):");
        int count = 0;
        Iterator it = payslips.iterator();
        while (it.hasNext() && count < 3) {
            Payslip p = (Payslip) it.next();
            System.out.println(p);
            count++;
        }

        // Calculate Year-To-Date earnings
        double total = 0;
        Iterator it2 = payslips.iterator();
        while (it2.hasNext()) {
            Payslip p = (Payslip) it2.next();
            total += p.getNetPay();
        }

        System.out.println("\nYear-To-Date Earnings: " + total);
    }
}