import java.util.regex.Pattern;

/*
 * ---------------- Validator Class ----------------
 *
 * This class is responsible ONLY for checking input correctness.
 *
 * Why we separate validation:
 * - Keeps main() clean and readable
 * - Avoids repeating validation logic
 *
 * Important idea:
 * - Validation logic does NOT belong to Employee
 * - Validation happens BEFORE objects are created
 */
public class Validator {

    /*
     * Checks whether an email follows a valid format.
     *
     * If the format is wrong:
     * - A ValidationException is thrown
     * - Program flow jumps to the catch block in main()
     */
    public static void validateEmail(String email) throws ValidationException {
        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        if (!Pattern.matches(regex, email)) {
            throw new ValidationException("Invalid Email Format!");
        }
    }

    /*
     * Validates Indian phone numbers.
     *
     * Rule:
     * - Must start with 6, 7, 8, or 9
     * - Must be exactly 10 digits
     */
    public static void validatePhone(String phone) throws ValidationException {
        String regex = "^[6-9]\\d{9}$";
        if (!Pattern.matches(regex, phone)) {
            throw new ValidationException("Invalid Indian Phone Number!");
        }
    }

    /*
     * Validates Employee ID format.
     *
     * Rule:
     * - Must follow EMP-XXXX where X is a digit
     */
    public static void validateEmpId(String empId) throws ValidationException {
        String regex = "EMP-\\d{4}";
        if (!Pattern.matches(regex, empId)) {
            throw new ValidationException("Invalid Employee ID! Expected format: EMP-XXXX");
        }
    }
}