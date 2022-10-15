package Lesson7.db;

import Lesson7.ApplicationGlobalState;
import Lesson7.City;
import Lesson7.Forecasts;

import java.io.IOException;
import java.sql.*;
import java.util.List;

public class DatabaseRepositorySQLiteImpl implements DatabaseRepository {

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    String filename = null;
    String createTableQuery = "CREATE TABLE IF NOT EXISTS weather (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            " city TEXT NOT NULL," +
            " date_time TEXT NOT NULL," +
            " weather_condition TEXT NOT NULL," +
            " temperature INTEGER NOT NULL" +
            ")";
    String insertWeatherQuery = "INSERT INTO weather (city, date_time, weather_condition, temperature) VALUES (?,?,?,?)";

    public DatabaseRepositorySQLiteImpl() {
        filename = ApplicationGlobalState.getInstance().getDbFileName();
    }

    private Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
        return connection;
    }

    private void createTableIfNotExists() {
        try (Connection connection = getConnection()) {
            connection.createStatement().execute(createTableQuery);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean saveWeatherData(List<City> city, List<Forecasts> forecasts) throws SQLException {
        createTableIfNotExists();
        for (Forecasts el : forecasts) {
            try (Connection connection = getConnection();
                 PreparedStatement saveWeather = connection.prepareStatement(insertWeatherQuery)) {
                saveWeather.setString(1, city.get(0).getCityName());
                saveWeather.setString(2, el.getDate());
                saveWeather.setString(3, el.getParts().getDay().getCondition());
                saveWeather.setInt(4, el.getParts().getDay().getTemp());
                saveWeather.execute();
            } catch (SQLException throwables) {
                throwables.printStackTrace();

            }
        }
        return true;
    }

    @Override
    public void getAllSavedData() throws IOException {
        try (Connection connection = DriverManager.getConnection("jdbc:sqlite:" + filename);
             Statement statement = connection.createStatement()) {
            System.out.println("Информация об истории запросов:");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM weather");
            // В данном случае result set выгружает всю результирующую выборку
            while (resultSet.next()) {
                System.out.println(
                        resultSet.getString(1) + " - " +
                                resultSet.getString(2) + " - " +
                                resultSet.getString(3) + " - " +
                                resultSet.getString(4) + " - "


                );
            }
            System.out.println("");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
