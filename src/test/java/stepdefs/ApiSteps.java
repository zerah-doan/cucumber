package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.when;
import static org.hamcrest.core.Is.is;


public class ApiSteps {
    private String SITE;

    private Response response;
    private RequestSpecification request;

    @Given("^I test (.*) api$")
    public void i_test_api(String api) throws Throwable {
        SITE = api;
    }

    @When("^I request (.*) end point$")
    public void i_request_end_point(String endpoint) throws Throwable {
        response = when().get(SITE + endpoint);
    }

    @Then("^The response structure should be valid as (.*)$")
    public void the_response_structure_should_be_valid_as(String schemaPath) throws Throwable {
        System.out.print(schemaPath);
    }

    @Then("^The response size should be (.*)$")
    public void the_response_size_should_be(int size) throws Throwable {
        response.then().assertThat().body("size()", is(size));
    }

}
