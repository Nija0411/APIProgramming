package org.example.lab04_httpMethod_bddAndNonbdd.A04_PATCH;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class PartialUpdate_NonBDD {

    String payload = "{\n" +
            "    \"firstname\" : \"Nik\",\n" +
            "    \"lastname\" : \"Sam\"\n" +
            "}";
    String token = "654a819d5065031";
    String bookingId = "1468";

    RequestSpecification req;
    Response response;
    ValidatableResponse valRe;

    @Test
    public void partialUpdateBooking() {

        req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking/" + bookingId);
        req.contentType(ContentType.JSON);
        req.cookie("token", token);
        req.body(payload);

        response = req.when().patch();

        valRe = response.then().statusCode(200);

    }

}
