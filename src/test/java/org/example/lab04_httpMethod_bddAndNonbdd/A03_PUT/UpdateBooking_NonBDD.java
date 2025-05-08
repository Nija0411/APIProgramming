package org.example.lab04_httpMethod_bddAndNonbdd.A03_PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class UpdateBooking_NonBDD {

    String token = "97458eb2eac5781";
    String bookingId = "1931";

    String payload = "{\n" +
            "    \"firstname\" : \"Nikhita\",\n" +
            "    \"lastname\" : \"Sam\",\n" +
            "    \"totalprice\" : 906,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2025-06-09\",\n" +
            "        \"checkout\" : \"2025-06-10\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    @Test
    public void updateBooking() {

        RequestSpecification reqSpec = RestAssured.given();
        reqSpec.baseUri("https://restful-booker.herokuapp.com/");
        reqSpec.basePath("booking/" + bookingId);
        reqSpec.cookie("token", token);
        reqSpec.contentType(ContentType.JSON);
        reqSpec.body(payload);
        reqSpec.log().all();

        Response response = reqSpec.when().put();

        ValidatableResponse vResponse = response.then();
        vResponse.log().all()
                .statusCode(200);
    }
}
