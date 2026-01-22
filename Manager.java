// ================= Manager ==================
/*
 * Represents a manager user.
 *
 * This class also extends User,
 * but is treated differently based on role.
 */
public class Manager extends User {

    public Manager(String username, String password) {
        super(username, password, "MANAGER");
    }

    /*
     * Manager authentication logic.
     *
     * Method signature is same as parent,
     * but implementation belongs to this class.
     */
    public boolean authenticate(String username, String password) {
        return this.username.equals(username)
                && this.passwordHash.equals(PasswordUtil.hash(password));
    }
}