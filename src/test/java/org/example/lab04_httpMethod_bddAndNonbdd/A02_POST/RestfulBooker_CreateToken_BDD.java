package org.example.lab04_httpMethod_bddAndNonbdd.A02_POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class RestfulBooker_CreateToken_BDD {

    String payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";

    //URL : https://restful-booker.herokuapp.com/auth

    @Test
    public void postCreateToken() {
        RestAssured.
        given().
                baseUri("https://restful-booker.herokuapp.com/").
                basePath("auth").
                body(payload).
                contentType(ContentType.JSON)
        .when().
                post().
        then().
                log().all().
                statusCode(200);

    }
}
