/*
 * ======================================================
 * USE CASE 2: EMPLOYEE AUTHENTICATION & LOGIN
 * ======================================================
 *
 * Goal of this Use Case:
 * - Introduce inheritance and polymorphism
 * - Show how different user types share common behavior
 * - Demonstrate a simple authentication flow
 *
 * New ideas introduced here:
 * - Abstract class
 * - Method overriding
 * - Runtime decision-making
 *
 * This use case builds directly on UC1.
 */
public class UseCase2LoginApp {

    /**
     * Entry point for authentication use case.
     *
     * Execution Flow:
     * - Trigger login
     * - Receive session
     * - Validate session state
     *
     * @author Developer
     * @version 2.0
     */
    public static void main(String[] args) {

        System.out.println("=== USE CASE 2: EMPLOYEE AUTHENTICATION & LOGIN ===");

        AuthenticationService auth = new AuthenticationService();
        Session session = auth.login();

        if (session != null) {

            System.out.println("\n" + session.toString());

            if (session.isExpired()) {
                System.out.println("Session expired. Please login again.");
            } else {
                System.out.println("Session active and valid.");
            }
        }
    }
}