package weather.DAO.WeatherTypes;

import weather.models.WeatherTypes;

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
public class JDBCWeatherTypesDAO implements WeatherTypesDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<WeatherTypes> insertNewWeatherAndGetListOfWeather(String weatherTypeName) {
        List<WeatherTypes> list = new ArrayList<>();

        String sqlInsert = "INSERT INTO test.weather_types (weather_types.weather_name) VALUES (?);";
        String sqlSelect = "SELECT * FROM test.weather_types;";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();

            PreparedStatement preparedStatementInsert = connection.prepareStatement(sqlInsert);
            preparedStatementInsert.setString(1, weatherTypeName);
            preparedStatementInsert.executeUpdate();
            preparedStatementInsert.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            if (connection == null) {
                connection = dataSource.getConnection();
            }

            PreparedStatement preparedStatementSelect = connection.prepareStatement(sqlSelect);
            ResultSet resultSet = preparedStatementSelect.executeQuery();

            while (resultSet.next()) {
                WeatherTypes weatherTypes = new WeatherTypes();
                weatherTypes.setId(resultSet.getInt("id"));
                weatherTypes.setWeatherName(resultSet.getString("weather_name"));
                list.add(weatherTypes);
            }
            preparedStatementSelect.close();
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
}
