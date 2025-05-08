package org.example.lab04_httpMethod_bddAndNonbdd.A01_GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GET_BDDStyle {

    @Test
    public void get_positive_tc() {
        String pincode = "388620";

        RestAssured.
        given().
                log().all().
                baseUri("https://api.zippopotam.us").
                basePath("/IN/" + pincode).
        when().
                log().all().get().
        then().
                log().all().statusCode(200);
    }
}
