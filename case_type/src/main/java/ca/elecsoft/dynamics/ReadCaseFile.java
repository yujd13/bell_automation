package ca.elecsoft.dynamics;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class ReadCaseFile {

    public File file;

    public ReadCaseFile(File file) {
        this.file = file;
    }

    private String transform(String form) {
        String ans = form.trim();
        ans = ans.replace(" ", "");
        ans = ans.toUpperCase();
        ans = ans.trim();
        ans= ans.replace(" ", "");
        if (ans.length() == 0) {
            ans = "NULL";
        }
        return ans;
    }

    private String emptyHandler(XSSFCell cell) {
        String workOrderTypeS = "NULL";
        if (cell != null) {
            workOrderTypeS = cell.getStringCellValue();
        }
        return transform(workOrderTypeS);
    }

    public String[][] readInput() throws IOException, InvalidFormatException, IOException, InvalidFormatException {
        //implement read from the sample data file and
        XSSFWorkbook workbook = new XSSFWorkbook(this.file);
        XSSFSheet sheet = workbook.getSheet("Case sub type template");
        String[][] ans = new String[sheet.getLastRowNum()][7];

        int N = sheet.getLastRowNum();
        for (int i = 1; i <= N; i++) {
            XSSFRow row = sheet.getRow(i);
            int caseSubTypeI = 1;
            int caseTypeI = 3;
            int processI = 8;
            int priorityI = 7;
            int customerTypeI = 4;
            int workOrderTypeI = 5;
            int workOrderSubTypeI = 6;

            XSSFCell caseSubType = row.getCell(caseSubTypeI);
            XSSFCell caseType = row.getCell(caseTypeI);
            XSSFCell process = row.getCell(processI);
            XSSFCell customerType = row.getCell(customerTypeI);
            XSSFCell workOrderType = row.getCell(workOrderTypeI);
            XSSFCell workOrderSubType = row.getCell(workOrderSubTypeI);
            XSSFCell priority = row.getCell(priorityI);

            String caseSubTypeS = emptyHandler(caseSubType);
            String caseTypeS = emptyHandler(caseType);
            String customerTypeS = emptyHandler(customerType);
            String priorityS = emptyHandler(priority);
            String workOrderTypeS = emptyHandler(workOrderType);
            String workOrderSubTypeS = emptyHandler(workOrderSubType);
            String processS = emptyHandler(process);


            ans[i - 1][0] = caseSubTypeS + "_CASESUBTYPE";
            ans[i - 1][1] = caseTypeS + "_CASETYPE";
            ans[i - 1][2] = processS + "_PROCESS";
            ans[i - 1][3] = customerTypeS +"_CTYPE";
            ans[i - 1][4] = workOrderTypeS +"_WTYPE";
            ans[i - 1][5] = workOrderSubTypeS +"_WSTYPE";
            ans[i - 1][6] = priorityS+"_PRIORITY";
        }
        return ans;
    }


    public static void main(String[] args) throws IOException, InvalidFormatException {
        Prop prop = Prop.getInstance();
        ReadCaseFile rcf = new ReadCaseFile(new File(prop.loadProp(prop.getCASETYPE_FILE())));
        String[][] ans = rcf.readInput();

        for (String[] x : ans) {
            System.out.println(Arrays.toString(x));
        }


    }
}
