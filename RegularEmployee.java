// ================= Regular Employee ==================
/*
 * Represents a regular employee user.
 *
 * Inheritance:
 * - RegularEmployee IS-A User
 *
 * This class provides its own implementation
 * of the authenticate() method.
 */
public class RegularEmployee extends User {

    public RegularEmployee(String username, String password) {
        super(username, password, "EMPLOYEE");
    }

    /*
     * Authentication logic specific to regular employees.
     */
    public boolean authenticate(String username, String password) {
        return this.username.equals(username)
                && this.passwordHash.equals(PasswordUtil.hash(password));
    }
}