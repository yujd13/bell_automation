package ca.elecsoft.version.twozerothreeE;

import ca.elecsoft.reader.ReadAccountEntityVersionE;
import ca.elecsoft.util.Prop;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;


/**
 * This class is for inserting into the database the information from the actual file
 */
public class InsertProdCadAVersionE {
    public static void main(String[] args) throws InvalidFormatException, SQLException, IOException {
        Prop p = Prop.getINSTANCE();
        //this is for getting the file
        File actualFile = new File(p.loadProp("ACTUAL_FILE"));
        //this is for inserting the informatino from the file into the database
        ReadAccountEntityVersionE.insertDatabaseSQLProdCadA(actualFile);

    }
}
