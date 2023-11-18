package org.example.utilis;

import io.restassured.path.json.JsonPath;

public class JsonToString {

    public static String getData(String jsonData,String expectedNode){
        JsonPath jsonPath = new JsonPath(jsonData);
        return jsonPath.get(expectedNode);
    }
}
