package org.example.graphql;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class Query {

    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().header("Content-Type","application/json")
                .body("{\"query\":\"\\nquery{\\n  location(locationId:3148){\\n    id\\n    name\\n    type\\n    dimension\\n  }\\n}\",\"variables\":null}")
                .when().post("gq/graphql")
                .then().log().all().assertThat().statusCode(200).extract().asString();
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        System.out.println(jsonPath.get("data.location.name").toString());
    }
}
