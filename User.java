// ================= Abstract User Class ==================
/*
 * User represents a generic system user.
 *
 * Key concept introduced:
 * - Abstract class
 *
 * Why this class exists:
 * - Different users exist (Employee, Manager)
 * - They share common data and behavior
 * - But authentication logic must be defined by each type
 */
public abstract class User {

    protected String username;
    protected String passwordHash;
    protected String role;

    /*
     * Constructor initializes shared user data.
     *
     * Password is immediately hashed.
     */
    public User(String username, String password, String role) {
        this.username = username;
        this.passwordHash = PasswordUtil.hash(password);
        this.role = role;
    }

    /*
     * Abstract method:
     * - Forces subclasses to provide authentication logic
     * - Enables runtime method selection
     */
    public abstract boolean authenticate(String username, String password);

    public String getRole() {
        return role;
    }
}