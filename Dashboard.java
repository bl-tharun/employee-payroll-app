import java.util.ArrayList;

// =============== Dashboard Interface ===================
/*
 * Dashboard defines a common contract for all dashboards.
 *
 * Key idea introduced:
 * - Interface
 *
 * Why an interface:
 * - Different dashboards exist
 * - All dashboards must provide a display() method
 * - Caller should not depend on concrete implementations
 */
interface Dashboard {
    void display(ArrayList payslips, Employee employee);
}