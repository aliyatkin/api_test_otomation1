package com.apiTests.requests.serviceRequests.user_controller;

import com.apiTests.requests.serviceRequests.BaseTest;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.apiTests.constants.Endpoint.LOGOUT_ENDPOINT;
import static com.apiTests.constants.Language.en;
import static com.apiTests.constants.Language.language;
import static com.apiTests.requests.HelperMethod.requestBodyLoader;
import static io.restassured.RestAssured.given;

public class LogoutTests extends BaseTest {

    // Logger for tracking actions and output
    private static final Logger logger = LogManager.getLogger(LogoutTests.class);

    /**
     * Send a logout request and returns the response.
     *
     * @param statusCode      The expected status code of the response.
     * @param accessTokenPath Path to the accessToken that is uses in header.
     */
    @Step("User logs out with the provided access token")
    public Response logout(int statusCode, String accessTokenPath) {

        // Send the logout request to the specified endpoint with headers
        String accessToken = requestBodyLoader(accessTokenPath);

        // Send request to logout endpoint
        Response response = given(spec)
                .when().header("Authorization", "Bearer " + accessToken)
                .header(language, en)
                .post(LOGOUT_ENDPOINT);

        // Validate the status code of the response
        response.then().statusCode(statusCode);
        // Retrieve the content type of the response
        String contentType = response.getContentType();

        // Log the response details
        logger.info("Response received: {}", response.asString());
        logger.info("Status Code: {}", response.getStatusCode());

        return response;
    }
}