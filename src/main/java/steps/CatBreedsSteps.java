package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;
import config.Configuration;

import java.util.List;

public class CatBreedsSteps {
    private Response response;
    private String baseUrl;

    public CatBreedsSteps() {
        this.baseUrl = Configuration.getBaseUrl(); // Initialize base URL
    }

    @Given("I send a GET request to {string}")
    public void sendGetRequest(String endpoint) {
        response = RestAssured.get(baseUrl + endpoint);
    }

    @Then("the response status code should be {int}")
    public void verifyStatusCode(int statusCode) {
        Assert.assertEquals(statusCode, response.getStatusCode());
    }

    @Then("the response body should contain a list of cat breeds")
    public void verifyResponseBody() {
        Assert.assertNotNull(response.getBody().jsonPath().getList("data"));
    }

    @Then("the response body should contain at least one breed with {string}, {string}, {string}, {string} and {string} fields")
    public void verifyBreedFields(String breed, String country, String origin, String coat, String pattern) {
        var jsonPath = response.getBody().jsonPath();
        var prefixPath = "data[0].";
        Assert.assertNotNull(jsonPath.getString(prefixPath + breed));
        Assert.assertNotNull(jsonPath.getString(prefixPath + country));
        Assert.assertNotNull(jsonPath.getString(prefixPath + origin));
        Assert.assertNotNull(jsonPath.getString(prefixPath + coat));
        Assert.assertNotNull(jsonPath.getString(prefixPath + pattern));
    }

    @Then("the response body should contain a maximum of {int} cat breeds")
    public void verifyMaxCatBreeds(int limit) {
        List<Object> breeds = response.getBody().jsonPath().getList("data");
        Assert.assertTrue(breeds.size() <= limit);
    }

    @Then("the response body should contain an error message")
    public void verifyErrorMessage() {
        System.out.println(response.getBody());
        Assert.assertNotNull(response.getBody().jsonPath().getString("error"));
    }
}
