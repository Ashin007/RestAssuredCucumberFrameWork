package org.example.user;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.example.utilis.JsonToString;

import static io.restassured.RestAssured.given;

public class EndToEndUser {
    public static void main(String[] args) {


        RestAssured.baseURI = "https://petstore.swagger.io";
        //create user
//        String response = given().log().all().header("accept","application/json")
//                .header("Content-Type","application/json")
//                .body("{\n" +
//                        "  \"id\": 700,\n" +
//                        "  \"username\": \"heman\",\n" +
//                        "  \"firstName\": \"he\",\n" +
//                        "  \"lastName\": \"man\",\n" +
//                        "  \"email\": \"heman@gmail.com\",\n" +
//                        "  \"password\": \"string\",\n" +
//                        "  \"phone\": \"string\",\n" +
//                        "  \"userStatus\": 0\n" +
//                        "}")
//                .when().post("v2/user")
//                .then().assertThat().statusCode(200).extract().response().asString();
//        System.out.println(response);

        // get user
        String userName = "Hoorey";


        String afterPut = given().header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 700,\n" +
                        "  \"username\": \""+userName+"\",\n" +
                        "  \"firstName\": \"string\",\n" +
                        "  \"lastName\": \"string\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when().put("v2/user/"+userName)
                .then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(afterPut);


        System.out.println("---GET---");
        String getResponse = given().header("accept","application/json")
                .when().get("/v2/user/"+userName)
                .then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(getResponse);

        JsonPath jsonPath = new JsonPath(getResponse);
        String username = jsonPath.get("username");
        System.out.println(username);

        System.out.println("---PUT---");

        String newUserName = "Hoorey New";
        String firstName = "Hoorey";
        String lastName = "Jr";

        String putResponse = given().header("accept","application/json")
                .header("Content-Type","application/json")
                .body("{\n" +
                        "  \"id\": 0,\n" +
                        "  \"username\": \""+newUserName+"\",\n" +
                        "  \"firstName\": \""+firstName+"\",\n" +
                        "  \"lastName\": \""+lastName+"\",\n" +
                        "  \"email\": \"string\",\n" +
                        "  \"password\": \"string\",\n" +
                        "  \"phone\": \"string\",\n" +
                        "  \"userStatus\": 0\n" +
                        "}")
                .when().put("v2/user/"+userName)
                .then().log().all().assertThat().statusCode(200).extract().response().asString();


        getResponse = given().header("accept","application/json")
                .when().get("/v2/user/"+newUserName)
                .then().assertThat().statusCode(200).extract().response().asString();
        System.out.println(getResponse);



        System.out.println("---------FINAL OUTPUT-------");
        username = JsonToString.getData(getResponse,"username");
        System.out.println("Updated UserName: "+username);


    }
}
