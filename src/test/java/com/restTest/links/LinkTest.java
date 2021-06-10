package com.restTest.links;

import com.restTest.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.startsWith;

/**
 * Testing links in REST response
 *
 * @author date
 */
public class LinkTest extends BaseTest {

    @Test
    public void doesLinkHasSecurePrefix() {
        Response response = doGetResponse(END_POINT);
        String loginValue = response.jsonPath().getString("html_url");
        assertThat(loginValue, startsWith("https://"));
    }
}