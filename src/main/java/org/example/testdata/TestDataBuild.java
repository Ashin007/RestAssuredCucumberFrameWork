package org.example.testdata;

import org.example.objects.AddObjects;
import org.example.pojo.addobject.AddPhoneObject;
import org.example.pojo.addobject.Data;

public class TestDataBuild {

    public AddPhoneObject getPhoneInputs(){

        AddPhoneObject phoneObjects = new AddPhoneObject();
        Data data = new Data();
        data.setYear("2020");
        data.setPrice("16999");
        data.setCpuModel("Qualcom");
        data.setHardDiskSize("60 GB");
        phoneObjects.setName("Realme XT");
        phoneObjects.setData(data);

        return phoneObjects;
    }
}
