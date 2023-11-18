package org.example.graphql;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.given;

public class Mutation {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://rahulshettyacademy.com";

        String response = given().log().all().header("Content-Type","application/json")
                .body("{\"query\":\"mutation{\\n  createLocation(location: {name:\\\"Man\\\",type:\\\"South\\\",dimension:\\\"231\\\"}){\\n    id\\n  }\\n}\\n\",\"variables\":null}")
                .when().post("gq/graphql")
                .then().log().all().assertThat().statusCode(200).extract().asString();
        System.out.println(response);
        JsonPath jsonPath = new JsonPath(response);
        System.out.println(jsonPath.get("data.createLocation.id").toString());
    }
}
