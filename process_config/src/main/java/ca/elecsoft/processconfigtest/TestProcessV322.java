package ca.elecsoft.processconfigtest;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;

public class TestProcessV322 {

    public static final String SPLIT = "|";
    public static final String BLANK = "BLANK";

    public static String readCell(XSSFCell cell) {
        String value = BLANK;
        if (cell != null && cell.getCellTypeEnum().toString().equals("STRING")) {
            value = cell.getStringCellValue().trim();
            value = value.replace("\n", "");
        } else if (cell != null && cell.getCellTypeEnum().toString().equals("NUMERIC")) {
            value = String.valueOf(Math.round(cell.getNumericCellValue()));
        } else if (cell != null && cell.getCellTypeEnum().toString().equals("BLANK")) {

        } else if (cell != null && cell.getCellTypeEnum().toString().equals("FORMULA")) {
            switch (cell.getCachedFormulaResultType()) {
                case Cell.CELL_TYPE_NUMERIC:
                    value = String.valueOf(Math.round(cell.getNumericCellValue()));
                    break;
                case Cell.CELL_TYPE_STRING:
                    value = cell.getRichStringCellValue().getString().trim();
                    break;
            }

        } else if (cell != null && cell.getCellTypeEnum().toString().equals("BOOLEAN")) {
            value = cell.getBooleanCellValue() ? "TRUE" : "FALSE";
        } else if (cell != null) {
            System.out.println(cell.getCellTypeEnum().toString());
            value = "ERROR";
        }
        return value;
    }

    public static void main(String[] args) throws IOException, InvalidFormatException {
        File processConfig = new File("./assets/ProcessV322.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(processConfig);
        XSSFSheet expected = workbook.getSheet("ExpectedData");

        XSSFSheet actual = workbook.getSheet("Process Advanced Find View");
        int N = expected.getLastRowNum();
//        int N = 1;
        int A = expected.getRow(0).getLastCellNum();
        if (expected.getLastRowNum() != actual.getLastRowNum() && expected.getRow(0).getLastCellNum() == actual.getRow(0).getLastCellNum()) {

            System.out.println("Error row size is different or Error col size is different");
        }
        String[] headers = new String[A];
        System.out.println("Process Name" + SPLIT + " Sheet Field Label | CRM UI Label" + SPLIT + "Actual" + SPLIT + "Expected" + SPLIT + "Pass/Fail");

        for (int i = 0; i < N; i++) {
            XSSFRow actualrow = actual.getRow(i);
            XSSFRow expectedrow = expected.getRow(i);
            int M = expectedrow.getLastCellNum();


            String expectedProcess = readCell(expectedrow.getCell(0));
            String formula = "=IF(TRIM(RC[-2])=TRIM(RC[-1]),\"true\", \"false\")";

            for (int j = 0; j < M; j++) {
                XSSFCell actualCell = actualrow.getCell(j);
                XSSFCell expectedCell = expectedrow.getCell(j);

                String a = readCell(actualCell);
                String e = readCell(expectedCell);

                if (i == 0) {
                    headers[j] = e + "|" + a;
                } else {

                    System.out.println(expectedProcess + SPLIT + headers[j] + SPLIT + a + SPLIT + e + SPLIT + formula);

                }

            }


        }
    }
}