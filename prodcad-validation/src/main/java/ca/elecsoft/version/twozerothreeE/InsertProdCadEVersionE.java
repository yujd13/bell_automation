package ca.elecsoft.version.twozerothreeE;

import ca.elecsoft.reader.ReadAccountEntityVersionE;
import ca.elecsoft.util.Prop;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
/**
 * This class is for inserting into the database the information from the expected file
 */
public class InsertProdCadEVersionE {
    public static void main(String[] args) throws InvalidFormatException, SQLException, IOException {
        Prop p = Prop.getINSTANCE();
        File expectedFile = new File(p.loadProp("EXPECTED_FILE"));
        ReadAccountEntityVersionE.insertDatabaseSQLProdCadE(expectedFile);

    }
}
