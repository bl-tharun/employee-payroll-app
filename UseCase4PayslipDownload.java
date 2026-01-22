/*
 * ======================================================
 * USE CASE 4: PAYSLIP PRINT / DOWNLOAD
 * ======================================================
 *
 * Goal of this Use Case:
 * - Protect existing data from accidental modification
 * - Learn how objects can be safely copied
 * - Understand how object equality works
 *
 * New ideas introduced in UC4:
 * - Immutability
 * - Cloning objects
 * - equals() and hashCode()
 * - Simple file persistence
 *
 * This use case builds on:
 * - UC3: Payslip generation
 */

// =================== Main App ======================
/*
 * Main runner class for Use Case 4.
 *
 * Role of main():
 * - Demonstrate safe usage of a finalized object
 * - Coordinate cloning, validation, and persistence
 *
 * main() does NOT modify the original payslip.
 */
public class UseCase4PayslipDownload {

    /**
     * Entry point for payslip print / download use case.
     *
     * Execution Flow:
     * 1. Create original payslip
     * 2. Clone payslip for download
     * 3. Verify equality and identity
     * 4. Check download expiry
     * 5. Save payslip to files
     * 6. Print cloned payslip
     *
     * @author Developer
     * @version 4.0
     */
    public static void main(String[] args) {

        System.out.println("=== USE CASE 4: PAYSLIP PRINT / DOWNLOAD ===");

        // Existing generated payslip (read-only)
        Payslip original = new Payslip(
                "EMP-1010",
                "John David",
                "January 2026",
                48500.00
        );

        System.out.println("\nOriginal Payslip:");
        System.out.println(original);

        try {
            // Step 1: Create a safe copy
            Payslip downloadCopy = (Payslip) original.clone();

            // Step 2: Verify logical equality
            if (original.equals(downloadCopy)) {
                System.out.println("Verified: Download copy is equal to original.");
            }

            // Step 3: Compare hash codes
            System.out.println("Original hashcode : " + original.hashCode());
            System.out.println("Cloned   hashcode : " + downloadCopy.hashCode());

            // Step 4: Validate download token
            DownloadToken token = new DownloadToken();

            if (token.isExpired()) {
                System.out.println("Download link expired.");
                return;
            }

            // Step 5: Persist cloned payslip
            FileService fs = new FileService();

            String textFile = fs.savePayslipAsText(downloadCopy);
            String pdfFile = fs.savePayslipAsPdf(downloadCopy);

            // Step 6: Confirmation
            System.out.println("\nPayslip Download Successful.");
            System.out.println("Saved as text file: " + textFile);
            System.out.println("Saved as PDF file : " + pdfFile);

            // Step 7: Print cloned payslip
            System.out.println("\n--- Printed Payslip ---");
            System.out.println(downloadCopy);

        } catch (Exception e) {
            System.out.println("Error during payslip download.");
        }
    }
}