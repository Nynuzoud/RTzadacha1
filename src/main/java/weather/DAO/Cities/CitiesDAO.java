package weather.DAO.Cities;

import weather.models.Cities;

import java.util.List;

/**
 * Created by Sergey on 20.07.2016. This is a test project.
 */
public interface CitiesDAO {
    List<Cities> getAllCities();

    void insertCity(String cityName);

    void deleteCity(String cityName);

    void deleteCity(int id);
}
