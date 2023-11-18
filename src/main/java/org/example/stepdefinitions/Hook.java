package org.example.stepdefinitions;

import io.cucumber.java.Before;
import org.example.stepdefinitions.StepDefinition;


public class Hook {

    @Before("@GetPhoneUsingId")
    public void beforeScenario(){
        StepDefinition step = new StepDefinition();
        if(StepDefinition.objectId == null){
            System.out.println("default id assigned");
            StepDefinition.objectId = "ff8081818b1b4123018b77fc77687bc3";
        }
    }
}
