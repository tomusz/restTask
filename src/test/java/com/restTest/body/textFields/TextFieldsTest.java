package com.restTest.body.textFields;

import com.restTest.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.DataProvider;
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
        Response response = doGetResponse(USERS_OCTOCAT);
        String loginValue = response.jsonPath().getString("login");
        assertThat(loginValue, equalTo("octocat"));
    }

    @Test
    public void emailIsRequired() {
        Response response = doGetResponse(USERS_OCTOCAT);
        String result = response.jsonPath().getString("email");
        assertThat(result, not(nullValue()));
    }

    @Test
    public void doesEmailAddressHasSpecialSign() {
        Response response = doGetResponse(USERS_OCTOCAT);
        String result = response.jsonPath().getString("email");
        assertTrue(result.contains("@"));
    }

    @DataProvider(name = "inputValidation")
    private Object[][] inputValidation() {
        return new Object[][] {
                {"login" , "octocat"},
                {"node_id" , "MDQ6VXNlcjU4MzIzMQ=="},
                {"name" , "The Octocat"},
                {"company" , "@github"}};
    }

    @Test(dataProvider = "inputValidation")
    public void validationOfBaseFields(String field, String expectedValue) {
        validationOfTextFieldValues(field , expectedValue);
    }

    @Test
    public void hasTypeUser() {
        validationOfTextFieldValues("type" , "User");
    }

}