import java.util.Scanner;

// =============== MAIN APP ==================
/*
 * Main runner class for Use Case 6.
 *
 * Role of main():
 * - Capture user input
 * - Delegate validation
 * - Handle validation failures gracefully
 *
 * main() does NOT perform validation itself.
 */

public class UseCase6InputValidation {

    /**
     * Entry point for input validation use case.
     *
     * Execution Flow:
     * 1. Read user inputs
     * 2. Validate each input
     * 3. Stop immediately if validation fails
     * 4. Proceed only when all inputs are valid
     *
     * @author Developer
     * @version 6.0
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== USE CASE 6: INPUT VALIDATION ===");

        try {
            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = sc.nextLine();
            ValidationService.validateEmployeeId(empId);

            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            ValidationService.validateEmail(email);

            System.out.print("Enter Phone Number: ");
            String phone = sc.nextLine();
            ValidationService.validatePhone(phone);

            System.out.print("Create Password: ");
            String password = sc.nextLine();
            ValidationService.validatePassword(password);

            System.out.println(
                    "\n All inputs are VALID. Registration/Login can proceed."
            );

        } catch (ValidationException ex) {
            // Single catch block handles all validation failures
            System.out.println("\n Validation Failed:");
            System.out.println(ex.getMessage());
        }
    }
}