package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.CatBreed;
import org.hamcrest.Matchers;
import org.junit.Assert;
import config.Configuration;

import java.util.List;
import java.util.logging.Logger;

public class CatBreedsSteps {
    private Response response;
    private static final Logger logger = Logger.getLogger(CatBreedsSteps.class.getName());
    private String baseUrl;

    public CatBreedsSteps() {
        this.baseUrl = Configuration.getBaseUrl(); // Initialize base URL
    }

    private <T> T getJsonValue(String path, Class<T> type) {
        return response.getBody().jsonPath().getObject(path, type);
    }

    private <T> List<T> getJsonList(String path, Class<T> type) {
        return response.getBody().jsonPath().getList(path, type);
    }

    private void assertStringNotEmpty(String value, String message) {
        Assert.assertThat(message, value, Matchers.not(Matchers.isEmptyOrNullString()));
    }

    @Given("I send a {string} request to {string}")
    public void sendRequest(String method, String endpoint) {
        RequestSpecification request = RestAssured.given();
        response = request.request(Method.valueOf(method), baseUrl + endpoint);
        logger.info("Request: " + method + " " + baseUrl + endpoint);
        logger.info("Response status code: " + response.getStatusCode());
        logger.info("Response body: " + getJsonValue("body", String.class));
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response body should contain a list of cat breeds")
    public void verifyResponseBody() {
        List<CatBreed> breeds = response.getBody().jsonPath().getList("data");
        Assert.assertNotNull("Response body should contain 'data', but it was null", breeds);
        Assert.assertFalse("Expected at least one breed, but list was empty", breeds.isEmpty());
    }

    @Then("the first breed in the list should have all fields populated")
    public void verifyBreedFields() {
        List<CatBreed> breeds = getJsonList("data", CatBreed.class);
        CatBreed firstBreed = breeds.get(0);

        assertStringNotEmpty(firstBreed.breed, "Breed name is empty");
        assertStringNotEmpty(firstBreed.country, "Country is empty");
        assertStringNotEmpty(firstBreed.origin, "Origin is empty");
        assertStringNotEmpty(firstBreed.coat, "Coat is empty");
        assertStringNotEmpty(firstBreed.pattern, "Pattern is empty");
    }

    @Then("the response body should contain a maximum of {int} cat breeds")
    public void verifyMaxCatBreeds(int limit) {
        List<CatBreed> breeds = getJsonList("data", CatBreed.class);
        Assert.assertTrue(breeds.size() <= limit);
    }

    @Then("the response body should contain an error message")
    public void verifyErrorMessage() {
        String errorMessage = getJsonValue("error", String.class);
        logger.info("Received error message: " + errorMessage);
        Assert.assertNotNull("Error message should not be null", errorMessage);
    }
}
