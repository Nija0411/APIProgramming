package org.example.lab06_assertions;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class API25_RestAssuredAssertions {
    //Validate a Response body for create booking - POST (Restful Booker Project)

    RequestSpecification reqSpec;
    Response response;
    ValidatableResponse vResp;

    String token;

    @Owner("Nikhita")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC#1 Verify that Create Booking is working fine and bookingId is not null")
    @Test
    public void createBooking() {
        String payload = "{\n" +
                "    \"firstname\" : \"Nikhita\",\n" +
                "    \"lastname\" : \"J\",\n" +
                "    \"totalprice\" : 392,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2025-05-15\",\n" +
                "        \"checkout\" : \"2025-05-21\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        reqSpec = RestAssured.given();
        reqSpec.baseUri("https://restful-booker.herokuapp.com");
        reqSpec.basePath("/booking");
        reqSpec.contentType(ContentType.JSON);
        reqSpec.body(payload).log().all();


        response = reqSpec.when().post();

        vResp = response.then().log().all();
        //verify status code
        vResp.statusCode(200);

        //verify body
        vResp.body("booking.firstname", Matchers.equalTo("Nikhita"));
        vResp.body("bookingid", Matchers.notNullValue());
        vResp.body("booking.totalprice", Matchers.equalTo(392));
    }
}
