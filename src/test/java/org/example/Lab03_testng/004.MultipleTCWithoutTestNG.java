package org.example.Lab03_testng;

import io.restassured.RestAssured;

class MultipleTCWithoutTestNG {
    public static void main(String[] args) {

        //Positive TC
        String pincode = "110048";
        RestAssured.
                given().
                baseUri("https://api.zippopotam.us").basePath("/IN/" + pincode).
                when().
                get().
                then().
                log().all().statusCode(200);

        //Negative TC
        pincode = "@";
        RestAssured.
                given().
                baseUri("https://api.zippopotam.us").basePath("/IN/" + pincode).
                when().
                get().
                then().
                log().all().statusCode(200);

        //Negative TC
        pincode = " ";
        RestAssured.
                given().
                baseUri("https://api.zippopotam.us").basePath("/IN/" + pincode).
                when().
                get().
                then().
                log().all().statusCode(200);

    }
}
