// =================== Immutable Payslip ======================
/*
 * Payslip represents a finalized salary record.
 *
 * Key idea introduced here:
 * - Immutability
 *
 * Once a payslip is generated:
 * - Its data should never change
 * - Any operation (print / download) must use a copy
 *
 * Making the class final prevents inheritance-based modification.
 */
public final class Payslip implements Cloneable {

    private final String empId;
    private final String empName;
    private final String month;
    private final double netPay;

    private final Employee employee;               // Aggregation
    private final SalaryComponents components; 

    // Primary constructor used internally to initialize all fields
    public Payslip(String empId, String empName, String month, double netPay, Employee employee, SalaryComponents components) {
        // Assigning all final fields only once
        this.empId = empId;
        this.empName = empName;
        this.month = month;
        this.netPay = netPay;
        this.employee = employee;
        this.components = components;
    }

    /*
     * Constructor initializes all fields once.
     *
     * Fields are final, so values cannot be changed later.
     */
    // Simplified constructor when only basic payslip data is available
    public Payslip(String empId, String empName, String month, double netPay) {
        // Delegates to the main constructor with null references
        this(empId, empName, month, netPay, null, null);
    }

    // Constructor used when Payslip is created from domain objects
    public Payslip(Employee employee, SalaryComponents components, String month) {
        // Initializes identity later from employee object if needed
        this(null, null, month, 0.0, employee, components);
    }

    // Constructor used for Dashboard App
    public Payslip(String month, double netPay) {
        this(null, null, month, netPay);
    }

    /*
     * Only getters are provided.
     *
     * No setters ensure immutability.
     */
    public String getEmpId() { return empId; }

    public String getEmpName() { return empName; }

    public String getMonth() { return month; }

    public double getNetPay() { return netPay; }

    /*
     * Creates a safe copy of the payslip.
     *
     * Why cloning is needed:
     * - Original object should remain untouched
     * - Downloaded or printed version must be independent
     */
    public Object clone() {
        return new Payslip(empId, empName, month, netPay);
    }

    /*
     * Defines logical equality between two payslips.
     *
     * Two payslips are considered equal if:
     * - They belong to the same employee
     * - They are for the same month
     */
    public boolean equals(Object o) {

        if (o == this) {
            return true;
        }

        if (!(o instanceof Payslip)) {
            return false;
        }

        Payslip p = (Payslip) o;

        return this.empId.equals(p.empId)
                && this.month.equals(p.month);
    }

    /*
     * hashCode() is implemented to be consistent with equals().
     *
     * This is important when objects are used in collections.
     */
    public int hashCode() {
        int result = 17;

        result = 31 * result + empId.hashCode();
        result = 31 * result + month.hashCode();

        return result;
    }

    /*
     * Converts payslip data into readable text.
     *
     * Used for:
     * - Console printing
     * - File download
     */
    public String toString() {
        return "PAYSLIP\n"
                + "Employee ID   : " + empId + "\n"
                + "Employee Name : " + empName + "\n"
                + "Month         : " + month + "\n"
                + "Net Pay       : " + netPay + "\n";
    }
}
