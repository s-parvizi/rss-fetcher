package com.soheil.rss.api;

import org.junit.Test;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.Matchers.lessThan;

/**
 * @author : parvizis
 * @since : 12/23/18
 */

public class FeedMessageControllerTest extends BaseTest {

    @Test
    public void allFeedMessages() throws Exception {
        prepareGet(ALL_MESSAGES).statusCode(SC_OK);
    }

    @Test
    public void checkSchemaValidity() {
        prepareGet(ALL_MESSAGES)
                .assertThat()
                .body(matchesJsonSchemaInClasspath("schemas/feedmessage_schema.json"));
    }

    @Test
    public void checkResponseTimeAll() {
        prepareGet(ALL_MESSAGES)
                .time(lessThan(2000L));
    }

    @Test
    public void lastFeedMessages() throws Exception {
        prepareGet(LAST_MESSAGES).statusCode(SC_OK);
    }

    @Test
    public void lastTenFeedMessages1() throws Exception {
        prepareGet(LAST_TEN_MESSAGES).statusCode(SC_OK);
    }

}