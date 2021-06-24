package com.restTest.header;

import com.restTest.BaseTest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

/**
 * Base header related tests
 *
 * @author date
 */
public class HeaderTest extends BaseTest {

    @Test
    public void rateLimitAmount() {
        RestAssured.given().get(USERS_OCTOCAT)
                .then().header("x-ratelimit-limit", Integer::parseInt, equalTo(60));
    }

    @Test
    public void remainingRateLimitLessThenRateLimit() {
        RestAssured.given().get(USERS_OCTOCAT)
                .then().header("x-ratelimit-limit", response -> Matchers.greaterThan(
                response.header("x-ratelimit-remaining")));
    }

}