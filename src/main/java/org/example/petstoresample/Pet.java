package org.example.petstoresample;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class Pet {
    public static void main(String[] args) {

        RestAssured.baseURI = "https://petstore.swagger.io";
        given().queryParam("status","available")
                .header("Content-Type","application/json")
                .when().get("/v2/pet/findByStatus")
                .then().log().all().assertThat().statusCode(200);
    }
}
