// =============== Child Exceptions ==================
/*
 * Each child exception represents a specific validation failure.
 *
 * Why separate exception types:
 * - Clear identification of error cause
 * - Better readability and maintainability
 */
public class PasswordValidationException extends ValidationException {
    public PasswordValidationException(String message) {
        super(message);
    }
}
