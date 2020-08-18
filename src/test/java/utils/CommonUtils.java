package utils;

import io.cucumber.messages.internal.com.google.gson.Gson;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.junit.Assert;
import pojo.Root;
import pojo.Weather;

import static io.restassured.RestAssured.given;

public class CommonUtils {
    public static void PrintAllInfo(Root root){
        System.out.println(root.coord.lat);
        System.out.println(root.coord.lon);
        for (Weather weather:root.weather
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
    public static void Assertions(Root root, String city){
        Assert.assertNotNull("Weather info for "+ city + "can not be retrieved.", root);
    }
    public static Root CallAndGetObj(String Url, String city){
        System.out.println("Calling " + Url);
        System.out.println("Getting weather info for " + city);
        Response response = given().when().get(Url);
        ResponseBody body = response.getBody();
        String bodyAsString = body.asString();
        Gson gson = new Gson();
        return gson.fromJson(bodyAsString, Root.class);
    }
}
