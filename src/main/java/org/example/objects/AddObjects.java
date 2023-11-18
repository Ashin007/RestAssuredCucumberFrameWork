package org.example.objects;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.pojo.addobject.Data;
import org.example.pojo.addobject.AddPhoneObject;

import static io.restassured.RestAssured.given;

public class AddObjects {
    public static void main(String[] args) {

        AddPhoneObject phoneObject = new AddPhoneObject();
        Data data = new Data();
        data.setYear("2024");
        data.setPrice("999");
        data.setCpuModel("N+ Core");
        data.setHardDiskSize("1 TB");

        phoneObject.setName("Nothing Max Pro");
        phoneObject.setData(data);

        RequestSpecification requestSpecification = new RequestSpecBuilder().setBaseUri("https://api.restful-api.dev")
                .setContentType(ContentType.JSON).build();
        ResponseSpecification responseSpecification = new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(200)
                .build();

        //RestAssured.baseURI = "https://api.restful-api.dev";
        requestSpecification = given().spec(requestSpecification)
                .body(phoneObject);

        Response response = requestSpecification.when().post("objects")
                .then().log().all().spec(responseSpecification).extract().response();

        System.out.println(response.asString());


    }
}
