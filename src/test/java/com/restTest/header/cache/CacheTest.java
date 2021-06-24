package com.restTest.header.cache;

import com.restTest.BaseTest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsStringIgnoringCase;

/**
 * Base cache control validation from header
 *
 * @author date
 */
public class CacheTest extends BaseTest {

    @Test
    public void maxAgeOfCache() {
        RestAssured.given()
                .get(USERS_OCTOCAT)
                .then()
                .header("cache-control", Matchers.containsStringIgnoringCase("max-age=60"));
    }

}