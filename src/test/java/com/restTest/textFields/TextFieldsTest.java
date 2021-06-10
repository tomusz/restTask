package com.restTest.textFields;

import com.restTest.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.assertTrue;

/**
 * Test sets validating fields positive testing
 *
 * @author date
 */
public class TextFieldsTest extends BaseTest {

    @Test
    public void isLoginAsExpected() {
        Response response = doGetResponse(END_POINT);
        String loginValue = response.jsonPath().getString("login");
        assertThat(loginValue, equalTo("octocat"));
    }

    @Test
    public void emailIsRequired() {
        Response response = doGetResponse(END_POINT);
        String result = response.jsonPath().getString("email");
        assertThat(result, not(nullValue()));
    }

    @Test
    public void doesEmailAddressHasSpecialSign() {
        Response response = doGetResponse(END_POINT);
        String result = response.jsonPath().getString("email");
        assertTrue(result.contains("@"));
    }


    @Test
    public void validationOfBaseFields() {
        validationOfTextFieldValues("login" , "octocat");
        validationOfTextFieldValues("node_id" , "MDQ6VXNlcjU4MzIzMQ==");
        validationOfTextFieldValues("name" , "The Octocat");
        validationOfTextFieldValues("company" , "@github");
    }

    @Test
    public void hasTypeUser() {
        validationOfTextFieldValues("type" , "User");
    }

}