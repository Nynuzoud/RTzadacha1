package weather.DAO.Weather;

import weather.Service;
import weather.models.Weather;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 20.07.2016. This is a test project.
 */
public class JDBCWeatherDAO implements WeatherDAO {
    private DataSource dataSource;
    private Service service = new Service();

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Weather> getAllWeather() {
        List<Weather> list = new ArrayList<>();
        String sql = "SELECT weather.id, weather.time, cities.city_name, weather_types.weather_name " +
                "FROM test.weather, test.cities, test.weather_types " +
                "WHERE weather.id_city = cities.id AND weather.id_weather = weather_types.id;";

        Connection connection = null;
        try {
            connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(setDataToWeatherObject(new Weather(), resultSet));
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public List<Weather> getCityWeather(String city) {
        List<Weather> list = new ArrayList<>();
        String sql = "SELECT weather.id, weather.time, cities.city_name, weather_types.weather_name " +
                "FROM test.weather, test.cities, test.weather_types " +
                "WHERE weather.id_city = cities.id " +
                "AND weather.id_weather = weather_types.id " +
                "AND cities.city_name = ?;";

        Connection connection = null;
        try {
            connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, city);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(setDataToWeatherObject(new Weather(), resultSet));
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    @Override
    public List<Weather> getCityWeather(int id) {
        List<Weather> list = new ArrayList<>();
        String sql = "SELECT weather.id, weather.time, cities.city_name, weather_types.weather_name " +
                "FROM test.weather, test.cities, test.weather_types " +
                "WHERE weather.id_city = cities.id " +
                "AND weather.id_weather = weather_types.id " +
                "AND cities.id = ? " +
                "ORDER BY weather.id ASC;";

        Connection connection = null;
        try {
            connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                list.add(setDataToWeatherObject(new Weather(), resultSet));
            }
            preparedStatement.close();
            resultSet.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }

    private Weather setDataToWeatherObject(Weather weather, ResultSet resultSet) throws SQLException {
        weather.setId(resultSet.getLong("id"));
        weather.setTime(service.timestampToDateString(resultSet.getLong("time")));
        weather.setCity(resultSet.getString("city_name"));
        weather.setWheather(resultSet.getString("weather_name"));
        return weather;
    }

    @Override
    public void insertWeatherForCity(long timestamp, int cityId, int weatherId) {
        String sql = "INSERT INTO `test`.`weather` (`time`, `id_city`, `id_weather`) VALUES (?,?,?);";

        Connection connection = null;
        try {
            connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, timestamp);
            preparedStatement.setInt(2, cityId);
            preparedStatement.setInt(3, weatherId);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
