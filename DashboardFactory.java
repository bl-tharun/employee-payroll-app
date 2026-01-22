// =============== Dashboard Factory ===================
/*
 * DashboardFactory is responsible for creating dashboards.
 *
 * Key idea introduced:
 * - Factory pattern
 *
 * Why this is needed:
 * - Object creation logic is centralized
 * - main() does not need to know concrete classes
 */
public class DashboardFactory {

    public static Dashboard getDashboard(String role) {

        if ("EMPLOYEE".equals(role)) {
            return new EmployeeDashboard();

        } else if ("MANAGER".equals(role)) {
            return new ManagerDashboard();
        }

        return null;
    }
}