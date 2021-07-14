package ca.elecsoft.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Prop {
    public static Prop INSTANCE;
    Properties prop;

    private Prop() {
        try (InputStream input = new FileInputStream(new File("./config.prop"))) {
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Prop getINSTANCE() {
        if (INSTANCE == null) {
            INSTANCE = new Prop();
        }
        return INSTANCE;
    }

    public String loadProp(String key) {
        return prop.getProperty(key);
    }


}