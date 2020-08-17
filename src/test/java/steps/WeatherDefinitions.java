package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import base.LoadProperties;
import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import pojo.Root;
import utils.CommonUtils;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class WeatherDefinitions {
    private  String Url;
    private Response response;
    Root root;
    @When("I call API with city name {string}")
    public void iCallAPIWithCityName(String CityName) {
        Url = Url + CityName + LoadProperties.weather.getProperty("weather.appid");
        System.out.println("Calling for  " + Url);
        response = given().when().get(Url);
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        Gson gson = new Gson();
        root = gson.fromJson(bodyAsString, Root.class);
        CommonUtils.PrintAllInfo(root);
    }

    @Then("I should get weather info for {string}")
    public void iShouldGetWeatherInfoFor(String CityName) {
        CommonUtils.Assertions(root);
    }

    @Given("I have Open Weather Map Url")
    public void iHaveOpenWeatherMapUrl() {
        Url = LoadProperties.weather.getProperty("weather.baseUrl");
        System.out.println("Base Url is " + Url);
    }
}
