package com.restTest.header.date;

import com.restTest.BaseTest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.hamcrest.number.OrderingComparison;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Date validation from header
 *
 * @author date
 */
public class HeaderDateTest extends BaseTest {

    @Test
    public void dateIsTodayDate() {
        RestAssured.given().get(USERS_OCTOCAT)
                .then()
                .header("date", date -> LocalDate.parse(date, DateTimeFormatter.RFC_1123_DATE_TIME),
                        OrderingComparison.comparesEqualTo(LocalDate.now()));
    }

    @Test
    public void dateIsGraterThenUpdateDate() {
        LocalDate date = LocalDate.parse(doGetResponse(USERS_OCTOCAT).header("date"),
                DateTimeFormatter.RFC_1123_DATE_TIME);
        LocalDate modificationDate = LocalDate.parse(doGetResponse(USERS_OCTOCAT).header("last-modified"),
                DateTimeFormatter.RFC_1123_DATE_TIME);
        assertThat(date, Matchers.greaterThanOrEqualTo(modificationDate));
    }

}