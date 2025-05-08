package org.example.lab04_httpMethod_bddAndNonbdd.A02_POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class RestfulBooker_CreateToken_NonBDD {

    //URL : https://restful-booker.herokuapp.com/auth

    String payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    RequestSpecification r;
    Response resp;
    ValidatableResponse vr;

    @Test
    public void postCreateToken() {

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.body(payload);
        r.contentType(ContentType.JSON);

        resp = r.when().post();

        vr = resp.then();
        vr.log().all().statusCode(200);

    }
}
