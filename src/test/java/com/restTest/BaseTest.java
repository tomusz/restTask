package com.restTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Common fields and configurations for other tests
 *
 * @author date
 */
public class BaseTest {

    protected static final String END_POINT = "https://api.github.com/users/octocat";

    protected static Response doGetResponse(String endpoint) {
        RestAssured.defaultParser = Parser.JSON;

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
        Response response = doGetResponse(END_POINT);
        String result = response.jsonPath().getString(fieldName);
        assertThat(expectedValue, equalTo(result));
    }

}
