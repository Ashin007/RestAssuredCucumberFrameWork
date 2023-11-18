package org.example.utilis;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.util.Properties;

public class Base {


    static RequestSpecification requestSp;
    ResponseSpecification responseSp;
    public RequestSpecification requestSpecification() throws FileNotFoundException {
        if(requestSp == null){
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            requestSp = new RequestSpecBuilder().setContentType(ContentType.JSON)
                    .setBaseUri(getPropertiesData("BASE_URL")).addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log)).build();

        }

        return requestSp;

    }

    public  ResponseSpecification responseSpecification(){
        responseSp = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
        return responseSp;
    }

    public String getPropertiesData(String key){

        Properties properties = new Properties();
        FileInputStream fileInputStream;

        {
            try {
                fileInputStream = new FileInputStream("src\\main\\java\\org\\example\\resources\\config.properties");
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            properties.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties.getProperty(key);
    }


}
