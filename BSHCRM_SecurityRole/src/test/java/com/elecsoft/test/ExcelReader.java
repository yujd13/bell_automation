package com.elecsoft.test;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class ExcelReader {
    public XSSFWorkbook workbook;
    public File file;


    public ExcelReader(File file) throws IOException, InvalidFormatException, IllegalAccessException {
        this.file = file;
        if (file == null) {
            workbook = new XSSFWorkbook();
        } else {
            System.out.println(file.getAbsoluteFile());
            workbook = new XSSFWorkbook(new FileInputStream(file));
        }

    }

    public HashSet<String> ignoreSheet() {
        XSSFSheet sheet = workbook.getSheetAt(0);
        HashSet<String> productToIgnore = new HashSet<String>();
        for (int i = 0; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            Cell cell = row.getCell(3);
            Cell productCodes = row.getCell(0);

            String productCode = "";

            switch (productCodes.getCellType()) {
                case Cell.CELL_TYPE_BLANK:
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    productCode = String.valueOf(Math.round(productCodes.getNumericCellValue()));
                    break;
                case Cell.CELL_TYPE_STRING:
                    productCode = productCodes.getStringCellValue().trim();
                    break;
                default:
                    break;
            }


            String ignore = cell.getStringCellValue().trim();
            if (ignore.equals("Ignore")) {
                System.out.println(productCode);
                productToIgnore.add(productCode);
            }


        }

        System.out.println(productToIgnore.size());

        return productToIgnore;


    }


    public HashMap<String, Master> masterDataExpected() {
        XSSFSheet sheet = workbook.getSheet("MASTER DATA TABLE");

        HashMap<String, Master> map = new HashMap<String, Master>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String productCode = row.getCell(0).getStringCellValue().trim();
            String productName = row.getCell(2).getStringCellValue().trim();


            Cell productCategoryCell = row.getCell(30);
            String productCategory = "";


            switch (productCategoryCell.getCellType()) {
                case Cell.CELL_TYPE_BLANK:
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    productCategory = String.valueOf(productCategoryCell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    productCategory = productCategoryCell.getStringCellValue().trim();
                    break;
                default:
                    break;
            }

            String sbnCode = row.getCell(17).getStringCellValue().trim();

            Master m = new Master(productCode, productName, productCategory);
            m.setSageCode(sbnCode);
            map.put(productCode, m);

        }

//        for(Map.Entry<String, List<Product>> x: map.entrySet()){
//            System.out.println("**********" + x.getKey() + "**********" );
//            for(Product g : x.getValue()){
//                System.out.println(g.product + " " + g.quantity);
//            }
//            System.out.println("****************************************" );
//
//        }
        return map;

    }

    public HashMap<String, List<Product>> actualResult() {

        XSSFSheet sheet = workbook.getSheet("Product Associations");

        HashMap<String, List<Product>> map = new HashMap<String, List<Product>>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String productBundle = row.getCell(1).getStringCellValue();
            String product = row.getCell(2).getStringCellValue();
            double quantity = row.getCell(4).getNumericCellValue();

            if (map.containsKey(productBundle)) {
                List<Product> lp = map.get(productBundle);
                lp.add(new Product(productBundle, product, quantity));
            } else {
                List<Product> lp = new ArrayList<Product>();
                lp.add(new Product(productBundle, product, quantity));
                map.put(productBundle, lp);
            }

        }

//        for(Map.Entry<String, List<Product>> x: map.entrySet()){
//            System.out.println("**********" + x.getKey() + "**********" );
//            for(Product g : x.getValue()){
//                System.out.println(g.product + " " + g.quantity);
//            }
//            System.out.println("****************************************" );
//
//        }
        return map;


    }

    public HashMap<String, List<Suggestion>> actualResultPC() {

        XSSFSheet sheet = workbook.getSheetAt(0);
        HashMap<String, List<Suggestion>> map = new HashMap<String, List<Suggestion>>();
        System.out.println(sheet.getLastRowNum());
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            System.out.println(row);
            String productBundle = getStringFromCell(3, row).trim().toUpperCase();//row.getCell(0).getStringCellValue();
            String relatedProduct = getStringFromCell(4, row).trim().toUpperCase();//row.getCell(3).getStringCellValue();
            String saleRelationShip = getStringFromCell(5, row);//row.getCell(4).getStringCellValue();
            String direction = getStringFromCell(6, row);//row.getCell(5).getStringCellValue();

            if (saleRelationShip.trim().equals("Substitute")) {
                continue;
            }

            if (map.containsKey(productBundle)) {
                List<Suggestion> lp = map.get(productBundle);
                lp.add(new Suggestion(productBundle.toUpperCase().trim(), relatedProduct.toUpperCase().trim(), saleRelationShip.toUpperCase().trim(), direction.toUpperCase().trim()));
            } else {
                List<Suggestion> lp = new ArrayList<Suggestion>();
                lp.add(new Suggestion(productBundle.toUpperCase().trim(), relatedProduct.toUpperCase().trim(), saleRelationShip.toUpperCase().trim(), direction.toUpperCase().trim()));
                map.put(productBundle, lp);
            }

        }
//
//        for(Map.Entry<String, List<Suggestion>> x: map.entrySet()){
//            System.out.println("**********" + x.getKey() + "**********" );
//            for(Suggestion g : x.getValue()){
//                System.out.println(g.product + " " + g.relatedProduct + " "  + g.relationShipType +  " " + g.direction);
//            }
//            System.out.println("****************************************" );
//
//        }
        return map;

    }

    public HashMap<String, List<Suggestion>> ActualSub() {

        XSSFSheet sheet = workbook.getSheetAt(0);//"Product Relationship");
        HashMap<String, List<Suggestion>> map = new HashMap<String, List<Suggestion>>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String productBundle = getStringFromCell(3, row);//row.getCell(0).getStringCellValue();
            String relatedProduct = getStringFromCell(4, row);//row.getCell(3).getStringCellValue();
            String saleRelationShip = getStringFromCell(5, row);//row.getCell(4).getStringCellValue();
            String direction = getStringFromCell(6, row);//row.getCell(5).getStringCellValue();
            if (saleRelationShip.trim().equals("Substitute")) {
                if (map.containsKey(productBundle)) {
                    List<Suggestion> suggestionList = map.get(productBundle);
                    suggestionList.add(new Suggestion(productBundle, relatedProduct, saleRelationShip, direction));
                    map.put(productBundle, suggestionList);

                } else {
                    List<Suggestion> suggestionList = new ArrayList<Suggestion>();
                    suggestionList.add(new Suggestion(productBundle, relatedProduct, saleRelationShip, direction));
                    map.put(productBundle, suggestionList);
                }
            }


        }
//
//        for(Map.Entry<String, List<Suggestion>> x: map.entrySet()){
//            System.out.println("**********" + x.getKey() + "**********" );
//            for(Suggestion g : x.getValue()){
//                System.out.println(g.product + " " + g.relatedProduct + " "  + g.relationShipType +  " " + g.direction);
//            }
//            System.out.println("****************************************" );
//
//        }
        return map;

    }

    public HashMap<String, List<Product>> ExpectedResult() {

        XSSFSheet sheet = workbook.getSheet("CRM ASSOC");

        HashMap<String, List<Product>> map = new HashMap<String, List<Product>>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String productBundle = row.getCell(1).getStringCellValue();
            String product = row.getCell(2).getStringCellValue();
            double quantity = row.getCell(4).getNumericCellValue();

            if (map.containsKey(productBundle)) {
                List<Product> lp = map.get(productBundle);
                lp.add(new Product(productBundle, product, quantity));
            } else {
                List<Product> lp = new ArrayList<Product>();
                lp.add(new Product(productBundle, product, quantity));
                map.put(productBundle, lp);
            }

        }
//
//        for(Map.Entry<String, List<Product>> x: map.entrySet()){
//            System.out.println("**********" + x.getKey() + "**********" );
//            for(Product g : x.getValue()){
//                System.out.println(g.product + " " + g.quantity);
//            }
//            System.out.println("****************************************" );
//
//        }
        return map;

    }

    public HashMap<String, ProdCad> prodCat() {
        HashMap<String, ProdCad> map = new HashMap<String, ProdCad>();


        XSSFSheet sheet = workbook.getSheet("CRM PRODCAT");
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String productId = row.getCell(0).getStringCellValue();
            String productName = row.getCell(2).getStringCellValue();
            String productStructure = row.getCell(12).getStringCellValue();

            map.put(productId, new ProdCad(productId, productName, productStructure));


        }
        return map;


    }

    public HashSet<String> bundlesInProdCat() {
//        HashMap<String,  List<ProdCad>> map = new HashMap<String,  List<ProdCad>>();
        HashSet<String> set = new HashSet<String>();
        XSSFSheet sheet = workbook.getSheet("CRM PRODCAT");
        for (int i = 1; i < sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String productId = row.getCell(0).getStringCellValue();
            String productName = row.getCell(2).getStringCellValue();
            String productStructure = row.getCell(12).getStringCellValue();

            if (productStructure.equals("Product Bundle")) {
                set.add(productId);


            }

//            if(map.containsKey(productId)){
//                List<ProdCad> lp =  map.get(productId);
//                lp.add(new ProdCad(productId, productName, productStructure));
//            } else{
//                List<ProdCad> lp = new ArrayList<ProdCad>();
//                lp.add(new ProdCad(productId, productName, productStructure));
//                map.put(productId, lp);
//            }


        }
        return set;

    }

    public HashSet<String> productsInProdCad() {
        HashSet<String> set = new HashSet<String>();
        XSSFSheet sheet = workbook.getSheet("CRM PRODCAT");

//        // create Retired Data Set
//        String retireds = "DTAO-QWLBEST,DTA-Q-BEST,DTAO-SMBQHWBT";
//        String[] retireCode=retireds.split(",");
//        HashSet<String> setRetired = new HashSet<String>();
//        for ( int i=0; i < retireCode.length;i++) {
//            setRetired.add(retireCode[i]);
//        }

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            CellType type = row.getCell(0).getCellTypeEnum();
            String productId = "";

            if (type.toString().equals("STRING")) {
                productId = row.getCell(0).getStringCellValue();
            } else if (type.toString().equals("NUMERIC")) {
                productId = String.valueOf(Math.round(row.getCell(0).getNumericCellValue()));
            } else {
                System.out.println("hello");
            }

//            // Skip retired Data
//            if (setRetired.contains(productId)) {
//                continue;
//            }

            set.add(productId.trim().toUpperCase());

//            String productName = row.getCell(2).getStringCellValue();
//            String productStructure = row.getCell(12).getStringCellValue();

//            if (productId.trim().matches("C[C]{0}_.*") || productId.trim().matches("C[C]{1}_.*")) {
//            } else {
//                set.add(productId.trim());
//
//            }

        }
        return set;

    }

    public HashMap<String, Double> ExpectedPrice(String priceType) {
        HashMap<String, Double> map = new HashMap<String, Double>();

        XSSFSheet sheet;
        if (priceType.toUpperCase().contains("PRICE SALE")) {
            sheet = workbook.getSheet("CRM PRICE SALES");
        }else if(priceType.toUpperCase().contains("PRICE STD")) {
            sheet = workbook.getSheet("CRM PRICE STD");
        }else if(priceType.toUpperCase().contains("PRICE SERV")) {
            sheet = workbook.getSheet("CRM PRICE SERV");
        }else{
            System.out.println( " Wrong price Type   " + priceType);
            sheet = workbook.getSheet(priceType);
        }



        // create Retired Data Set
        String retireds = "DTAO-QWLBEST,DTAO-Q-BEST,DTAO-SMBQHWBT";
        String[] retireCode=retireds.split(",");
//        HashSet<String> setRetired = new HashSet<String>();
//        for ( int i=0; i < retireCode.length;i++) {
//            setRetired.add(retireCode[i]);
//        }

        System.out.println( "row last  ..." + sheet.getLastRowNum());

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            XSSFRow row = sheet.getRow(i);
            Cell cell = row.getCell(0);
            CellType cellType = cell.getCellTypeEnum();
            String value = "";
            if (cellType.toString().equals("STRING")) {
                value = cell.getStringCellValue();

            } else if (cellType.toString().equals("NUMERIC")) {
                value = String.valueOf(cell.getNumericCellValue());  // number 6151 become String 6151.0
                //  remove the Decimal 0000  change back String 6151.0 === > String  6151
                BigDecimal value1 = new BigDecimal( value);
                BigDecimal noZeros = value1.stripTrailingZeros();
                value = noZeros.toPlainString();
            } else if (cellType.toString().equals("BOOLEAN")) {
                value = String.valueOf(cell.getBooleanCellValue()).toUpperCase();
//                System.out.println(" i ..  " + i + " value    " +  value );
            }


//
//            // Skip retired Data
//            if (setRetired.contains(value)) {
//                continue;
//            }

//          boolean bRetired=false;
//          for ( int k=0; k < retireCode.length;k++) {
//                if (retireCode[k].equals(value.trim())) {
//                    bRetired = true;
//                    break;
//                }
//          }

           // Skip retired Data
//            if (bRetired ) { continue;}

            double a = -1;
            Cell amount = row.getCell(3);

            CellType cc = amount.getCellTypeEnum();
            if (cc.toString().equals("STRING")) {
                a = -1;
            } else if (cc.toString().equals("NUMERIC")) {
                a = Double.valueOf(row.getCell(3).getNumericCellValue());
            } else if (cc.toString().equals("FORMULA")) {
                if (row.getCell(3).getRawValue().equals("#N/A")) {

                } else {
//                    System.out.println(row.getCell(3).getRawValue());
                    a = Double.valueOf(row.getCell(3).getRawValue());

                }

            }

            String productBundle = value;
            map.put(productBundle.trim().toUpperCase(), a);
        }

        return map;

    }

    public HashMap<String, Double> ActualPrice(String priceType) {
        HashMap<String, Double> map = new HashMap<String, Double>();

        boolean sale = priceType.toUpperCase().contains("PRICE STD");

        XSSFSheet sheet = workbook.getSheetAt(0);
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);

            Cell cell = row.getCell(7);
            CellType cellType = cell.getCellTypeEnum();
            String value = "";
            if (cellType.toString().equals("STRING")) {
                value = cell.getStringCellValue();
            } else if (cellType.toString().equals("NUMERIC")) {
                value = String.valueOf(cell.getNumericCellValue());
            }

            if (sale){
                if (!value.contains("STD")){
                    continue;
                }
            }  else {
                if (value.contains("STD")){
                    continue;
                }
            }

            cell = row.getCell(3);
            cellType = cell.getCellTypeEnum();
            value = "";
            if (cellType.toString().equals("STRING")) {
                value = cell.getStringCellValue();
            } else if (cellType.toString().equals("NUMERIC")) {
                value = String.valueOf(cell.getNumericCellValue());

                //  remove the Decimal 0000
                BigDecimal value1 = new BigDecimal( value);
                BigDecimal noZeros = value1.stripTrailingZeros();
                value = noZeros.toPlainString();

            }

            double a = -1;
            Cell amount = row.getCell(6);
            CellType cc = amount.getCellTypeEnum();
            if (cc.toString().equals("STRING")) {
                a = -1;
            } else if (cc.toString().equals("NUMERIC")) {
                a = Double.valueOf(row.getCell(6).getNumericCellValue());
            } else if (cc.toString().equals("FORMULA")) {
                if (row.getCell(6).getRawValue().equals("#N/A")) {

                } else {
                    System.out.println(row.getCell(6).getRawValue());
                    a = Double.valueOf(row.getCell(6).getRawValue());

                }

            }

            String productBundle = value;
            map.put(productBundle.trim().toUpperCase(), a);
        }

        return map;


    }


    public HashMap<String, String> getExpectedSecurityRole(String roleType) {

        HashMap<String, String> map = new HashMap<String, String>();

        int  col = roleType.contains("Sales Supervisor")? 1:0;

        XSSFSheet sheet;
        if (roleType.equalsIgnoreCase("BSH Inside Sales Agent")) {
            sheet = workbook.getSheet("BSH Inside Sales Agent");
        }else if(roleType.equalsIgnoreCase("BSH BASIC")) {
            sheet = workbook.getSheet("BSH Basic");
        }else if(roleType.equalsIgnoreCase("BSH COLLECTIONS")) {
            sheet = workbook.getSheet("BSH Collections");
        }else if(roleType.equalsIgnoreCase("BSH CONTROL CENTRE")) {
            sheet = workbook.getSheet("BSH Control Centre");
        }else if(roleType.equalsIgnoreCase("BSH VendorManagement-C")) {
            sheet = workbook.getSheet("BSH VM & C");
        }else if(roleType.equalsIgnoreCase("BSH OPERATION SUPERVISOR")) {
            sheet = workbook.getSheet("BSH Operation Supervisor");
        }else if(roleType.equalsIgnoreCase("BSH SHIPPING")) {
            sheet = workbook.getSheet("BSH Shipping");
        }else if(roleType.equalsIgnoreCase("BSH Service Technician")) {
            sheet = workbook.getSheet("BSH ServiceTechician");
        }else if(roleType.equalsIgnoreCase("BSH SALES SUPERVISOR")) {
            sheet = workbook.getSheet("BSH Sales Supervisor");
        }else if(roleType.equalsIgnoreCase("BSH RFMs")) {
            sheet = workbook.getSheet("BSH RFMs");
        }else if(roleType.equalsIgnoreCase("BSH Processing Team")) {
            sheet = workbook.getSheet("BSH Processing Team");
        }else if(roleType.equalsIgnoreCase("BSH PROCESSING MANAGER")) {
            sheet = workbook.getSheet("BSH Processing Manager");
        }else if(roleType.equalsIgnoreCase("BSH Operation Agent-CCare")) {
            sheet = workbook.getSheet("BSH Operation Agent-CCare");
        }else if(roleType.equalsIgnoreCase("BSH OPERATION Agent-L+R")) {
            sheet = workbook.getSheet("BSH Operation Agent-L&R");
        }else if(roleType.equalsIgnoreCase("BSH OPERATION Agent-TechSup")) {
            sheet = workbook.getSheet("BSH Operation Agent-TechSup");
        }else if(roleType.equalsIgnoreCase("BSH IT")) {
            sheet = workbook.getSheet("BSH IT");
        }else if(roleType.equalsIgnoreCase("BSH CMS")) {
            sheet = workbook.getSheet("BSH CMS");
        }else{
            System.out.println( " Wrong Role type   " + roleType);
            sheet = workbook.getSheet(roleType);
        }

        if(sheet==null){
            System.out.println( " sheet is null --- " + roleType );
        }

        System.out.println( " expect last row ...  " + sheet.getLastRowNum());

        String sEntity;
        for (int i = 2; i <= sheet.getLastRowNum(); i++) {

            StringBuilder buRole  = new StringBuilder();

            XSSFRow row = sheet.getRow(i);

//            System.out.println(i + " == >  " + roleType );

            String iteration = getStringFromCell(col, row).trim().toLowerCase();

            System.out.println(i + " ->  " + " interaiton  " + iteration + "   ");

            if (!iteration.equals("iteration 2")) {
                continue;
            }

            sEntity = getStringFromCell(col+2, row).trim().toUpperCase();
            if (sEntity.equals("CASE SUB-TYPE")){
                sEntity = "CASE SUBTYPE";
            }

            String sRole;
            int k = col+3;
            while (k < col+11){
                sRole = getStringFromCell(k, row);
                if (sRole.isEmpty()){
                    sRole = "BLANK";
                }
                buRole.append(sRole.trim());
                if (k == col+10){
                  //
                }else{
                 buRole.append(",");
                }
                k++;
            }

            sRole = buRole.toString();
//            System.out.println( i + " ->  " + iteration + "   " + sEntity + "  Roles  " + sRole);
            map.put(sEntity , sRole);
        }
        return map;

    }


    public HashMap<String, String> getActualSecurityRole(String roleType) {

        HashMap<String, String> map = new HashMap<String, String>();

        XSSFSheet sheet;

        if (roleType.equalsIgnoreCase("BSH Inside Sales Agent")) {
            sheet = workbook.getSheet("BellSmartHomeInsideSalesAgent");
        }else if(roleType.equalsIgnoreCase("BSH BASIC")) {
            sheet = workbook.getSheet("Bell Smart Home Basic");
        }else if(roleType.equalsIgnoreCase("BSH COLLECTIONS")) {
            sheet = workbook.getSheet("Bell Smart Home Collections");
        }else if(roleType.equalsIgnoreCase("BSH CONTROL CENTRE")) {
            sheet = workbook.getSheet("Bell Smart Home Control Centre");
        }else if(roleType.equalsIgnoreCase("BSH VendorManagement-C")) {
            sheet = workbook.getSheet("BellSmartHomeVendorManagement&C");
        }else if(roleType.equalsIgnoreCase("BSH OPERATION SUPERVISOR")) {
            sheet = workbook.getSheet("BellSmartHomeOperationSuperviso");
        }else if(roleType.equalsIgnoreCase("BSH SHIPPING")) {
            sheet = workbook.getSheet("Bell Smart Home Shipping");
        }else if(roleType.equalsIgnoreCase("BSH Service Technician")) {
            sheet = workbook.getSheet("BellSmartHomeServiceTechnician");
        }else if(roleType.equalsIgnoreCase("BSH SALES SUPERVISOR")) {
            sheet = workbook.getSheet("BellSmartHomeSalesSupervisor-ad");
        }else if(roleType.equalsIgnoreCase("BSH RFMs")) {
            sheet = workbook.getSheet("BellSmartHomeRFMs(RegionalField");
        }else if(roleType.equalsIgnoreCase("BSH Processing Team")) {
            sheet = workbook.getSheet("Bell Smart Home Processing Team");
        }else if(roleType.equalsIgnoreCase("BSH PROCESSING MANAGER")) {
            sheet = workbook.getSheet("BellSmartHomeProcessingManager");
        }else if(roleType.equalsIgnoreCase("BSH Operation Agent-CCare")) {
            sheet = workbook.getSheet("Bell Smart Home Operation Agent");
        }else if(roleType.equalsIgnoreCase("BSH OPERATION Agent-L+R")) {
            sheet = workbook.getSheet("Bell Smart Home Operation Agent");
        }else if(roleType.equalsIgnoreCase("BSH OPERATION Agent-TechSup")) {
            sheet = workbook.getSheet("Bell Smart Home Operation Agent");
         }else if(roleType.equalsIgnoreCase("BSH IT")) {
            sheet = workbook.getSheet("Bell Smart Home IT");
        }else if(roleType.equalsIgnoreCase("BSH CMS")) {
            sheet = workbook.getSheet("Bell Smart Home CMS");
        }else{
            System.out.println( " Wrong Role type   " + roleType);
            sheet = workbook.getSheet(roleType);
        }


//        System.out.println( " Actual last  row ... " + sheet.getLastRowNum());

        String sEntity;

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            StringBuilder buRole  = new StringBuilder();

            XSSFRow row = sheet.getRow(i);

            sEntity = getStringFromCell(0, row).trim().toUpperCase();
            String sRole;
            int k = 3;
            while (k < 11){
                sRole = getStringFromCell(k, row);
                if (sRole.isEmpty()){
                    sRole = "BLANK";
                }
                buRole.append(sRole.trim());
                if (k == 10){
                    //
                }else{
                    buRole.append(",");
                }
                k++;
            }
            sRole = buRole.toString();
//            System.out.println( i + " ->  " + sEntity + "  Roles  " + sRole);

            map.put(sEntity , sRole);
        }
        return map;

    }



    public HashMap<String, AE> aMap() {
        XSSFSheet sheet = workbook.getSheet("AE");
        HashMap<String, AE> map = new HashMap<String, AE>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String productName = row.getCell(0).getStringCellValue();
            String productID = row.getCell(1).getStringCellValue();
            String description = row.getCell(2).getStringCellValue();
            String status = row.getCell(3).getStringCellValue();
            String productStructure = row.getCell(4).getStringCellValue();

            AE m = new AE(productName, productID, description, status, productStructure);
            map.put(productID, m);


        }
        return map;

    }

    public HashMap<String, Master> ActualMaster() {
        XSSFSheet sheet = workbook.getSheet("Products And Bundles");

        HashMap<String, Master> map = new HashMap<String, Master>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String productCode = row.getCell(0).getStringCellValue();
            String productName = row.getCell(2).getStringCellValue();
            String productCategory = row.getCell(13).getStringCellValue();

            Master m = new Master(productCode, productName, productCategory);
            map.put(productCode, m);


        }
        return map;
    }


    public HashMap<String, List<Suggestion>> ExpectedResultPC() {

        XSSFSheet sheet = workbook.getSheet("CRM RELATIONSHIP");

        HashMap<String, List<Suggestion>> map = new HashMap<String, List<Suggestion>>();

        // create Retired Data Set
        String retireds = "DTAO-QWLBEST,DTAO-Q-BEST,DTAO-SMBQHWBT";
        String[] retireCode=retireds.split(",");
        HashSet<String> setRetired = new HashSet<String>();
        for ( int i=0; i < retireCode.length;i++) {
            setRetired.add(retireCode[i]);
        }

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String productBundle = getStringFromCell(0, row).trim().toUpperCase();
            String relatedProduct = getStringFromCell(3, row).trim().toUpperCase();//row.getCell(3).getStringCellValue();
            String saleRelationShip = getStringFromCell(4, row);//row.getCell(4).getStringCellValue();
            String direction = getStringFromCell(5, row);  //row.getCell(5).getStringCellValue();

            System.out.println(saleRelationShip);
            if (saleRelationShip.trim().equals("Substitute")) {
                continue;
            }

            // Skip retired Data
            if (setRetired.contains(productBundle)) {
                continue;
            }

            if (map.containsKey(productBundle)) {
                List<Suggestion> lp = map.get(productBundle);
                lp.add(new Suggestion(productBundle.toUpperCase().trim(), relatedProduct.toUpperCase().trim(), saleRelationShip.toUpperCase().trim(), direction.toUpperCase().trim()));
            } else {
                List<Suggestion> lp = new ArrayList<Suggestion>();
                lp.add(new Suggestion(productBundle.toUpperCase().trim(), relatedProduct.toUpperCase().trim(), saleRelationShip.toUpperCase().trim(), direction.toUpperCase().trim()));
                map.put(productBundle, lp);
            }
        }
//
//        for(Map.Entry<String, List<Suggestion>> x: map.entrySet()){
//            System.out.println("**********" + x.getKey() + "**********" );
//            for(Suggestion g : x.getValue()){
//                System.out.println(g.product + " " + g.relatedProduct + " "  + g.relationShipType +  " " + g.direction);
//            }
//            System.out.println("****************************************" );
//
//        }
        return map;

    }

    public HashMap<String, SBN> getSBNFile() {
        XSSFSheet sheet = workbook.getSheetAt(0);
        HashMap<String, SBN> map = new HashMap<String, SBN>();

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            Cell cell = row.getCell(1);
            if (cell == null) {
                continue;
            }
            String productCode = "";
            CellType cellType = cell.getCellTypeEnum();
//            System.out.println(cellType.toString());

            if (cellType.toString().equals("STRING")) {
                productCode = cell.getStringCellValue().trim();
            } else if (cellType.toString().equals("NUMERIC")) {
                productCode = String.valueOf(cell.getNumericCellValue()).trim();
            } else if (cellType.toString().equals("FORMULA")) {
                productCode = cell.getCellFormula();

            }

            // skip the duplicate Product Code
            if (map.containsKey(productCode)){
                continue;
            }

//            System.out.println("product code is " + productCode);

//            String itemDescription = row.getCell(4).getStringCellValue();
//            SBN s = new SBN(productCode.trim(), itemDescription.trim());
            SBN s = new SBN(productCode.trim(), "");

            map.put(productCode.toUpperCase(), s);
        }

        return map;
    }

    public String getStringFromCell(int index, XSSFRow row) {

        if (row != null) {
            String value = "";
            Cell  ce = row.getCell(index);
            if (ce==null){
                value = "";
            }else{
                switch (ce.getCellTypeEnum()) {
                    case _NONE:
                        break;
                    case NUMERIC:
                        value = String.valueOf(Math.round(row.getCell(index).getNumericCellValue()));
                        break;
                    case STRING:
                        value = row.getCell(index).getStringCellValue();
                        break;
                    case FORMULA:
                        break;
                    case BLANK:
                        break;
                    case BOOLEAN:
                        break;
                    case ERROR:
                        break;
                    default:
                }
             return value;
            }
        }
        return "";

    }

    public HashMap<String, List<Suggestion>> ExpectedSub() {

        XSSFSheet sheet = workbook.getSheet("CRM RELATIONSHIP");

        // create Retired Data Set
        String retireds = "DTAO-QWLBEST,DTA-Q-BEST,DTAO-SMBQHWBT";
        String[] retireCode=retireds.split(",");
        HashSet<String> setRetired = new HashSet<String>();
        for ( int i=0; i < retireCode.length;i++) {
            setRetired.add(retireCode[i]);
        }

        HashMap<String, List<Suggestion>> map = new HashMap<String, List<Suggestion>>();
        System.out.println(sheet.getLastRowNum());
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String productBundle = getStringFromCell(0, row).trim().toUpperCase();
            String relatedProduct = getStringFromCell(3, row).trim().toUpperCase(); //row.getCell(3).getStringCellValue();
            String saleRelationShip = getStringFromCell(4, row); //row.getCell(4).getStringCellValue();
            String direction = getStringFromCell(5, row);//row.getCell(5).getStringCellValue();

            // Skip retired Data
//            if (setRetired.contains(productBundle)) {
//                continue;
//            }

            if (saleRelationShip.trim().equals("Substitute")) {
                if (map.containsKey(productBundle)) {
                    List<Suggestion> suggestionList = map.get(productBundle);
                    suggestionList.add(new Suggestion(productBundle, relatedProduct, saleRelationShip, direction));
                    map.put(productBundle, suggestionList);

                } else {
                    List<Suggestion> suggestionList = new ArrayList<Suggestion>();
                    suggestionList.add(new Suggestion(productBundle, relatedProduct, saleRelationShip, direction));
                    map.put(productBundle, suggestionList);
                }
            }


        }
        return map;
    }

    public static void main(String[] args) throws IllegalAccessException, InvalidFormatException, IOException {

        File a = new File("./src/main/resources/pc/ERV084.xlsx");
        File b = new File("./src/main/resources/pc/ProductAssociation.xlsx");
        File c = new File("./src/main/resources/pc/ProductRelationship.xlsx");
        File d = new File("./src/main/resources/pc/PriceList.xlsx");
        File e = new File("./src/main/resources/pc/Products And Bundles.xlsx");
        File f = new File("./src/main/resources/pc/Actual_Export.xlsx");
        File g = new File("./src/main/resources/pc/SBN items.xlsx");


        ExcelReader er = new ExcelReader(a);
        ExcelReader er2 = new ExcelReader(b);
        ExcelReader er3 = new ExcelReader(c);
        ExcelReader er4 = new ExcelReader(d);
        ExcelReader er5 = new ExcelReader(e);
        ExcelReader er6 = new ExcelReader(f);
        ExcelReader er7 = new ExcelReader(g);

        HashMap<String, List<Product>> actualResult = er2.actualResult();
        HashMap<String, List<Suggestion>> actualResultPC = er3.actualResultPC();

        HashMap<String, List<Product>> expectedResultr = er.ExpectedResult();
        HashMap<String, List<Suggestion>> expectedResultPC = er.ExpectedResultPC();
        HashMap<String, List<Suggestion>> esMap = er.ExpectedSub();

        HashMap<String, Master> master = er.masterDataExpected();
        HashMap<String, Master> actualMaster = er5.ActualMaster();

        HashMap<String, AE> aeMap = er6.aMap();
        HashMap<String, List<Suggestion>> asMap = er3.ActualSub();
        HashMap<String, SBN> sbnMap = er7.getSBNFile();

        HashSet<String> productsInProdCad = er.productsInProdCad();
        System.out.println(productsInProdCad.size());

        System.out.println("SBN Code | ProdCad Code");
        for (String x : productsInProdCad) {
            if (sbnMap.containsKey(x)) {
                System.out.println(x + " | " + x);

            } else {
                System.out.println(" NA | " + x);
            }

        }


//        for(Map.Entry<String, Master> m: master.entrySet()){
//
//            if(!m.getValue().sbnItemCode.equals(m.getValue().sageCode)){
//                System.out.println( master.get(m.getValue().sbnItemCode).productName  + " | " + m.getValue().sbnItemCode + " | " + m.getValue().sageCode);
//            }
//        }


//        System.out.println("Expected Orginal Product Name  | Expected Original Product Code (Product to SUB) | Expected Substitute (Product To REPLACE) | Expected Sub Code | Actual Product Name | Actual Product Code | Actual Substitute Name | Actual Substitute Code ");
//        for(Map.Entry<String, List<Suggestion> > x: esMap.entrySet()){
//            List<Suggestion>  act = asMap.get(x.getKey());
//            System.out.println("***" + x.getKey() + " can swap with the below " + "***");
//            System.out.println("Expected Substitute | Actual Substitute | Pass/Fail");
//
//            for(int i = 0; i < x.getValue().size();i++){
//                Suggestion exp = null;
//                Suggestion ac = null;
//                try {
//                     exp = x.getValue().get(i);
//                     ac = act.get(i);
//                }catch (Exception fe){
//                    System.out.println("****" + x.getKey() + "*****");
//                    continue;
//
//                }
//
//                if(exp.relatedProduct.trim().equals(ac.relatedProduct.trim())){
//                    System.out.println( exp.relatedProduct + "  | " + ac.relatedProduct + "|" + " TRUE");
//                }else{
//                    System.out.println( exp.relatedProduct + "  | " + ac.relatedProduct + "|" + " FALSE");
//
//                }
//
//
//
//
//            }
//            System.out.println("*********");
        //        String [] lol = {"BSHS-ENG-WD",
        //        "Jasco_28172",
        //                "QOLSYS_433",
        //        "WIFI_EXTEND",
        //        "BSHSENGLSBF",
        //        "PG_DW_9303",
        //        "VC826",
        //        "PG_MOTION1",
        //        "PG_PANIC1"};
        //
        //        System.out.println("****");
        //        for(String x : lol) {
        //            System.out.println(master.get(x).productName + " / " + x);
        //        }
        //        System.out.println("****");


//            if(x.getValue().relatedProduct.equals(act.relatedProduct) ){
//                System.out.println( master.get(x.getKey()).productName + " | " + x.getKey() + " | " + master.get(x.getValue().relatedProduct).productName  +"|" + x.getValue().relatedProduct + " | "
//                        + master.get(act.product).productName  + " | " +  act.product + " | " + master.get(act.relatedProduct).productName + " | "  + act.relatedProduct +"| TRUE"  ) ;
//            }else{
//                System.out.println( master.get(x.getKey()).productName + " | " + x.getKey() + " | " + master.get(x.getValue().relatedProduct).productName  +"|" + x.getValue().relatedProduct + " | "
//                        + master.get(act.product).productName  + " | " +  act.product + " | " + master.get(act.relatedProduct).productName + " | "  + act.relatedProduct +"| FALSE"  ) ;
//            }
    }


//        HashMap<String, Double> priceMap = er.ExpectedPrice();
//        HashMap<String, Double> actualPriceMap = er4.ActualPrice();
//
//        HashMap<String, ProdCad> ss = er.prodCat();


//        System.out.println("***START***");
//        for(Map.Entry<String, AE> map : aeMap.entrySet()){
//            if(master.containsKey(map.getKey())){
//
//            }else{
//                if(!map.getValue().status.equals("Retired")){
//                    System.out.println(map.getKey() + "  " + map.getValue().status);
//
//                }
//            }
//
//        }
//        System.out.println("***END***");


//        for (Map.Entry<String, List<Suggestion>> x : expectedResultPC.entrySet()) {
//            List<Suggestion> actual = actualResultPC.get(x.getKey());
//            System.out.println("**********|************|"+ x.getKey() + "|************|**********");
//
//            System.out.println(  " Product Name  | " + "Expected Product Code" + " |  " + "Expected Option" + " | "  + "  Expected Category | " + "Actual Product Code" + " | " + "Actual Option |  Actual Product Category");
//
//            for (int i = 0; i < x.getValue().size(); i++) {
//                Suggestion s = x.getValue().get(i);
//                {
//                    Suggestion act = x.getValue().get(i);
//
////                    if(s.relatedProduct.trim().equals(act.relatedProduct.trim()) || s.relationShipType.trim().equals(act.relationShipType.trim())){
////                        continue;
////                    }
//                    ProdCad pc;
//                    Master m = master.get(s.relatedProduct);
//                    Master actm = actualMaster.get(s.relatedProduct);
////                    if(m.crmProductCategory.trim().equals(actm.crmProductCategory.trim())){
////                        continue;
////                    }
//                    try{
//                         pc = ss.get(s.relatedProduct);
//                        System.out.println(pc.productName + " | " + s.relatedProduct + " |  " + s.relationShipType + " | " + m.crmProductCategory + " | " + act.relatedProduct + " | " + act.relationShipType + " | " + actm.crmProductCategory );
//                    } catch (Exception u){
//                        System.out.println( actm.crmProductCategory );
//                        System.out.println("NA" + " | " + s.relatedProduct + " |  " + s.relationShipType  + " | " + m.crmProductCategory +  " | "   + act.relatedProduct + " | " + act.relationShipType + " | " + actm.crmProductCategory);
//
//
//                    }
//
//
//
//                }
//
//
//            }
//            System.out.println("******|********|***********|**********");
//        }

//        for(Map.Entry<String, Double> x: priceMap.entrySet()){
//            double actualPrice = actualPriceMap.get(x.getKey());
//            if(x.getValue() != actualPrice){
//                ProdCad t = ss.get(x.getKey());
//                System.out.println(x.getKey() + " | " +  t.productName +  " | " + x.getValue() + " | " + actualPrice );
//
//            }
//        }


    //        System.out.println("***Bundles****");
//        for(String s: ss){
//            double amount;
//            try {
//                 amount = priceMap.get(s);
//                System.out.println(s + " | " + amount);
//
//            } catch (Exception e){
//                System.out.println("Bundle Skiped: " + s);
//
//            }
//        }
//        System.out.println("**************");


//        for(String s : ss){
//
//            if(!expectedResultr.containsKey(s)){
//                System.out.println(s);
//            }
//        }

//        for(Map.Entry<String,List<Product>> map: expectedResultr.entrySet()) {
//
//            if(!ss.contains(map.getKey())){
//                System.out.println("error : " + map.getKey());
//            }
//        }


//        List<Suggestion> l =  actualResultPC.get("Q-BEST");
//       List<Suggestion> e = expectedResultPC.get("Q-BEST");


//        HashSet<String> f = new HashSet<String>();
//        for(int i =0; i < e.size();i++){
//            if(f.contains(e.get(i).relatedProduct)){
//                System.out.println(e.get(i).relatedProduct);
//            }
//            f.add(e.get(i).relatedProduct);
//        }
//        System.out.println(f.size());


//        for(Map.Entry<String,List<Product>> map: expectedResultr.entrySet()){
//            String bundle = map.getKey();
//            List<Suggestion> suggestionList = expectedResultPC.get(bundle);
//            List<Suggestion> actualList = actualResultPC.get(bundle);
//            System.out.println("****************" + bundle + "*************");
////            if(suggestionList.size() != actualList.size()) {
////                System.out.println(suggestionList.size() + " " + actualList.size());
////            }
//            for(int i = 0; i < suggestionList.size(); i++){
//                Suggestion e =  suggestionList.get(i);
//                Suggestion actual= actualList.get(i);
//
//
//            }
//
//            System.out.println("****************"  + "*************");
//
//
//        }

//        for(Map.Entry<String, List<Product>> map: expectedResultr.entrySet()){
//            System.out.println("****|***|"+map.getKey()+"|***|****");
//            List<Product> ar = actualResult.get(map.getKey());
//            System.out.println("Product Name | Expected Product Code" + " | " + "Expected Quantity"  +  "  | " + "Actual Product Code"+ " | " + " Actual Quantity");
//
//            for(int i=0; i < ar.size(); i++){
//                Product atr = ar.get(i);
//                Product expected = ar.get(i);
//                ProdCad pc = ss.get(expected.product);
//
////                if(expected.product != atr.product || expected.quantity != atr.quantity){
//                    System.out.println(pc.productName + " | "+ expected.product + " | " + expected.quantity  +  "  | " + atr.product + " | " + atr.quantity);
////                }
//
//
//            }
//            System.out.println("****|***|****|***|****");
//
//        }
}
//    }



