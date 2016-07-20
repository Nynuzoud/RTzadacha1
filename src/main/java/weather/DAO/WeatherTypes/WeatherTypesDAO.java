package weather.DAO.WeatherTypes;

import java.util.List;

/**
 * Created by Sergey on 20.07.2016. This is a test project.
 */
public interface WeatherTypesDAO {
    List<String> insertNewWeatherAndGetListOfWeather(String weatherTypeName);
}
