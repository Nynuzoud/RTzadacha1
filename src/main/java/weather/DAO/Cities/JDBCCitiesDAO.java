package weather.DAO.Cities;

import weather.models.Cities;

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
public class JDBCCitiesDAO implements CitiesDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Cities> getAllCities() {
        List<Cities> list = new ArrayList<>();

        String sql = "SELECT * FROM test.cities;";

        Connection connection = null;

        try {
            connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Cities cities = new Cities();
                cities.setId(resultSet.getInt("id"));
                cities.setCityName(resultSet.getString("city_name"));
                list.add(cities);
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
    public void insertCity(String cityName) {
        String sql = "INSERT INTO test.cities (cities.city_name) VALUES (?);";

        Connection connection = null;
        try {
            connection = dataSource.getConnection();

            PreparedStatement preparedStatementInsert = connection.prepareStatement(sql);
            preparedStatementInsert.setString(1, cityName);
            preparedStatementInsert.executeUpdate();
            preparedStatementInsert.close();

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

    @Override
    public void deleteCity(String cityName) {
        String sql = "DELETE FROM test.cities WHERE city_name = ? ;";

        Connection connection = null;
        try {
            connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cityName);
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

    @Override
    public void deleteCity(int id) {
        String sql = "DELETE FROM test.cities WHERE id = ? ;";

        Connection connection = null;
        try {
            connection = dataSource.getConnection();

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
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
