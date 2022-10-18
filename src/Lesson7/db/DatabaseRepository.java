package Lesson7.db;

import Lesson7.City;
import Lesson7.Forecasts;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DatabaseRepository {



    boolean saveWeatherData(List<City> city, List<Forecasts> forecasts) throws SQLException;

    void getAllSavedData() throws IOException;
}