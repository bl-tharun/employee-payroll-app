import java.util.regex.Pattern;

// =============== Validation Service ==================
/*
 * ValidationService contains all input validation rules.
 *
 * Why this class exists:
 * - Validation logic should not be scattered
 * - Keeps main() clean and focused on flow
 *
 * This class represents a defensive boundary
 * between user input and application logic.
 */
public class ValidationService {

    /*
     * Sanitizes input before validation.
     *
     * Purpose:
     * - Remove accidental spaces
     * - Ensure consistent validation behavior
     */
    private static String sanitize(String input) {
        if (input == null) return "";
        return input.trim().replace(" ", "");
    }

    /*
     * Validates email format.
     *
     * Rule:
     * - Must follow standard email structure
     *
     * Throws EmailValidationException if invalid.
     */
    public static void validateEmail(String email) throws EmailValidationException {

        email = sanitize(email);

        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

        if (!Pattern.matches(regex, email)) {
            throw new EmailValidationException(
                    "Invalid email format. Example: abc@gmail.com"
            );
        }
    }

    /*
     * Validates Indian phone number.
     *
     * Rule:
     * - Exactly 10 digits
     * - Must start with 6, 7, 8, or 9
     */
    public static void validatePhone(String phone) throws PhoneValidationException {

        phone = sanitize(phone);

        String regex = "^[6-9][0-9]{9}$";

        if (!Pattern.matches(regex, phone)) {
            throw new PhoneValidationException(
                    "Invalid phone number. Must be 10 digits starting from 6–9"
            );
        }
    }

    /*
     * Validates password strength.
     *
     * Rules enforced:
     * - Minimum 8 characters
     * - At least one uppercase letter
     * - At least one lowercase letter
     * - At least one digit
     * - At least one special character
     */
    public static void validatePassword(String password)
            throws PasswordValidationException {

        password = sanitize(password);

        String regex =
                "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%!]).{8,}$";

        if (!Pattern.matches(regex, password)) {
            throw new PasswordValidationException(
                    "Weak password. Must contain:\n" +
                            "- 8 or more characters\n" +
                            "- uppercase letter\n" +
                            "- lowercase letter\n" +
                            "- number\n" +
                            "- special symbol (@ # $ % !)"
            );
        }
    }

    /*
     * Validates employee ID format.
     *
     * Rule:
     * - Must follow EMP-XXXX format
     */
    public static void validateEmployeeId(String empId)
            throws EmployeeIdValidationException {

        empId = sanitize(empId);

        String regex = "^EMP-[0-9]{4}$";

        if (!Pattern.matches(regex, empId)) {
            throw new EmployeeIdValidationException(
                    "Invalid Employee ID. Expected format: EMP-1234"
            );
        }
    }
}