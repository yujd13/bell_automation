import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class ExcelReader {
    public XSSFWorkbook workbook;
    public File file;




    public ExcelReader(File file) throws IOException, InvalidFormatException, IllegalAccessException {
        this.file = file;
        if (file == null) {
            workbook = new XSSFWorkbook();
        } else {
            System.out.println(file.getAbsoluteFile());
            workbook = new XSSFWorkbook( new FileInputStream(file));
        }



    }

    public HashMap<String, Master> masterDataExpected(){
        XSSFSheet sheet = workbook.getSheet("MASTER DATA TABLE");

        HashMap<String, Master> map = new HashMap<String, Master>();
        for(int i = 1; i <= sheet.getLastRowNum(); i++){
            XSSFRow row = sheet.getRow(i);
            String productCode = row.getCell(0).getStringCellValue();
            String productName = row.getCell(2).getStringCellValue();
            Cell productCategoryCell = row.getCell(30);
            String productCategory = "";


            switch (productCategoryCell.getCellType()) {
                case Cell.CELL_TYPE_BLANK:
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    productCategory = String.valueOf(productCategoryCell.getNumericCellValue());
                    break;
                case Cell.CELL_TYPE_STRING:
                    productCategory = productCategoryCell.getStringCellValue();
                    break;
                default:
                    break;
            }

            String sbnCode = row.getCell(17).getStringCellValue();

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

    public HashMap<String, List<Product>> actualResult(){

        XSSFSheet sheet = workbook.getSheet("ProductAssociation");

        HashMap<String, List<Product>> map = new HashMap<String, List<Product>>();
        for(int i = 1; i <= sheet.getLastRowNum(); i++){
            XSSFRow row = sheet.getRow(i);
            String productBundle = row.getCell(1).getStringCellValue();
            String product = row.getCell(2).getStringCellValue();
            double quantity = row.getCell(4).getNumericCellValue();

            if(map.containsKey(productBundle)){
                List<Product> lp =  map.get(productBundle);
                lp.add(new Product(productBundle, product, quantity));
            } else{
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

    public HashMap<String, List<Suggestion>> actualResultPC(){

        XSSFSheet sheet = workbook.getSheet("ProductRelationship");
        HashMap<String, List<Suggestion>> map = new HashMap<String, List<Suggestion>>();
        for(int i = 1; i <= sheet.getLastRowNum(); i++){
            XSSFRow row = sheet.getRow(i);
            String productBundle = row.getCell(0).getStringCellValue();
            String relatedProduct = row.getCell(3).getStringCellValue();
            String saleRelationShip = row.getCell(4).getStringCellValue();
            String direction = row.getCell(5).getStringCellValue();

            if(saleRelationShip.trim().equals("Substitute")){
                continue;
            }

            if(map.containsKey(productBundle)){
                List<Suggestion> lp =  map.get(productBundle);
                lp.add(new Suggestion(productBundle, relatedProduct, saleRelationShip, direction));
            } else{
                List<Suggestion> lp = new ArrayList<Suggestion>();
                lp.add(new Suggestion(productBundle, relatedProduct, saleRelationShip, direction));
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

    public HashMap<String, List<Suggestion> > ActualSub(){

        XSSFSheet sheet = workbook.getSheet("ProductRelationship");
        HashMap<String, List<Suggestion> > map = new HashMap<String, List<Suggestion> >();
        for(int i = 1; i <= sheet.getLastRowNum(); i++){
            XSSFRow row = sheet.getRow(i);
            String productBundle = row.getCell(0).getStringCellValue();
            String relatedProduct = row.getCell(3).getStringCellValue();
            String saleRelationShip = row.getCell(4).getStringCellValue();
            String direction = row.getCell(5).getStringCellValue();

            if(saleRelationShip.trim().equals("Substitute")){
                if (map.containsKey(productBundle)) {
                    List<Suggestion> suggestionList = map.get(productBundle);
                    suggestionList.add(new Suggestion(productBundle, relatedProduct, saleRelationShip, direction) );
                    map.put(productBundle, suggestionList);

                } else {
                    List<Suggestion> suggestionList = new ArrayList<Suggestion>();
                    suggestionList.add(new Suggestion(productBundle, relatedProduct, saleRelationShip, direction) );
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

    public HashMap<String, List<Product>> ExpectedResult(){

        XSSFSheet sheet = workbook.getSheet("CRM ASSOC");

        HashMap<String, List<Product>> map = new HashMap<String, List<Product>>();
        for(int i = 1; i <= sheet.getLastRowNum(); i++){
            XSSFRow row = sheet.getRow(i);
            String productBundle = row.getCell(1).getStringCellValue();
            String product = row.getCell(2).getStringCellValue();
            double quantity = row.getCell(4).getNumericCellValue();

            if(map.containsKey(productBundle)){
                List<Product> lp =  map.get(productBundle);
                lp.add(new Product(productBundle, product, quantity));
            } else{
                List<Product> lp = new ArrayList<Product>();
                lp.add(new Product(productBundle, product, quantity));
                map.put(productBundle, lp);
            }

        }
//
        for(Map.Entry<String, List<Product>> x: map.entrySet()){
            System.out.println("**********" + x.getKey() + "**********" );
            for(Product g : x.getValue()){
                System.out.println(g.product + " " + g.quantity);
            }
            System.out.println("****************************************" );

        }
        return map;

    }

    public HashMap<String, ProdCad> prodCat (){
        HashMap<String,  ProdCad> map = new HashMap<String,  ProdCad>();


        XSSFSheet sheet = workbook.getSheet("CRM PRODCAT");
        for(int i=1; i< sheet.getLastRowNum(); i++){
            XSSFRow row = sheet.getRow(i);
            String productId = row.getCell(0).getStringCellValue();
            String productName = row.getCell(2).getStringCellValue();
            String productStructure = row.getCell(12).getStringCellValue();

            map.put(productId, new ProdCad(productId, productName, productStructure));


        }
        return map;


    }

    public HashSet<String> bundlesInProdCat (){
//        HashMap<String,  List<ProdCad>> map = new HashMap<String,  List<ProdCad>>();
        HashSet<String> set = new HashSet<String>();
        XSSFSheet sheet = workbook.getSheet("CRM PRODCAT");
        for(int i=1; i< sheet.getLastRowNum(); i++){
            XSSFRow row = sheet.getRow(i);
            String productId = row.getCell(0).getStringCellValue();
            String productName = row.getCell(2).getStringCellValue();
            String productStructure = row.getCell(12).getStringCellValue();

            if(productStructure.equals("Product Bundle")){
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

    public HashSet<String> productsInProdCad (){
        HashSet<String> set = new HashSet<String>();
        XSSFSheet sheet = workbook.getSheet("CRM PRODCAT");
        for(int i=1; i< sheet.getLastRowNum(); i++){
            XSSFRow row = sheet.getRow(i);
            String productId = row.getCell(0).getStringCellValue();
            String productName = row.getCell(2).getStringCellValue();
            String productStructure = row.getCell(12).getStringCellValue();

                set.add(productId);






        }
        return set;


    }

    public HashMap<String, Double> ExpectedPrice(){
        HashMap<String, Double> map = new HashMap<String, Double>();

        XSSFSheet sheet = workbook.getSheet("CRM PRICE");
        for(int i = 1; i <= sheet.getLastRowNum(); i++){
            XSSFRow row = sheet.getRow(i);
            String productBundle = row.getCell(0).getStringCellValue();
            double amount;
            try {
                 amount = row.getCell(3). getNumericCellValue();
            } catch (Exception e){
                amount = -999999;
            }


            if(map.containsKey(productBundle)){
//                System.out.println("dup " + productBundle + " " + amount);

            } else{
                map.put(productBundle, amount);

            }

        }

        return map;

    }


    public HashMap<String, Double> ActualPrice(){
        HashMap<String, Double> map = new HashMap<String, Double>();

        XSSFSheet sheet = workbook.getSheet("PriceList");
        for(int i = 1; i <= sheet.getLastRowNum(); i++){
            XSSFRow row = sheet.getRow(i);
            String productBundle = row.getCell(0).getStringCellValue();
            double amount;
            try {
                amount = row.getCell(3). getNumericCellValue();
            } catch (Exception e){
                amount = -1;
            }


            if(map.containsKey(productBundle)){
                System.out.println("dup " + productBundle + " " + amount);

            } else{
                map.put(productBundle, amount);

            }

        }

        return map;

    }

    public HashMap<String, AE> aMap(){
        XSSFSheet sheet = workbook.getSheet("AE");
        HashMap<String, AE> map = new HashMap<String, AE>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String productName = row.getCell(0).getStringCellValue();
            String productID = row.getCell(1).getStringCellValue();
            String description = row.getCell(2).getStringCellValue();
            String status = row.getCell(3).getStringCellValue();
            String productStructure = row.getCell(4).getStringCellValue();

            AE m = new AE(productName, productID, description,status, productStructure );
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


    public HashMap<String, List<Suggestion>> ExpectedResultPC(){

        XSSFSheet sheet = workbook.getSheet("CRM RELATIONSHIP");

        HashMap<String, List<Suggestion>> map = new HashMap<String, List<Suggestion>>();
        for(int i = 1; i <= sheet.getLastRowNum(); i++){
            XSSFRow row = sheet.getRow(i);
            String productBundle = row.getCell(0).getStringCellValue();
            String relatedProduct = row.getCell(3).getStringCellValue();
            String saleRelationShip = row.getCell(4).getStringCellValue();
            String direction = row.getCell(5).getStringCellValue();
            System.out.println(saleRelationShip);
            if(saleRelationShip.trim().equals("Substitute")){
                continue;
            }

            if(map.containsKey(productBundle)){
                List<Suggestion> lp =  map.get(productBundle);
                lp.add(new Suggestion(productBundle, relatedProduct, saleRelationShip, direction));
            } else{
                List<Suggestion> lp = new ArrayList<Suggestion>();
                lp.add(new Suggestion(productBundle, relatedProduct, saleRelationShip, direction));
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
        XSSFSheet sheet = workbook.getSheet("Sheet3");
        HashMap<String, SBN> map = new HashMap<String, SBN>();

        for (int i = 3  ; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String productCode = row.getCell(0).getStringCellValue();
            String itemDescription = row.getCell(2).getStringCellValue();
            SBN s = new SBN(productCode, itemDescription);
            map.put(productCode, s);
        }

        return map;
    }


    public HashMap<String, List<Suggestion>> ExpectedSub() {

        XSSFSheet sheet = workbook.getSheet("CRM RELATIONSHIP");

        HashMap<String, List<Suggestion>> map = new HashMap<String, List<Suggestion>>();
        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            XSSFRow row = sheet.getRow(i);
            String productBundle = row.getCell(0).getStringCellValue();
            String relatedProduct = row.getCell(3).getStringCellValue();
            String saleRelationShip = row.getCell(4).getStringCellValue();
            String direction = row.getCell(5).getStringCellValue();
            System.out.println(saleRelationShip);
            if (saleRelationShip.trim().equals("Substitute")) {
                if (map.containsKey(productBundle)) {
                    List<Suggestion> suggestionList = map.get(productBundle);
                    suggestionList.add(new Suggestion(productBundle, relatedProduct, saleRelationShip, direction) );
                    map.put(productBundle, suggestionList);

                } else {
                    List<Suggestion> suggestionList = new ArrayList<Suggestion>();
                    suggestionList.add(new Suggestion(productBundle, relatedProduct, saleRelationShip, direction) );
                    map.put(productBundle, suggestionList);
                }
            }



        }
        return  map;
    }

    public static void main(String[] args) throws IllegalAccessException, InvalidFormatException, IOException {

        File a = new File("./src/main/resources/pc/CSV/ERV084UPCS.xlsx");
        File b = new File("./src/main/resources/pc/ProductAssociation.xlsx");
        File c = new File("./src/main/resources/pc/ProductRelationship.xlsx");
        File d = new File("./src/main/resources/pc/PriceList.xlsx");
        File e = new File("./src/main/resources/pc/CSV/Products And Bundles.xlsx");
        File f = new File("./src/main/resources/pc/Actual_Export.xlsx");
        File g = new File("./src/main/resources/pc/SBN items.xlsx");
        File h = new File("./src/main/resource/pc/CSV/Products.xlsx");


        ExcelReader er = new ExcelReader(a);
        ExcelReader er2 = new ExcelReader(b);
        ExcelReader er3 = new ExcelReader(c);
        ExcelReader er4 = new ExcelReader(d);
        ExcelReader er5 = new ExcelReader(e);
        ExcelReader er6 = new ExcelReader(f);
        ExcelReader er7 = new ExcelReader(g);
        ExcelReader er8 = new ExcelReader(h);

        HashMap<String, List<Product>> actualResult = er2.actualResult();
        HashMap<String, List<Suggestion>> actualResultPC = er3.actualResultPC();

        HashMap<String, List<Product>> expectedResultr = er.ExpectedResult();
        HashMap<String, List<Suggestion>> expectedResultPC = er.ExpectedResultPC();
        HashMap<String, List<Suggestion> > esMap = er.ExpectedSub();

        HashMap<String, Master> master = er.masterDataExpected();
        HashMap<String, Master> actualMaster = er8.ActualMaster();

        HashMap<String, AE> aeMap = er6.aMap();
        HashMap<String, List<Suggestion> >  asMap = er3.ActualSub();
        HashMap<String, SBN >  sbnMap = er7.getSBNFile();

        HashSet<String> productsInProdCad = er.productsInProdCad();
//        System.out.println(productsInProdCad.size());

        for(Map.Entry<String, Master> m: actualMaster.entrySet()) {
            System.out.println(m.getValue().productName + " | " + m.getValue().sageCode);
        }

//        for(Map.Entry<String, Master> h: master.entrySet()){
//
//
//
//            }
//        }


//        System.out.println("SBN Code | ProdCad Code");
//        for(String x: productsInProdCad){
//            if(sbnMap.containsKey(x)){
//                System.out.println( x+ " | " + x);
//
//            }else{
//                System.out.println(" NA | " + x);
//            }
//
//        }


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



