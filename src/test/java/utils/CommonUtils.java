package utils;

import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import pojo.Profile;
import pojo.Root;
import pojo.Weather;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import static io.restassured.RestAssured.given;

public class CommonUtils {
    public static void PrintAllInfo(Root root) {
        System.out.println(root.coord.lat);
        System.out.println(root.coord.lon);
        for (Weather weather : root.weather
        ) {
            System.out.println(weather.description);
            System.out.println(weather.icon);
            System.out.println(weather.id);
            System.out.println(weather.main);

        }
        System.out.println(root.main.temp);
        System.out.println(root.main.temp_max);
        System.out.println(root.main.temp_min);
    }

    public static void Assertions(Root root, String city) {
        Assert.assertNotNull("Weather info for " + city + "can not be retrieved.", root);
    }

    public static Root GetWeatherInfo(String Url, String city) {
        System.out.println("Calling " + Url);
        System.out.println("Getting weather info for " + city);
        Response response = given().when().get(Url);
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        Gson gson = new Gson();
        return gson.fromJson(bodyAsString, Root.class);
    }

    public static Profile GetAllProfiles(String endpoint) {
        System.out.println("Calling " + endpoint);
        System.out.println("Getting profiles...");
        Response response = given().when().get(endpoint);
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        System.out.println(bodyAsString);
        Gson gson = new Gson();
        Profile profiles = gson.fromJson(bodyAsString, Profile.class);
        return profiles;
    }

    public static Response postJsonPayload(String payload, String endpoint) {
        return
                given()
                        .contentType(ContentType.JSON)
                        .body(payload)
                        .post(endpoint)
                        .then()
                        .statusCode(201)
                        .extract()
                        .response();
    }

    public static String toJsonString(Object o) {
        Gson gson = new Gson();
        return gson.toJson(o);
    }
}
