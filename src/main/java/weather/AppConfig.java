package weather;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import weather.DAO.Cities.CitiesDAO;
import weather.DAO.Cities.JDBCCitiesDAO;
import weather.DAO.Weather.JDBCWeatherDAO;
import weather.DAO.Weather.WeatherDAO;
import weather.DAO.WeatherTypes.JDBCWeatherTypesDAO;
import weather.DAO.WeatherTypes.WeatherTypesDAO;

/**
 * Created by Sergey on 21.07.2016. This is a test project.
 */

@Configuration
public class AppConfig {
    @Bean
    public WeatherTypesDAO getWeatherTypes() {
        return new JDBCWeatherTypesDAO();
    }

    @Bean
    public WeatherDAO getWeather() {
        return new JDBCWeatherDAO();
    }

    @Bean
    public CitiesDAO getCities() {
        return new JDBCCitiesDAO();
    }
}
