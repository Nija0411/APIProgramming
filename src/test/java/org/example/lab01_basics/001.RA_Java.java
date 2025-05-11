package org.example.lab01_basics;

import io.restassured.RestAssured;

class RA_Java {
    public static void main(String[] args) {

        RestAssured.given().baseUri("https://restful-booker.herokuapp.com/ping")
                .when().get().then().log().all().statusCode(200);
    }
}
