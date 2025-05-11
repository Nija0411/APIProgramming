package org.example.lab07_payloadManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class API28_StringPayloadEx {

    String payload = "{\n" +
            "    \"firstname\" : \"Nik\",\n" +
            "    \"lastname\" : \"Sam\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";

    RequestSpecification re;
    Response rs;
    ValidatableResponse vR;

    @Test
    public void createBooking_post() {

        re = RestAssured.given();
        re.baseUri("https://restful-booker.herokuapp.com");
        re.basePath("/booking");
        re.contentType(ContentType.JSON);
        re.body(payload).log().all();

        rs = re.when().post();

        vR = rs.then().log().all();
        vR.statusCode(200);

        //Extraction
        int bookingId = rs.then().extract().path("bookingid");
        String firstname = rs.then().extract().path("booking.firstname");

        //validation using TestNG
        Assert.assertEquals(firstname, "Nik");
        Assert.assertNotNull(bookingId);

        //validation using AssertJ
        assertThat(bookingId).isNotZero().isNotNegative().isNotNull();
        assertThat(firstname).isEqualTo("Nik").isNotEmpty().isAlphabetic().isNotNull();

    }

}
