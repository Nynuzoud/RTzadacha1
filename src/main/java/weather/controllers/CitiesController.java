package weather.controllers;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import weather.DAO.Cities.CitiesDAO;
import weather.models.Cities;

import java.util.List;

/**
 * Created by Sergey on 21.07.2016. This is a test project.
 */
@RestController
public class CitiesController {
    private ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    private CitiesDAO citiesDAO = (CitiesDAO) context.getBean("citiesDAO");

    @RequestMapping(value = "/cities/get_all_cities", method = RequestMethod.GET)
    public List<Cities> getAllCities() {
        return citiesDAO.getAllCities();
    }

    @RequestMapping(value = "/cities/insert_city", method = RequestMethod.POST)
    public void insertCity(@RequestParam(value = "cityName") String cityName) {
        citiesDAO.insertCity(cityName);
    }

    @RequestMapping(value = "/cities/delete_city_by_name", method = RequestMethod.DELETE)
    public void deleteCityByName(@RequestParam(value = "cityName") String cityName) {
        citiesDAO.deleteCity(cityName);
    }

    @RequestMapping(value = "/cities/delete_city_by_id", method = RequestMethod.DELETE)
    public void deleteCityById(@RequestParam(value = "cityId") int cityId) {
        citiesDAO.deleteCity(cityId);
    }
}
