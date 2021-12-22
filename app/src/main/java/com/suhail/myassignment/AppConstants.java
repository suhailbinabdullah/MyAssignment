package com.suhail.myassignment;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class AppConstants {

    public static String jsonString = "{\n" +
            "  \"Exam Fee\": {\n" +
            "    \"INDIAN\": {\n" +
            "      \"ALL_COURSES\": {\n" +
            "        \"ALL_LEVEL\": {\n" +
            "          \"amount\": 400\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"FOREIGN\": {\n" +
            "      \"ALL_COURSES\": {\n" +
            "        \"ALL_LEVEL\": {\n" +
            "          \"amount\": 100\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"NRI\": {\n" +
            "      \"ALL_COURSES\": {\n" +
            "        \"ALL_LEVEL\": {\n" +
            "          \"amount\": 600\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"SAARC\": {\n" +
            "      \"ALL_COURSES\": {\n" +
            "        \"ALL_LEVEL\": {\n" +
            "          \"amount\": 600\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  },\n" +
            "  \"Application Fee\": {\n" +
            "    \"INDIAN\": {\n" +
            "      \"ALL_COURSES\": {\n" +
            "        \"UG\": {\n" +
            "          \"amount\": 200\n" +
            "        },\n" +
            "        \"UG-DIPLOMA\": {\n" +
            "          \"amount\": 300\n" +
            "        },\n" +
            "        \"PG\": {\n" +
            "          \"amount\": 500\n" +
            "        }\n" +
            "      }\n" +
            "    },\n" +
            "    \"FOREIGN\": {\n" +
            "      \"ALL_COURSES\": {\n" +
            "        \"UG\": {\n" +
            "          \"amount\": 400\n" +
            "        },\n" +
            "        \"UG-DIPLOMA\": {\n" +
            "          \"amount\": 400\n" +
            "        },\n" +
            "        \"PG\": {\n" +
            "          \"amount\": 700\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";


    public static JSONObject getJsonObject() {
        JSONObject obj;

        {
            try {
                obj = new JSONObject(jsonString);
                return obj;

            } catch (JSONException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static FeeStructure getFeeStructure() {
        ObjectMapper om = new ObjectMapper();
        try {
            FeeStructure root = om.readValue(AppConstants.jsonString, FeeStructure.class);
            return root;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
