package org.example.Lab03_testng;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

//To use testng class should be public

public class MultipleTCWithTestNG_Autotestngxml {
    //No main() method is required
    //Temparory sanitytestng.xml file will be created by testng - here we need to add testng dependency
    /* What is a temporary sanitytestng.xml?
    It is auto-generated and not visible in your project structure.
    It contains only the selected classes/methods.
    It is deleted after the test run completes.
    Ideal for quick test execution, but not for organizing large test suites. */

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
