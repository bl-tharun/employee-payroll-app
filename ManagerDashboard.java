import java.util.ArrayList;
import java.util.Iterator;

// =============== Manager Dashboard ===================
/*
 * ManagerDashboard provides an aggregate view.
 *
 * Focus:
 * - Overall earnings
 * - Summary-level information
 */
public class ManagerDashboard implements Dashboard {

    /*
     * Displays manager-specific dashboard.
     *
     * Only aggregation logic is applied here.
     */
    public void display(ArrayList payslips, Employee employee) {

        System.out.println("\n=== MANAGER DASHBOARD ===");
        System.out.println("Manager: " + employee.getName());

        System.out.println("Dashboard Type: " + this.getClass().getName());

        // Calculate total team earnings
        double total = 0;
        Iterator it = payslips.iterator();
        while (it.hasNext()) {
            Payslip p = (Payslip) it.next();
            total += p.getNetPay();
        }

        System.out.println("\nTeam Total YTD Earnings: " + total);
    }
}