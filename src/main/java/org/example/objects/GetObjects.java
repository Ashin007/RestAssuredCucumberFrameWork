package org.example.objects;

import com.fasterxml.jackson.core.type.TypeReference;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import org.example.pojo.GetPhoneObject;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetObjects {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://api.restful-api.dev";
        Type type = new TypeReference<List<GetPhoneObject>>() {}.getType();
        List<GetPhoneObject> object = given().log().all().header("Content-Type","application/json")
                    .queryParam("id","ff8081818b1b4123018b3a3624c327eb").expect().defaultParser(Parser.JSON)
                    .when().get("objects")
                    .then().assertThat().statusCode(200).extract().response().as(type);

//        System.out.println(getResponse);
//        JsonPath jsonPath = new JsonPath(getResponse);
//        System.out.println(jsonPath.get("[0].data.year").toString());

        System.out.println(object.get(0).getName());
        System.out.println(object.get(0).getData().getCpuModel());
        System.out.println(object.get(0));



    }
}
