package utilities;

import java.util.Map;

public class GenericFunctions {

    public static boolean compareMap(Map<String, String> map1, Map<String, String> map2) {

        if (map1 == null || map2 == null)
            return false;

        for (String ch1 : map1.keySet()) {
            if (!map1.get(ch1).equalsIgnoreCase(map2.get(ch1)))
                return false;

        }
        for (String ch2 : map2.keySet()) {
            if (!map2.get(ch2).equalsIgnoreCase(map1.get(ch2)))
                return false;

        }

        return true;
    }
}
