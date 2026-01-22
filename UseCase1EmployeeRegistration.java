import java.io.IOException;
import java.util.Scanner;

/*
 * ---------------- Main Class ----------------
 *
 * Entry point of Use Case 1.
 *
 * Execution Flow:
 * 1. Take input from user
 * 2. Validate input
 * 3. Create objects
 * 4. Persist data
 * 5. Display confirmation
 *
 * @author Developer
 * @version 1.0
 */
public class UseCase1EmployeeRegistration {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=== USE CASE 1: EMPLOYEE REGISTRATION ===");

        try {
            System.out.print("Enter Employee ID (EMP-XXXX): ");
            String empId = sc.nextLine();
            Validator.validateEmpId(empId);

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Email: ");
            String email = sc.nextLine();
            Validator.validateEmail(email);

            System.out.print("Enter Phone (10 digits starting 6-9): ");
            String phone = sc.nextLine();
            Validator.validatePhone(phone);

            System.out.print("Create Username: ");
            String username = sc.nextLine();

            System.out.print("Create Password: ");
            String password = sc.nextLine();

            /*
             * Objects are created only after all validations succeed.
             *
             * This ensures system consistency.
             */
            UserAccount account = new UserAccount(username, password);
            Employee employee = new Employee(empId, name, email, phone, account);

            // Save employee details
            employee.persist();

            // Confirmation output
            System.out.println("\n----------------------------------");
            System.out.println(employee);
            System.out.println("\nData persisted in file: employee_data.txt");
            System.out.println("----------------------------------");

        } catch (ValidationException e) {
            System.out.println("\nValidation Failed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("\nError saving employee data!");
        }
        sc.close();
    }
}