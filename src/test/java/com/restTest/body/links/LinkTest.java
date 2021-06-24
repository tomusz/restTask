package com.restTest.body.links;

import com.restTest.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;

/**
 * Testing links in REST response
 *
 * @author date
 */
public class LinkTest extends BaseTest {

    @Test
    public void doesLinkHasSecurePrefix() {
        Response response = doGetResponse(USERS_OCTOCAT);
        String loginValue = response.jsonPath().getString("html_url");
        assertThat(loginValue, startsWith("https://"));
    }
}