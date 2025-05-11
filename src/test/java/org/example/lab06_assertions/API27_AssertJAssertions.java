package org.example.lab06_assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

public class API27_AssertJAssertions {

    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    String token;
    @Test
    public void post_createBooking() {
        String body = "{\n" +
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

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(body).log().all();

        response = requestSpecification.when().post();

        //Using Rest Assured --> 5% used in Industry
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.body("booking.firstname", Matchers.equalTo("Nik"));
        validatableResponse.body("booking.lastname", Matchers.equalTo("Sam"));
        validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
        validatableResponse.body("bookingid", Matchers.notNullValue()).log().all();

        //Extraction
        int bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");
        String lastname = response.then().extract().path("booking.lastname");

        //validation using TestNG Assertion (Hard Assertion) --> 75% in industry
        Assert.assertEquals(firstname, "Nik");
        Assert.assertEquals(lastname, "Sam");
        Assert.assertNotNull(bookingId);

        //AssertJ assertion --> 20% used in industry
        assertThat(bookingId).isNotNull().isNotZero().isNotNegative();
        assertThat(firstname).isEqualTo("Nik").isNotBlank().isNotBlank().isNotEmpty();
         // String s = ""; //Empty
        //  String s2 = " "; //Blank
    }
}
