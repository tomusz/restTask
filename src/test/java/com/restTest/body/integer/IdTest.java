package com.restTest.body.integer;

import com.restTest.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Id related tests
 *
 * @author date
 */
public class IdTest extends BaseTest {

    @Test
    public void isNotNullValue () {
        Response response = doGetResponse(USERS_OCTOCAT);
        int loginValue = response.jsonPath().getInt("id");
        assertThat(loginValue, notNullValue());
    }

    @Test
    public void isMoreThenZero () {
        Response response = doGetResponse(USERS_OCTOCAT);
        int loginValue = response.jsonPath().getInt("id");
        assertThat(loginValue, greaterThan(0));
    }

}