package weather.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import weather.DAO.WeatherTypes.WeatherTypesDAO;
import weather.models.WeatherTypes;

import java.util.List;

/**
 * Created by Sergey on 21.07.2016. This is a test project.
 */
@RestController
public class WeatherTypesController {

    private ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    private WeatherTypesDAO weatherTypesDAO = (WeatherTypesDAO) context.getBean("weatherTypesDAO");

    @RequestMapping(value = "/weather_types/insert_and_select", method = RequestMethod.POST)
    public List<WeatherTypes> insertAndSelect (@RequestParam(value = "weatherTypeName") String weatherTypeName) {
        return weatherTypesDAO.insertNewWeatherAndGetListOfWeather(weatherTypeName);
    }
}
