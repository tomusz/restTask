package com.restTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Common fields and configurations for other tests
 *
 * @author date
 */
public class BaseTest {

    protected static final String USERS_OCTOCAT = "https://api.github.com/users/octocat";

    @Test
    public void smokeTest() {
        RestAssured.given().get(USERS_OCTOCAT)
                .then()
                .time(Matchers.lessThan(2L), TimeUnit.SECONDS);
    }

    /**
     * Method for geting the response by provided endpoint
     *
     * @param endpoint to be validated
     * @return Response for further validation
     */
    protected static Response doGetResponse(String endpoint) {

        return RestAssured
                .given().header("Content-Type", ContentType.JSON, //
                        "Accept", ContentType.JSON)
                .when().get(endpoint)
                .then().contentType(ContentType.JSON).extract().response();
    }

    /**
     * method to validate response field
     *
     * @param fieldName to be validated
     * @param expectedValue that should be retrieved
     */
    protected void validationOfTextFieldValues(String fieldName,
                                             String expectedValue) {
        Response response = doGetResponse(USERS_OCTOCAT);
        String result = response.jsonPath().getString(fieldName);
        assertThat(expectedValue, equalTo(result));
    }

}