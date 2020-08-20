package steps;

import base.LoadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import pojo.Coord;
import pojo.Profile;
import utils.CommonUtils;

public class ProfileDefinitions {
    private String endpoint;
    private Profile profiles;
    private String jsonString;
    private Response response;

    @Given("Endpoint to Profiles")
    public void endpointToProfiles() {
        endpoint = LoadProperties.jsonserver.getProperty("json-server.baseUrl") +
                LoadProperties.jsonserver.getProperty("json-server.profile");
    }

    @When("I send a request with GET Method to all profiles")
    public void iSendARequestWithGETMethodToAllProfiles() {
        profiles = CommonUtils.GetAllProfiles(endpoint);
    }

    @Then("I should get all profiles")
    public void iShouldGetAllProfiles() {
            Assert.assertNotNull(profiles);
    }
    @When("I send a request with GET Method to one profile with {string}")
    public void iSendARequestWithGETMethodToOneProfileWith(String postId) {
        profiles = CommonUtils.GetAllProfiles(endpoint + LoadProperties.jsonserver.getProperty("json-server.id")+ postId);
    }
    @When("I send a request with POST Method with given {string} and {string}")
    public void iSendARequestWithPOSTMethodWithGivenAnd(String name, String postId) {
        Profile profile = new Profile(postId, name);
        jsonString = CommonUtils.toJsonString(profile);
        response = CommonUtils.postJsonPayload(jsonString, endpoint);
    }

    @Then("I should have profile with {string} and {string} created")
    public void iShouldHaveProfileWithAndCreated(String name, String postId) {
        Assert.assertEquals(201, response.getStatusCode());
    }

    @Then("I should get one profile with {string} and {string}")
    public void iShouldGetOneProfileWithAnd(String postId, String name) {
        Assert.assertNotNull(profiles);
        Assert.assertEquals(name, profiles.name);
        Assert.assertEquals(postId, profiles.postId);
    }
}
