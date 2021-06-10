package com.restTest.date;

import com.restTest.BaseTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.testng.Assert.assertTrue;

/**
 * Date related tests
 *
 * @author date
 */
public class DateFieldTest extends BaseTest {

    private String datePattern = "[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}Z";
    private Pattern pattern = Pattern.compile(datePattern);

    @Test
    public void isCreatedDateNotNull() {
        dateIsRequired("created_at");
    }

    @Test
    public void isUpdatedDateNotNull() {
        dateIsRequired("updated_at");
    }

    @Test
    public void isCreatedDateInProperFormat() {
        validationOfDateFormat("created_at");
    }

    @Test
    public void isUpdatedDateInProperFormat() {
        validationOfDateFormat("updated_at");
    }



    /**
     * Method to validate if date is not null
     *
     * @param fieldName to be validate
     */
 private void dateIsRequired(String fieldName) {
     Response response = doGetResponse(END_POINT);
     String result = response.jsonPath().getString(fieldName);
     assertThat(result, not(nullValue()));
 }

    /**
     * Method validating date format
     *
     * @param date to be validated
     */
 private void validationOfDateFormat(String date) {
     Response response = doGetResponse(END_POINT);
     String result = response.jsonPath().getString(date);
     Matcher matcher = pattern.matcher(result);
     assertTrue(matcher.matches());
 }
}