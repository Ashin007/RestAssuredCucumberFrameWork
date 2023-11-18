package org.example.stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.example.pojo.addobject.AddPhoneObject;
import org.example.pojo.addobject.Data;
import org.example.utilis.Base;
import org.example.utilis.JsonToString;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class StepDefinition extends Base {

    RequestSpecification requestSpecification;
    ResponseSpecification responseSpecification;
    Response response;

    public static String objectId;



    @Given("User have all the prerequisites")
    public void user_have_all_the_prerequisites() throws FileNotFoundException {

        requestSpecification = given().spec(requestSpecification());
    }

    @When("User call {string} using {string} http request")
    public void user_call_using_http_request(String param, String httpRequest) {
        switch (httpRequest) {
            case "GET":
                response = requestSpecification.when().get(param);
                break;
            case "POST":
                response = requestSpecification.when().post(param);
                break;
            default:
                System.out.println("Wrong https request");

        }

    }

    @Then("status code should be {int}")
    public void status_code_should_be(Integer statusCode) {
        response.then().spec(responseSpecification()).assertThat().statusCode(statusCode).log().all();
    }

    @Then("phone names should be displayed")
    public void phone_names_should_be_displayed() {
        JsonPath jsonPath = new JsonPath(response.asString());
        int JsonArraySize = jsonPath.getList("id").size();
        for (int i = 0; i < JsonArraySize; i++) {
            System.out.println(jsonPath.get("[" + i + "].name").toString());
        }
    }

    @Given("User add {string} {string} {string} {string} {string}")
    public void userAddPhoneNameYearPriceCpuModelHardDiskSize(String phoneName, String year, String price, String cpuModel, String hardDisk) throws FileNotFoundException {
        AddPhoneObject addPhoneObject = new AddPhoneObject();
        Data data = new Data();
        data.setYear(year);
        data.setPrice(price);
        data.setCpuModel(cpuModel);
        data.setHardDiskSize(hardDisk);
        addPhoneObject.setName(phoneName);
        addPhoneObject.setData(data);
        requestSpecification = given().spec(requestSpecification().body(addPhoneObject));
    }

    @And("I should extract {string} from response")
    public void iShouldExtractFromResponse(String extractKey) {


        objectId = JsonToString.getData(response.asString(),extractKey);

    }

    @Given("User have all the prerequisites with query")
    public void userHaveAllThePrerequisitesWithQuery() throws FileNotFoundException {

        requestSpecification = given().spec(requestSpecification()).queryParam("id",objectId);
    }
}
