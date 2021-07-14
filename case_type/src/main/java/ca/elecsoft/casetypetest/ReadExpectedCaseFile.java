package ca.elecsoft.casetypetest;

import ca.elecsoft.dynamics.Prop;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

public class ReadExpectedCaseFile {

    public static void main(String[] args) throws IOException, InvalidFormatException {
        ReadExpectedCaseFile f = new ReadExpectedCaseFile();
        System.out.println(f.read().size());

    }

    public HashMap<String, CaseType> read() throws IOException, InvalidFormatException {


        Prop p = Prop.getInstance();
        XSSFWorkbook book = new XSSFWorkbook(new File(p.loadProp(p.getCASE_ACTUAL_FILE())));
        XSSFSheet sheet = book.getSheetAt(0);

        String[][] ans = new String[sheet.getLastRowNum()][7];

        HashMap<String, CaseType> map = new HashMap<>();

        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            int caseSubTypeI = 3;
            int caseTypeI = 5;
            int processI = 7;
            int priorityI = 4;
            int customerTypeI = 6;
            int workOrderTypeI = 10;
            int workOrderSubTypeI = 9;

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

            CaseType c = new CaseType();

            c.setCase_sub_type_EN(caseSubTypeS);
            c.setCase_type(caseTypeS);
            c.setCustomer_type(customerTypeS);
            c.setPriority(priorityS);
            c.setWork_order_type(workOrderTypeS);
            c.setWork_order_sub_type(workOrderSubTypeS);
            c.setProcess(processS);

            map.put(caseSubTypeS, c);

        }

        return map;

    }

    private String transform(String form) {
        String ans = form.trim();
        ans = ans.replace(" ", "");
        ans = ans.toUpperCase();
        ans = ans.trim();
        ans = ans.replace(" ", "");
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
}
