// ================= Session Management ==================
/*
 * Session represents a logged-in user state.
 *
 * Why this class exists:
 * - Login is not permanent
 * - Session has a lifetime
 *
 * This introduces the idea of time-based state.
 */
public class Session {

    private String username;
    private long loginTime;
    private long timeoutMillis;

    public Session(String username) {
        this.username = username;
        this.loginTime = System.currentTimeMillis();
        this.timeoutMillis = 2 * 60 * 1000;   // 2 minutes
    }

    /*
     * Checks whether the session is still valid.
     */
    public boolean isExpired() {
        long current = System.currentTimeMillis();
        return (current - loginTime) > timeoutMillis;
    }

    public String toString() {
        return "Session active for user: " + username;
    }
}