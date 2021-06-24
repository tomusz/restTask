package com.restTest.statusCode;

import com.restTest.BaseTest;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.not;

/**
 * Test set validation status codes
 *
 * @author date
 */
public class StatusCodesTest extends BaseTest {

    @Test
    public void statusCode() {
        RestAssured.get(USERS_OCTOCAT)
                .then()
                .statusCode(200);
    }

    @Test
    public void statusCodeIsNotNotFound() {
        RestAssured.get(USERS_OCTOCAT)
                .then()
                .statusCode(not(404));
    }

    @Test
    public void statusCodeIsNotServer() {
        RestAssured.get(USERS_OCTOCAT)
                .then()
                .statusCode(not(500));
    }

}