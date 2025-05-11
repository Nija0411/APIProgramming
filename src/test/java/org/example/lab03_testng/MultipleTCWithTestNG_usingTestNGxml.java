package org.example.lab03_testng;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class MultipleTCWithTestNG_usingTestNGxml {

    String pincode;

    @Test
    public void positive_tc1() {
        pincode = "110048";
        RestAssured.given().
                baseUri("https://api.zippopotam.us").basePath("/IN/" + pincode).
                when().get().
                then().log().all().statusCode(200);
    }

    @Test
    public void negative_tc2() {
        pincode = "@";
        RestAssured.given().
                baseUri("https://api.zippopotam.us").basePath("/IN/" + pincode).
                when().get().
                then().log().all().statusCode(200);
    }

    @Test
    public void negative_tc3() {
        pincode = " ";
        RestAssured.given().
                baseUri("https://api.zippopotam.us").basePath("/IN/" + pincode).
                when().get().
                then().log().all().statusCode(200);
    }
}
