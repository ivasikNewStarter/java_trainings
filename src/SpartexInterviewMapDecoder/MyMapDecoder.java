package SpartexInterviewMapDecoder;

/**
 * Created by u0139221 on 2/20/2020.
 */

import java.util.HashMap;
import java.util.Map;

public class MyMapDecoder implements MapDecoder{


    @Override
    public Map<String, String> decode(String str) {

        Map <String,String> decodeMap = null;

        if (!str.isEmpty()) {

            String[] keyValueArray = str.split("&");

            for (String keyValue : keyValueArray) {
                if (!keyValue.contains("=")){
                    throw new IllegalArgumentException("invalid format");

                }
                String[] mapString = keyValue.split("=");
                decodeMap.put(mapString[0], mapString.length > 1? mapString[1]: "");
            }

        }

        return decodeMap;
    }

    public static void main(String[] args) {

    }
}
