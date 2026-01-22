// ============== Payroll Service =================
/*
 * PayrollService contains salary calculation logic.
 *
 * Why this class exists:
 * - Business rules should not be inside main()
 * - Keeps calculations reusable and isolated
 *
 * This introduces the idea of a SERVICE class.
 */
class PayrollService {

    /*
     * Generates a payslip by:
     * - Creating salary components
     * - Applying calculation rules
     * - Returning a completed Payslip object
     */
    public Payslip generatePayslip(Employee employee, String month,
                                   double basic, double hra, double da, double allowances) {

        SalaryComponents sc = new SalaryComponents(basic, hra, da, allowances);

        // ---- Gross Salary Calculation ----
        double gross = basic + hra + da + allowances;

        // ---- Deductions ----
        sc.pf = basic * 0.12;         // Provident Fund (12%)
        sc.tax = gross * 0.10;        // Income Tax (10%) – demo rule

        // ---- Net Pay ----
        sc.netPay = gross - (sc.pf + sc.tax);

        return new Payslip(employee, sc, month);
    }
}