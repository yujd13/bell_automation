package ca.elecsoft.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Mandatory {

    public List<String> list;

    String[] mandatoryInformation = {
            "First Name:",
            "Last Name:",
            "Email:",
            "Preferred Language:",
            "Secondary Contact Number:",
            "Postal Code:",
            "City:",
            "Street Number:",
            "Street Name:",
            "Province:",
            "Type:",
            "Service Appointment Id:",
            "Appointment Reference Id:",
            "Date:",
            "Interval:",
            "Due Date Revision Number:"
    };

    public Mandatory() {
        this.list = new ArrayList<>();
        this.mandatoryInformation = mandatoryInformation;
    }


    public List<String> getList() {
        return list;
    }

    public Boolean mandatoryInformation(HashMap<String, String> map) {
        Boolean isList = true;
        for (String x : mandatoryInformation) {
            if (map.containsKey(x)) {

            } else {
                list.add(x);
                isList = false;
            }
        }
        return isList;

    }
}
