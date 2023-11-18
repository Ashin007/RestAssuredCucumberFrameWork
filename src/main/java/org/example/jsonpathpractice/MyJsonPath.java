package org.example.jsonpathpractice;

import io.restassured.path.json.JsonPath;
import org.example.utilis.PayLoad;

public class MyJsonPath {

    public static void main(String[] args){

        JsonPath jsonPath = new JsonPath(PayLoad.nestedJson());
        //System.out.println(jsonPath.getInt(".size()"));
        //System.out.println( jsonPath.get("[0].id").toString());
        int n = jsonPath.get("topping.size()");


        for(int i=0;i<n;i++){
            int  k = jsonPath.get("topping["+i+"].id.size()");

            for(int j=0;j<k;j++){
                System.out.println(jsonPath.get("topping["+i+"].id["+j+"]").toString());
                System.out.println(jsonPath.get("topping["+i+"].type["+j+"]").toString());

            }

        }
    }
}
