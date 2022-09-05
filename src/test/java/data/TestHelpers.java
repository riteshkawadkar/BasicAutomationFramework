package data;

import java.util.HashMap;
import java.util.Map;

public class TestHelpers {

    public static Map<String, String> registerAPatient(){
        //register a patient
        Map<String, String> map = new HashMap<>();
        map.put("GIVEN", Constants.GIVEN);
        map.put("FAMILYNAME", Constants.FAMILYNAME);
        map.put("GENDER", Constants.GENDER);
        map.put("BIRTHDATE", Constants.BIRTHDATE);
        map.put("BIRTHMONTH", Constants.BIRTHMONTH);
        map.put("BIRTHYEAR", Constants.BIRTHYEAR);
        map.put("ADDRESS1", Constants.ADDRESS1);
        map.put("ADDRESS2", Constants.ADDRESS2);
        map.put("CITY", Constants.CITY);
        map.put("STATE", Constants.STATE);
        map.put("COUNTRY", Constants.COUNTRY);
        map.put("POSTALCODE", Constants.POSTALCODE);
        map.put("PHONE", Constants.PHONE);
        map.put("RELATIONSHIPTYPE", Constants.RELATIONSHIPTYPE);
        map.put("RELATIONSHIPPERSON", Constants.RELATIONSHIPPERSON);
        return map;
    }
}
