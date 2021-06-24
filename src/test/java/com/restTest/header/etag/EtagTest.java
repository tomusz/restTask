package com.restTest.header.etag;

import com.restTest.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;

public class EtagTest extends BaseTest {

    @Test
    public void isNotNull() {
        RestAssured.given()
                .get(USERS_OCTOCAT)
                .then()
                .header("etag", not(nullValue()));
    }

    @Test
    public void isNotEmpty() {
        RestAssured.given()
                .get(USERS_OCTOCAT)
                .then()
                .header("etag", not(emptyString()));
    }

}