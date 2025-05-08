package org.example.lab04_httpMethod_bddAndNonbdd.A01_GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GET_NonBDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse valresp;

    @Test
    public void get_positive_tc() {
        String pincode = "388620";

        //given() part
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);

        //when() part
        response = r.when().log().all().get();
        System.out.println(response.asString());

        //then() part
        valresp = response.then().log().all();
        valresp.statusCode(200);
    }

    @Test
    public void get_negative_tc(){
        String pincode = "@";

        //given
        r = RestAssured.given().log().all();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        //when
        response = r.when().get();

        //then
        valresp = response.then().log().all().statusCode(404);
    }
}
