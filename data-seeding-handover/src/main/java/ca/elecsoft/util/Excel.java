package ca.elecsoft.util;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Excel {
    public static Excel INSTANCE;

    private Excel() {

    }

    public static Excel getInstance() {
        if (INSTANCE == null) {
            return new Excel();
        }
        return INSTANCE;
    }

    private boolean isFormula(String formula) {
        if (formula.startsWith("=")) {
            return true;
        }
        return false;
    }

    public List<List<String>> readFile(File dataSeedFile) throws IOException, InvalidFormatException {
        XSSFWorkbook workbook = new XSSFWorkbook(dataSeedFile);
        XSSFSheet sheet = workbook.getSheetAt(0);
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            List<String> list = new ArrayList<>();
            XSSFRow row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                Cell cell = row.getCell(j);
                CellType cellType = cell.getCellTypeEnum();
                String value = "";
                if (cellType.toString().equals("STRING")) {
                    value = cell.getStringCellValue();
                } else if (cellType.toString().equals("NUMERIC")) {
                    value = String.valueOf( cell.getNumericCellValue());

                }
                list.add(value);
            }
            ans.add(list);
        }

        workbook.close();

        return ans;
    }


    public void appendWorkOrderNoToFile(File dataSeedFile, int index, String workOrderNumber) throws IOException, InvalidFormatException {
        FileInputStream file = new FileInputStream(dataSeedFile);
        XSSFWorkbook workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        XSSFRow row = sheet.getRow(index + 1);
        XSSFCell cell = row.getCell(17);
        if (cell == null) {
            cell = row.createCell(17);
        }
        cell.setCellValue(workOrderNumber);
        file.close();
        FileOutputStream fileOut = new FileOutputStream(dataSeedFile);  //"output.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
    }


    public void writeFile(String fileName, String sheetName, List<String> headers, List<List<String>> rowValues) throws IOException {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet(sheetName);

        XSSFRow row = sheet.createRow(0);
        for (int i = 0; i < headers.size(); i++) {
            XSSFCell cell = row.createCell(i);
            cell.setCellValue(headers.get(i));
        }

        for (int i = 0; i < rowValues.size(); i++) {
            XSSFRow tRow = sheet.createRow(i + 1);
            List<String> rowList = rowValues.get(i);
            for (int k = 0; k < rowList.size(); k++) {
                XSSFCell cell = tRow.createCell(k);
                String word = rowList.get(k);

                if (word != null && isFormula(word.trim())) {
                    int offset = i + 2;
                    word = word.replaceFirst("=", "");
                    word = word.replaceAll("X", String.valueOf(offset));
                    word = word.replaceAll("X", String.valueOf(offset));
                    System.out.println(word);
                    cell.setCellFormula(word);
                } else {
                    cell.setCellValue(word);
                }
            }
        }


        FileOutputStream fileOut = new FileOutputStream(fileName);  //"output.xlsx");
        workbook.write(fileOut);
        fileOut.close();

        // Closing the workbook
        workbook.close();


    }


}
