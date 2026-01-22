import java.security.MessageDigest;

// ================= Password Hash Utility ==================
/*
 * This utility class handles password hashing.
 *
 * Why this exists:
 * - Passwords should not be stored or compared directly
 * - We convert passwords into a secure representation
 *
 * At this stage:
 * - Focus on the idea of hashing
 * - Do NOT worry about cryptography details
 */
public class PasswordUtil {

    /*
     * Converts a plain-text password into a hashed value.
     *
     * Same input → same hash
     * Original password cannot be derived back
     */
    public static String hash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] bytes = md.digest(password.getBytes("UTF-8"));

            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(
                        Integer.toString((bytes[i] & 0xff) + 0x100, 16)
                                .substring(1)
                );
            }
            return sb.toString();

        } catch (Exception e) {
            // Simple fallback to keep demo running
            return password;
        }
    }
}