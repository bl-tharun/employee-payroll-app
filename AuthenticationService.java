import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// ================= Authentication Service ==================
/*
 * AuthenticationService handles login-related operations.
 *
 * Why this class exists:
 * - main() should not contain authentication logic
 * - Centralizes login rules and limits
 */
class AuthenticationService {

    /*
     * Map stores users using username as key.
     *
     * This simulates a data store.
     */
    private Map<String, User> users = new HashMap<>();
    private int maxAttempts = 3;

    public AuthenticationService() {

        /*
         * Predefined users for demonstration.
         *
         * Important idea:
         * - Different object types stored as User
         * - Actual behavior depends on runtime type
         */
        users.put("emp1", new RegularEmployee("emp1", "Emp@1234"));
        users.put("manager1", new Manager("manager1", "Mng@1234"));
    }

    /*
     * Handles the complete login flow.
     *
     * Steps:
     * 1. Accept credentials
     * 2. Validate using polymorphism
     * 3. Create session
     * 4. Show dashboard
     */
    public Session login() {

        Scanner sc = new Scanner(System.in);
        int attempts = 0;

        while (attempts < maxAttempts) {

            System.out.print("\nEnter Username: ");
            String username = sc.nextLine();

            System.out.print("Enter Password: ");
            String password = sc.nextLine();

            User user = users.get(username);

            /*
             * Polymorphism in action:
             * - authenticate() call is resolved at runtime
             */
            if (user != null && user.authenticate(username, password)) {

                System.out.println("\nLogin Successful!");
                System.out.println("Role: " + user.getRole());

                Session session = new Session(username);

                showDashboard(user.getRole());

                return session;
            }

            attempts++;
            System.out.println("Login Failed. Attempts remaining: " + (maxAttempts - attempts));
        }

        System.out.println("\nAccount temporarily locked due to 3 failed attempts.");
        return null;
    }

    /*
     * Displays dashboard based on user role.
     *
     * Role-based behavior is introduced here
     * in a simple and readable way.
     */
    private void showDashboard(String role) {

        System.out.println("\n======= DASHBOARD =======");

        if ("EMPLOYEE".equals(role)) {
            System.out.println("Employee Dashboard");
            System.out.println("View Payslip | Update Profile");

        } else if ("MANAGER".equals(role)) {
            System.out.println("Manager Dashboard");
            System.out.println("Approve Payslip | View Team Summary");
        }
    }
}