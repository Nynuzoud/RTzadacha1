package weather;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import weather.DAO.Cities.CitiesDAO;
import weather.DAO.Weather.WeatherDAO;
import weather.DAO.WeatherTypes.WeatherTypesDAO;
import weather.models.Cities;
import weather.models.Weather;
import weather.models.WeatherTypes;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;



/**
 * Created by Sergey on 21.07.2016. This is a test project.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class, loader = AnnotationConfigContextLoader.class)
public class JUnitSpringTests {

    private static final String LIST_IS_NOT_NULL_TEMPLATE = "List is not null";
    private static final String OBJECT_IS_NOT_NULL_TEMPLATE = "Object is not null";

    private ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
    private WeatherTypesDAO weatherTypesDAO = (WeatherTypesDAO) context.getBean("weatherTypesDAO");
    private WeatherDAO weatherDAO = (WeatherDAO) context.getBean("weatherDAO");
    private CitiesDAO citiesDAO = (CitiesDAO) context.getBean("citiesDAO");

    @Test
    public void testInsertNewWeatherAndGetListOfWeather() {
        List<WeatherTypes> list = weatherTypesDAO.insertNewWeatherAndGetListOfWeather("Уфа");
        assertNotNull(LIST_IS_NOT_NULL_TEMPLATE, list);
        assertThat(list.size(), is(not(0)));
    }

    @Test
    public void testGetAllWeather() {
        List<Weather> list = weatherDAO.getAllWeather();
        assertNotNull(LIST_IS_NOT_NULL_TEMPLATE, list);
        assertThat(list.size(), is(not(0)));
    }

    @Test
    public void testGetCityWeatherByName() {
        List<Weather> list = weatherDAO.getCityWeather("Екатеринбург");
        assertNotNull(LIST_IS_NOT_NULL_TEMPLATE, list);
        assertThat(list.size(), is(not(0)));
    }

    @Test
    public void testGetCityWeatherById() {
        List<Weather> list = weatherDAO.getCityWeather(2);
        assertNotNull(LIST_IS_NOT_NULL_TEMPLATE, list);
        assertThat(list.size(), is(not(0)));
    }

    @Test
    public void testGetWeatherForAnHour() {
        Weather weather = weatherDAO.getWeatherForAnHour(1468922380, 1);
        assertNotNull(OBJECT_IS_NOT_NULL_TEMPLATE, weather);
        assertNotNull(weather.getId());
        assertNotNull(weather.getTime());
        assertNotNull(weather.getCity());
        assertNotNull(weather.getWeather());
    }

    @Test
    public void testGetAllCities() {
        List<Cities> list = citiesDAO.getAllCities();
        assertNotNull(LIST_IS_NOT_NULL_TEMPLATE, list);
        assertThat(list.size(), is(not(0)));
    }

}