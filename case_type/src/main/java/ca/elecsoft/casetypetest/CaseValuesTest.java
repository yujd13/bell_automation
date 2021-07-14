package ca.elecsoft.casetypetest;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashSet;

public class CaseValuesTest {

    private String removeTag(String x) {
        return x.split("_")[0];
    }

    @Test
    public void testCaseValues() throws IOException, InvalidFormatException {
        CaseMap cm = CaseMap.getInstance();
        HashSet<String> actual = cm.getHashSetActual();
        HashSet<String> expected = cm.getHashSetExpected();

//        Iterator f = actual.iterator();
//        Iterator a = expected.iterator();
//
//        while(f.hasNext()){
//            System.out.println( a.next() + "," + f.next());
//        }
//
//        System.out.println(actual.size());
//        System.out.println(expected.size());

        Reporter.log("All issues found are below");
        String row = "Case Sub Type| Case Type| Process | CustomerType | Work Order Type | Work Order Sub Type |  Priority | SearchKey";
        Reporter.log(row);

        for (String x : expected) {
            if (actual.contains(x)) {
            } else {
                String[] d = x.split(";");

                String caseSubType = removeTag(d[0]);
                String caseType = removeTag(d[1]);
                String process = removeTag(d[2]);
                String customerType = removeTag(d[3]);
                String WorkOrderType = removeTag(d[4]);
                String WorkOrderSubType = removeTag(d[5]);
                String Priority = removeTag(d[6]);
//                Reporter.log(x);
                Reporter.log(caseSubType + "|" + caseType + "|" + process + "|" + customerType + "|" + WorkOrderType + "|" + WorkOrderSubType + "|" + Priority+"|"+x);

            }
        }


    }
}

