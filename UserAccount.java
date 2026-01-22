/*
 * ---------------- UserAccount Class ----------------
 *
 * This class represents login-related information.
 *
 * Why this is a separate class:
 * - Employee details and login details are different concerns
 * - Keeps responsibilities small and clear
 *
 * This introduces the idea of COMPOSITION:
 * - An Employee HAS a UserAccount
 */
public class UserAccount {
    private String username;
    private String password;   // Plain text for now (will improve later)

    public UserAccount(String username, String password) {
        this.username = username;
        this.password = password;
    }

    /*
     * Getter exposes only what is necessary.
     * Internal data is protected.
     */
    public String getUsername() {
        return username;
    }

    /*
     * Used only for display purposes.
     */
    @Override
    public String toString() {
        return "UserAccount{username='" + username + "'}";
    }
}