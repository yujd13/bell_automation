package ca.elecsoft.reader;

import ca.elecsoft.model.version.twozerofourA.ProdCadEVersionA;
import ca.elecsoft.model.version.twozerothreeE.ProdCadAVersionE;
import ca.elecsoft.model.version.twozerothreeE.ProdCadEVersionE;
import ca.elecsoft.util.HibernateUtilVersionA;
import ca.elecsoft.util.HibernateUtilVersionE;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * This class is for reading of the expected  product catalogue file
 */
public class ReadAccountEntityVersionA {
    public static int COL_START = 3;

    public static String readCell(XSSFCell cell, XSSFWorkbook workbook) {
        String value = "NULL";
        if (cell != null && cell.getCellTypeEnum().toString().equals("STRING")) {
            value = cell.getStringCellValue().trim();
        } else if (cell != null && cell.getCellTypeEnum().toString().equals("NUMERIC")) {
            value = String.valueOf(Math.round(cell.getNumericCellValue()));
        } else if (cell != null && cell.getCellTypeEnum().toString().equals("BLANK")) {

        } else if (cell != null && cell.getCellTypeEnum().toString().equals("FORMULA")) {
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            CellValue cv = evaluator.evaluate(cell);

            switch (cv.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    value = String.valueOf(cv.getBooleanValue());
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    value = String.valueOf(cv.getNumberValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    value = String.valueOf(cv.getStringValue());
                    break;
                case Cell.CELL_TYPE_BLANK:
                    break;
                case Cell.CELL_TYPE_ERROR:
                    break;

                // CELL_TYPE_FORMULA will never happen
                case Cell.CELL_TYPE_FORMULA:
                    break;
            }

        } else if (cell != null && cell.getCellTypeEnum().toString().equals("BOOLEAN")) {
            value = cell.getBooleanCellValue() ? "TRUE" : "FALSE";
        } else if (cell != null) {
            System.out.println(cell.getRowIndex() + "," + cell.getColumnIndex() );
            System.out.println(cell.getCellTypeEnum().toString());
            value = "ERROR";
        }

        if (value.length() < 1) {
            value = "NULL";
        }

        return value;
    }

    public static String getModelHelper(String header, String header2) {
        StringBuffer sb = new StringBuffer("");
        String[] split = header2.split("\\|");
        String[] split2 = header.split("\\|");

        String d = "Boolean %sB =  a.get%s().trim().toLowerCase().equals(e.get%s().trim().toLowerCase());\n";
        String logformat = "Reporter.log( e.getProductid() + \"|\" +  \"%s\" +  \"|\" +  \"%s\" +\"|\"+  a.get%s() +\"|\"+ e.get%s() +\"|\"+ %sB);\n";
        int i = 0;
        for (String x : split) {
            sb.append(String.format(d, transform(x), transform(x), transform(split2[i])));
            sb.append(String.format(logformat, split2[i], x, transform(x), transform(split2[i]), transform(x)));
            i++;
        }


        return sb.toString();
    }


    public static void getModelGeneral(File a, File b) throws IOException, InvalidFormatException {
        XSSFWorkbook book = new XSSFWorkbook(a);
        XSSFSheet sheet = book.getSheetAt(0);
        int N = sheet.getLastRowNum();
        String header = "";
        if (N > 0) {
            for (int i = 0; i < 1; i++) {
                XSSFRow row = sheet.getRow(i);
                int M = row.getLastCellNum();
                String input = "";
                for (int j = 0; j < M; j++) {
                    XSSFCell cell = row.getCell(j);
                    String val = readCell(cell, book);
                    input += val + "|";
                }

                if (i == 0) {
                    header = input;
                }
            }
        }
        XSSFWorkbook book2 = new XSSFWorkbook(b);
        XSSFSheet sheet2 = book2.getSheetAt(0);
        int N2 = sheet2.getLastRowNum();
        String header2 = "";
        for (int i = 0; i < 1; i++) {
            XSSFRow row = sheet2.getRow(i);
            int M = row.getLastCellNum();
            String input = "";
            for (int j = 0; j < M; j++) {
                XSSFCell cell = row.getCell(j);
                String val = readCell(cell, book2);
                input += val + "|";
            }

            if (i == 0) {
                header2 = input;
            }
        }

//        System.out.println(header);
//        System.out.println(header2);
        System.out.println(getModelHelper(header, header2));


    }


    public static void getModel() throws IOException, InvalidFormatException {
        String path = "./src/main/resources/dataMigration/CRMExtracts/Account-Export-2.xlsx";
        File accountFile = new File(path);
        XSSFWorkbook book = new XSSFWorkbook(accountFile);
        XSSFSheet sheet = book.getSheetAt(0);
        int N = sheet.getLastRowNum();
        String header = "";
        if (N > 0) {
            for (int i = 0; i < 1; i++) {
                XSSFRow row = sheet.getRow(i);
                int M = row.getLastCellNum();
                String input = "";
                for (int j = COL_START; j < M; j++) {
                    XSSFCell cell = row.getCell(j);
                    String val = readCell(cell, book);
                    input += val + "|";
                }

                if (i == 0) {
                    header = input;
                }

                System.out.println(getModelHelper(header, input));


            }
        }
    }


    public static String setModelHelper(String input) {
        StringBuffer sb = new StringBuffer("");
        String[] split = input.split("\\|");

        String d = "a.set%s()\n";
        for (String x : split) {
            sb.append(String.format(d, transform(x)));
        }

        return sb.toString();
    }

    public static void setModelGeneral(File f) throws IOException, InvalidFormatException {
        XSSFWorkbook book = new XSSFWorkbook(f);
        XSSFSheet sheet = book.getSheetAt(0);
        int N = sheet.getLastRowNum();
        String header = "";
        if (N > 0) {
            for (int i = 0; i < 1; i++) {
                XSSFRow row = sheet.getRow(i);
                int M = row.getLastCellNum();
                String input = "";
                for (int j = 0; j < M; j++) {
                    XSSFCell cell = row.getCell(j);
                    String val = readCell(cell, book);
                    input += val + "|";
                }

                if (i == 0) {
                    header = input;
                }

                System.out.println(setModelHelper(input));


            }
        }
    }

    public static void setModel() throws IOException, InvalidFormatException {
        String path = "./src/main/resources/dataMigration/CRMExtracts/Account-Export-2.xlsx";
        File accountFile = new File(path);
        XSSFWorkbook book = new XSSFWorkbook(accountFile);
        XSSFSheet sheet = book.getSheetAt(0);
        int N = sheet.getLastRowNum();
        String header = "";
        if (N > 0) {
            for (int i = 0; i < 1; i++) {
                XSSFRow row = sheet.getRow(i);
                int M = row.getLastCellNum();
                String input = "";
                for (int j = COL_START; j < M; j++) {
                    XSSFCell cell = row.getCell(j);
                    String val = readCell(cell, book);
                    input += val + "|";
                }

                if (i == 0) {
                    header = input;
                }

                System.out.println(setModelHelper(input));


            }
        }
    }

    public static String insertDatabaseSQLHelper(String headers, String values) {
        StringBuffer sb = new StringBuffer("INSERT INTO `crm`.`account` (\n");
        String[] split = headers.split("\\|");
        String[] vals = values.split("\\|");

        String d = " `%s`, \n";
        String data = " \"%s\", \n";
        for (String x : split) {
            sb.append(String.format(d, x));
        }
        sb.delete(sb.length() - 3, sb.length());

        sb.append(")");

        sb.append("VALUES (\n");
        for (String x : vals) {
            sb.append(String.format(data, x));
        }
        sb.delete(sb.length() - 3, sb.length());

        sb.append(");");


        return sb.toString();
    }

    public static String createPropertyHelper(String input) {
        StringBuffer sb = new StringBuffer("");
        String[] split = input.split("\\|");

        String d = "<property name=\"%s\"></property>\n";
        for (String x : split) {
            sb.append(String.format(d, x));
        }

        return sb.toString();

    }

    public static void createPropertyGeneral(File f) throws IOException, InvalidFormatException {
        XSSFWorkbook book = new XSSFWorkbook(f);
        XSSFSheet sheet = book.getSheetAt(0);
        int N = sheet.getLastRowNum();
        String header = "";
        if (N > 0) {
            for (int i = 0; i < 1; i++) {
                XSSFRow row = sheet.getRow(i);
                int M = row.getLastCellNum();
                String input = "";
                for (int j = 0; j < M; j++) {
                    XSSFCell cell = row.getCell(j);
                    String val = readCell(cell, book);
                    input += val + "|";
                }

                if (i == 0) {
                    header = input;
                }

                String sql = createPropertyHelper(header);
                System.out.println(sql);


            }
        }
    }

    public static void createPropertyGeneral() throws IOException, InvalidFormatException {
        String path = "./src/main/resources/dataMigration/CRMExtracts/Account-Export.xlsx";
        File accountFile = new File(path);
        XSSFWorkbook book = new XSSFWorkbook(accountFile);
        XSSFSheet sheet = book.getSheetAt(0);
        int N = sheet.getLastRowNum();
        String header = "";
        if (N > 0) {
            for (int i = 0; i < 1; i++) {
                XSSFRow row = sheet.getRow(i);
                int M = row.getLastCellNum();
                String input = "";
                for (int j = COL_START; j < M; j++) {
                    XSSFCell cell = row.getCell(j);
                    String val = readCell(cell, book);
                    input += val + "|";
                }

                if (i == 0) {
                    header = input;
                }

                String sql = createPropertyHelper(header);
                System.out.println(sql);


            }
        }
    }

    public static void insertDatabaseSQLProdCadE(File f) throws IOException, InvalidFormatException, SQLException {
        XSSFWorkbook book = new XSSFWorkbook(f);
        XSSFSheet sheet = book.getSheet("Sheet1");
        int N = sheet.getLastRowNum();
        XSSFRow row2 = sheet.getRow(0);
        int M = row2.getLastCellNum();
        HibernateUtilVersionA util = HibernateUtilVersionA.getINSTANCE();

        String header = "";
        if (N > 0) {
            for (int i = 0; i <= N; i++) {
                XSSFRow row = sheet.getRow(i);
                String input = "";
                for (int j = 0; j < M; j++) {
                    XSSFCell cell = row.getCell(j);
                    String val = readCell(cell, sheet.getWorkbook());
                    input += val + "|";
                }

                if (i == 0) {
                    header = input;
                }

                util.storeListProdCadE(input, util.buildProdCad(input, new ProdCadEVersionA()));
//                db.insertAccount(sql);


            }
        }

    }




    public static void insertDatabaseSQLProdCadA(File f) throws IOException, InvalidFormatException, SQLException {
        XSSFWorkbook book = new XSSFWorkbook(f);
        XSSFSheet sheet = book.getSheetAt(0);
        int N = sheet.getLastRowNum();
        XSSFRow row2 = sheet.getRow(0);
        int M = row2.getLastCellNum();
        HibernateUtilVersionE util = HibernateUtilVersionE.getINSTANCE();

        String header = "";
        if (N > 0) {
            for (int i = 0; i <= N; i++) {
                XSSFRow row = sheet.getRow(i);
                String input = "";
                for (int j = 0; j < M; j++) {
                    XSSFCell cell = row.getCell(j);
                    String val = readCell(cell, sheet.getWorkbook());
                    input += val + "|";
                }

                if (i == 0) {
                    header = input;
                }

                util.storeListProdCadA(input, util.buildProdCadA(input, new ProdCadAVersionE()));
//                db.insertAccount(sql);


            }
        }

    }

    public static void insertDatabaseSQLGeneral(File f) throws IOException, InvalidFormatException, SQLException {
        XSSFWorkbook book = new XSSFWorkbook(f);
        XSSFSheet sheet = book.getSheetAt(0);
        int N = sheet.getLastRowNum();
        XSSFRow row2 = sheet.getRow(0);
        int M = row2.getLastCellNum();
        String header = "";
        if (N > 0) {
            for (int i = 0; i <= N; i++) {
                XSSFRow row = sheet.getRow(i);
                String input = "";
                for (int j = 0; j < M; j++) {
                    XSSFCell cell = row.getCell(j);
                    String val = readCell(cell, sheet.getWorkbook());
                    input += val + "|";
                }

                if (i == 0) {
                    header = input;
                }

//                String sql = insertDatabaseSQLHelper(header, input);
                System.out.println(input);
//                HibernateUtil util = HibernateUtil.getINSTANCE();
//                util.storeListGeneral(input, HibernateUtil.buildProdCad(input, new ProdCadE()));
//                System.out.println(sql);
//                AccountDatabase db = AccountDatabase.getInstance();
//                db.insertAccount(sql);


            }
        }

    }


    public static void insertDatabaseSQL() throws IOException, InvalidFormatException, SQLException {
        String path = "./src/main/resources/dataMigration/CRMExtracts/Account-Export-2.xlsx";
        File accountFile = new File(path);
        XSSFWorkbook book = new XSSFWorkbook(accountFile);
        XSSFSheet sheet = book.getSheetAt(0);
        int N = sheet.getLastRowNum();
        String header = "";
        if (N > 0) {
            for (int i = 0; i <= N; i++) {
                XSSFRow row = sheet.getRow(i);
                int M = row.getLastCellNum();
                String input = "";
                for (int j = COL_START; j < M; j++) {
                    XSSFCell cell = row.getCell(j);
                    String val = readCell(cell, book);
                    input += val + "|";
                }

                if (i == 0) {
                    header = input;
                }

                HibernateUtilVersionE util = HibernateUtilVersionE.getINSTANCE();
//                util.storeList(input);


            }
        }

    }

    public static String createDatabaseSQL() throws IOException, InvalidFormatException {
        String path = "./src/main/resources/dataMigration/CRMExtracts/Account-Export.xlsx";
        File accountFile = new File(path);
        XSSFWorkbook book = new XSSFWorkbook(accountFile);
        XSSFSheet sheet = book.getSheetAt(0);
        int N = sheet.getLastRowNum();
        if (N > 0) {
            for (int i = 0; i < 1; i++) {
                XSSFRow row = sheet.getRow(i);
                int M = row.getLastCellNum();
                String input = "";
                for (int j = COL_START; j < M; j++) {
                    XSSFCell cell = row.getCell(j);
                    String val = readCell(cell, book);
                    input += val + "|";
                }
                return createSQL(input);

            }
        }

        return "";
    }

    public static String createJavaModelGeneral(File f) throws IOException, InvalidFormatException {
        XSSFWorkbook book = new XSSFWorkbook(f);
        XSSFSheet sheet = book.getSheetAt(0);
        int N = sheet.getLastRowNum();
        if (N > 0) {
            for (int i = 0; i < 1; i++) {
                XSSFRow row = sheet.getRow(i);
                int M = row.getLastCellNum();
                String input = "";
                for (int j = 0; j < M; j++) {
                    XSSFCell cell = row.getCell(j);
                    String val = readCell(cell, book);
                    input += val + "|";
                }
                return createJavaModelHelperClone("ProdCad", input);

            }
        }
        return "";
    }

    public static String createJavaModel() throws IOException, InvalidFormatException {
        String path = "./src/main/resources/dataMigration/CRMExtracts/Account-Export-2.xlsx";
        File accountFile = new File(path);
        XSSFWorkbook book = new XSSFWorkbook(accountFile);
        XSSFSheet sheet = book.getSheetAt(0);
        int N = sheet.getLastRowNum();
        if (N > 0) {
            for (int i = 0; i < 1; i++) {
                XSSFRow row = sheet.getRow(i);
                int M = row.getLastCellNum();
                String input = "";
                for (int j = COL_START; j < M; j++) {
                    XSSFCell cell = row.getCell(j);
                    String val = readCell(cell, book);
                    input += val + "|";
                }
                return createJavaModelHelper(input);

            }
        }
        return "";
    }


    public static String transform(String trans) {
        trans = trans.toLowerCase();
        trans = trans.replace(" ", "");
        trans = trans.replace("#", "");
        trans = trans.replace(":", "");
        trans = trans.replace("(", "_");
        trans = trans.replace(")", "_");
        trans = trans.replace("?", "");
        trans = trans.replace("/", "_");
        trans = trans.replace("-", "_");
        trans = trans.substring(0, 1).toUpperCase() + trans.substring(1);

        return trans;
    }

    public static String createJavaModelHelper(String input) {
        StringBuffer sb = new StringBuffer("public class Account {\n");
        String[] split = input.split("\\|");

        String d = "String %s; \n";
        for (String x : split) {
            sb.append(String.format(d, transform(x)));
        }

        sb.append("}");

        return sb.toString();

    }

    public static String createJavaModelHelperClone(String className, String input) {
        StringBuffer sb = new StringBuffer("public class" + className + "{\n");
        String[] split = input.split("\\|");

        String d = "String %s; \n";
        for (String x : split) {
            sb.append(String.format(d, transform(x)));
        }

        sb.append("}");

        return sb.toString();

    }


    public static String createSQL(String input) {
        StringBuffer sb = new StringBuffer("create table `crm`.`account`( \n");
        sb.append("`accountid` INT NOT NULL AUTO_INCREMENT,\n");
        String[] split = input.split("\\|");

        String d = "`%s` VARCHAR(500) NULL, \n";
        for (String x : split) {
            sb.append(String.format(d, x));
        }
        sb.append("PRIMARY KEY (`accountid`))");

        return sb.toString();


    }


}
