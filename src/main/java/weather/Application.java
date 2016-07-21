package weather;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Sergey on 20.07.2016. This is a test project.
 */

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");

        /*WeatherDAO weatherDAO = (WeatherDAO) context.getBean("weatherDAO");

        weatherDAO.insertWeatherForCity(1468929690, 1, 3);

        List<Weather> weatherList = weatherDAO.getAllWeather();
        weatherList.forEach(item -> {
            System.out.println(item.getId());
            System.out.println(item.getTime());
            System.out.println(item.getCity());
            System.out.println(item.getWheather());
        });

        CitiesDAO citiesDAO = (CitiesDAO) context.getBean("citiesDAO");
        List<String> citiesList = citiesDAO.getAllCities();
        citiesList.forEach(System.out::println);

        WeatherTypesDAO weatherTypesDAO = (WeatherTypesDAO) context.getBean("weatherTypesDAO");
        List<String> weatherTypesList = weatherTypesDAO.insertNewWeatherAndGetListOfWeather("Ураган");
        weatherTypesList.forEach(System.out::println);

        List<Weather> weatherCityListByName = weatherDAO.getCityWeather("Екатеринбург");
        weatherCityListByName.forEach(item -> {
            System.out.println(item.getId());
            System.out.println(item.getTime());
            System.out.println(item.getCity());
            System.out.println(item.getWheather());
        });

        List<Weather> weatherCityListById = weatherDAO.getCityWeather(2);
        weatherCityListById.forEach(item -> {
            System.out.println(item.getId());
            System.out.println(item.getTime());
            System.out.println(item.getCity());
            System.out.println(item.getWheather());
        });*/

        SpringApplication.run(Application.class, args);
    }
}
