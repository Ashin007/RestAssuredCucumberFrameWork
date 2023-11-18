package org.example.restjavasample;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class Basic {
    public static void main(String[] args) {

        //validate if add place API is working as expected
        //given
        //when
        //then
        RestAssured.baseURI = "https://reqres.in";
        given().log().all().queryParam("page","2")
                .header("Connection","keep-alive")
                .when().get("api/users")
                .then().log().all().assertThat().statusCode(200)
                .body("page",equalTo(2))
                .header("Connection","keep-alive");
    }
}
