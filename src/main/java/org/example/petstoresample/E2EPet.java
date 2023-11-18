package org.example.petstoresample;

import io.restassured.RestAssured;

public class E2EPet {
    public static void main(String[] args) {
        //create pet-->get the pet-->delete pet-->confirm delete

        RestAssured.baseURI = "https://petstore.swagger.io";
    }
}
