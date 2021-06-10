package com.restTest.integer;

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
        Response response = doGetResponse(END_POINT);
        int loginValue = response.jsonPath().getInt("public_repos");
        assertThat(loginValue, notNullValue());
    }

    @Test
    public void isNotLessThenZero () {
        Response response = doGetResponse(END_POINT);
        int loginValue = response.jsonPath().getInt("public_repos");
        assertThat(loginValue, greaterThanOrEqualTo(0));
    }
}