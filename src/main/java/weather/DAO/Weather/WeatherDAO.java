package weather.DAO.Weather;

import weather.models.Weather;

import java.util.List;

/**
 * Created by Sergey on 20.07.2016. This is a test project.
 */
public interface WeatherDAO {
    List<Weather> getAllWeather();

    List<Weather> getCityWeather(String city);

    List<Weather> getCityWeather(int id);

    Weather getWeatherForAnHour(long timestamp, int cityId);

    void insertWeatherForCity(long timestamp, int cityId, int weatherId);
}
