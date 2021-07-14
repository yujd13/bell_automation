package ca.elecsoft.casetypetest;

import ca.elecsoft.dynamics.Prop;
import ca.elecsoft.dynamics.ReadActualCaseFile;
import ca.elecsoft.dynamics.ReadCaseFile;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class CaseMap {
    public static CaseMap INSTANCE;

    private CaseMap() {


    }

    public static CaseMap getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CaseMap();
        }
        return INSTANCE;
    }

    public HashSet<String> getHashSetExpected() throws IOException, InvalidFormatException, IOException, InvalidFormatException {
        Prop prop = Prop.getInstance();
        ReadCaseFile rcf = new ReadCaseFile(new File(prop.loadProp(prop.getCASETYPE_FILE())));
        String[][] ans = rcf.readInput();
        HashSet<String> set = new HashSet<>();

        for (String[] x : ans) {
            StringBuffer key = new StringBuffer();
            for (String d : x) {
                String transform = d.toUpperCase().trim();
                transform = transform.replace(" ", "").trim();
                key.append(transform);
                key.append(";");
            }
            set.add(key.toString());
        }
        return set;
    }

    public HashSet<String> getHashSetActual() throws IOException, InvalidFormatException, IOException, InvalidFormatException {
        Prop prop = Prop.getInstance();
        ReadActualCaseFile rcf = new ReadActualCaseFile(new File(prop.loadProp(prop.getCASE_ACTUAL_FILE())));
        String[][] ans = rcf.readInput();
        HashSet<String> set = new HashSet<>();
        for (String[] x : ans) {
            StringBuffer key = new StringBuffer();
            for (int i = 0; i < x.length; i++) {
                String d = x[i];
                if (i == 4) {
                    String[] a = d.split("/");
                    d = a[0]+"_WTYPE";
                }

                String transform = d.toUpperCase().trim();
                transform = transform.replace(" ", "").trim();
                key.append(transform);
                key.append(";");
            }
            set.add(key.toString());
        }


        return set;
    }


    public static void main(String[] args) throws IOException, InvalidFormatException {
        CaseMap cm = CaseMap.getInstance();
        HashSet<String> map = cm.getHashSetActual();
        System.out.println(map.size());

        for (String x : cm.getHashSetExpected()) {
            if (map.contains(x)) {
            } else {
                String[] d = x.split(";");
                System.out.println(Arrays.toString(d));

            }
        }


    }


}
