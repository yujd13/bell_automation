package ca.elecsoft.version.twozerofourA;

import ca.elecsoft.reader.ReadAccountEntityVersionA;
import ca.elecsoft.reader.ReadAccountEntityVersionE;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class InsertProdCadAVersionA {
    public static void main(String[] args) throws InvalidFormatException, SQLException, IOException {
        File actualFile = new File("./src/main/resources/product-catalogue/version-a/Actual-1.xlsx");
        ReadAccountEntityVersionA.insertDatabaseSQLProdCadA(actualFile);

    }
}
