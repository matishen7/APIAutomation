package utils;

import org.junit.Assert;
import pojo.Root;
import pojo.Weather;

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
    public static void Assertions(Root root){
        Assert.assertNotNull(root);
    }
}
