package steps;

import base.LoadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import pojo.Root;
import utils.CommonUtils;

public class WeatherDefinitions {
    private  String Url;
    private Response response;
    private Root root;
    @When("I call API with city name {string}")
    public void iCallAPIWithCityName(String CityName) {
        Url = Url + CityName + LoadProperties.weather.getProperty("weather.appid");
        root = CommonUtils.CallAndGetObj(Url, CityName);
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
