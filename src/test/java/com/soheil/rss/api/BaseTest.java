package com.soheil.rss.api;

import com.soheil.rss.RssFetcherApplication;
import io.restassured.response.ValidatableResponse;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = RssFetcherApplication.class,
        webEnvironment = RANDOM_PORT
)
@ActiveProfiles("test")
public abstract class BaseTest {

    @LocalServerPort
    private int port;

    static final String ALL_MESSAGES = "/all";
    static final String LAST_MESSAGES = "/last?items=1";
    static final String LAST_TEN_MESSAGES = "/lastten";

    private String HOST_ROOT = "http://localhost/api/messages";

    ValidatableResponse prepareGet(String path) {
        return given()
                .port(port)
                .when()
                .get(HOST_ROOT + path)
                .then();
    }

}
