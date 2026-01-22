import java.io.FileWriter;
import java.io.IOException;

// =================== File Service ======================
/*
 * FileService handles saving payslip data to files.
 *
 * Why this class exists:
 * - File operations should not be inside Payslip
 * - Separates persistence from data representation
 */
class FileService {

    /*
     * Saves payslip as a text file.
     *
     * A unique filename is generated using timestamp
     * to avoid overwriting existing files.
     */
    public String savePayslipAsText(Payslip payslip) throws IOException {

        String fileName = "Payslip_" + payslip.getEmpId() + "_"
                + System.currentTimeMillis() + ".txt";

        FileWriter fw = new FileWriter(fileName);
        fw.write(payslip.toString());
        fw.close();

        return fileName;
    }

    /*
     * Saves payslip as a PDF file.
     *
     * Note:
     * - This is a simplified demo
     * - Content is plain text with .pdf extension
     */
    public String savePayslipAsPdf(Payslip payslip) throws IOException {

        String fileName = "Payslip_" + payslip.getEmpId() + "_"
                + System.currentTimeMillis() + ".pdf";

        FileWriter fw = new FileWriter(fileName);
        fw.write(payslip.toString());
        fw.close();

        return fileName;
    }
}