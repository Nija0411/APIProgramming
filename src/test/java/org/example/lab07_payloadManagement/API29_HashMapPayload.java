package org.example.lab07_payloadManagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.LinkedHashMap;
import java.util.Map;

public class API29_HashMapPayload {

    RequestSpecification req;
    Response rs;
    ValidatableResponse vr;

    @Test
    public void createBooking() {
        //String payload
//        String strPayload = "{\n" +
//                "    \"firstname\" : \"Nik\",\n" +
//                "    \"lastname\" : \"Sam\",\n" +
//                "    \"totalprice\" : 111,\n" +
//                "    \"depositpaid\" : true,\n" +
//                "    \"bookingdates\" : {\n" +
//                "        \"checkin\" : \"2018-01-01\",\n" +
//                "        \"checkout\" : \"2019-01-01\"\n" +
//                "    },\n" +
//                "    \"additionalneeds\" : \"Breakfast\"\n" +
//                "}";

        //Map payload
        Map<String, Object> mapPayload = new LinkedHashMap<>();
        mapPayload.put("firstname","Nikhita");
        mapPayload.put("lastname", "Jalapure");
        mapPayload.put("totalprice", 392);
        mapPayload.put("depositpaid", true);

        Map<String, Object> bookingdates = new LinkedHashMap<>();
        bookingdates.put("checkin", "2018-01-01");
        bookingdates.put("checkout", "2019-01-01");

        mapPayload.put("bookingdates", bookingdates);
        mapPayload.put("additionalneeds", "Breakfast");

        req = RestAssured.given();
        req.baseUri("https://restful-booker.herokuapp.com");
        req.basePath("/booking");
        req.contentType(ContentType.JSON);
        req.body(mapPayload).log().all();

        rs = req.when().post();

        vr = rs.then().log().all().statusCode(200);

        //Extraction
        String firstname = rs.then().extract().path("booking.firstname");
        boolean depositpaid = rs.then().extract().path("booking.depositpaid");
        int totalprice = rs.then().extract().path("booking.totalprice");

        assertThat(firstname).isEqualTo("Nikhita").isNotNull().isAlphabetic();
        assertThat(depositpaid).isEqualTo(true);
        assertThat(totalprice).isEqualTo(392);
    }
}
