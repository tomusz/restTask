package com.restTest.body.integer;

import com.restTest.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 *  Test set validating number values
 *
 *  @author date
 */
public class NumberRelatedFieldTest extends BaseTest {

    @Test
    public void isNotNullValue () {
        Response response = doGetResponse(USERS_OCTOCAT);
        int loginValue = response.jsonPath().getInt("public_repos");
        assertThat(loginValue, notNullValue());
    }

    @Test
    public void isNotLessThenZero () {
        Response response = doGetResponse(USERS_OCTOCAT);
        int loginValue = response.jsonPath().getInt("public_repos");
        assertThat(loginValue, greaterThanOrEqualTo(0));
    }
}