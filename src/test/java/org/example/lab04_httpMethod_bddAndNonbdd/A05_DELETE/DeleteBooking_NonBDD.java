package org.example.lab04_httpMethod_bddAndNonbdd.A05_DELETE;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class DeleteBooking_NonBDD {

    String token = "02a3e36583b70b9";
    String bookingId = "62";

    RequestSpecification request;
    Response response;
    ValidatableResponse vResponse;

    @Test
    public void deleteBooking(){

        request = RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/booking/"+bookingId);
        request.cookie("token", token);

        response = request.when().delete();

        vResponse = response.then().log().all().statusCode(201);
    }
}
