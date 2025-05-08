package org.example.Lab01_basics;

import io.restassured.RestAssured;

import java.util.Scanner;

class PincodeAPI {
    public static void main(String[] args) {

        // Gherkins Syntax
        // Given() -> Pre Req. - URL, Headers, Auth, Body....
        // When() -> HTTP method? - GET/POST/PUT/PATCH, DELETE...
        // Then() -> Validation -> 200 oK, firstname == PRAMOD

        //Full URL: https://api.postalpincode.in/pincode/591263
        //Base URI: https://api.postalpincode.in/
        //Base Path: pincode/591263

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a Pincode: ");
        int pincode = input.nextInt();

        RestAssured.given().
                baseUri("https://api.postalpincode.in/").
                basePath("pincode/" + pincode).
                when().get().then().log().all().statusCode(200);


    }
}
