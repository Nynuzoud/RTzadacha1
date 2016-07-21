package weather.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import weather.DAO.Weather.WeatherDAO;
import weather.models.Weather;

import java.util.List;

/**
 * Created by Sergey on 21.07.2016. This is a test project.
 */
@RestController
public class WeatherController {

    private ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    private WeatherDAO weatherDAO = (WeatherDAO) context.getBean("weatherDAO");

    @RequestMapping(value = "/weather/get_all_weather", method = RequestMethod.GET)
    public List<Weather> getAllWeather() {
        return weatherDAO.getAllWeather();
    }

    @RequestMapping(value = "/weather/get_city_weather_by_id", method = RequestMethod.GET)
    public List<Weather> getCityWeatherById(@RequestParam(value = "id", defaultValue = "1") int id) {
        return weatherDAO.getCityWeather(id);
    }

    @RequestMapping(value = "/weather/get_city_weather_by_city_name", method = RequestMethod.GET)
    public List<Weather> getCityWeatherByCityName(@RequestParam(value = "cityName", defaultValue = "Екатеринбург") String cityName) {
        return weatherDAO.getCityWeather(cityName);
    }

    @RequestMapping(value = "/weather/get_weather_by_an_hour", method = RequestMethod.GET)
    public Weather getWeatherByAnHour(@RequestParam(value = "timestamp", defaultValue = "1468922400") long timestamp,
                                      @RequestParam(value = "cityId", defaultValue = "1") int cityId) {
        return weatherDAO.getWeatherForAnHour(timestamp, cityId);
    }

    @RequestMapping(value = "/weather/insert_weather_for_city", method = RequestMethod.POST)
    public void insertWeatherForCity(@RequestParam(value = "timestamp") long timestamp,
                                     @RequestParam(value = "cityId") int cityId,
                                     @RequestParam(value = "weatherId") int weatherId) {
        weatherDAO.insertWeatherForCity(timestamp, cityId, weatherId);
    }
}
