package Lesson7;

import Lesson7.db.DatabaseRepositorySQLiteImpl;
import Lesson7.enums.Periods;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class YandexWeatherProvider implements WeatherProvider {

    private static final String BASE_HOST = "api.weather.yandex.ru";

    private static final String API_VERSION = "v2";
    private static final String API_KEY = ApplicationGlobalState.getInstance().getApiKey();


    private final OkHttpClient client = new OkHttpClient();
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void getWeather(Periods periods) throws IOException, SQLException {
        if (periods.equals(Periods.NOW)) {
            HttpUrl url = new HttpUrl.Builder()
                    .scheme("https")
                    .host(BASE_HOST)
                    .addPathSegment(API_VERSION)
                    .addPathSegment("forecast")
                    .addQueryParameter("lat", ApplicationGlobalState.getInstance().getSelectedLat())
                    .addQueryParameter("lon", ApplicationGlobalState.getInstance().getSelectedLon())
                    .addQueryParameter("lang", "ru_RU")
                    .addQueryParameter("limit", "1")
                    .addQueryParameter("hours", "false")
                    .addQueryParameter("extra", "false")
                    .build();

            Request request = new Request.Builder()
                    .addHeader("accept", "application/json")
                    .addHeader("X-Yandex-API-Key", API_KEY)
                    .url(url)
                    .build();

            String response = client.newCall(request).execute().body().string();
            System.out.println(response);

            JsonNode jsonCity = objectMapper.readTree(response).get("geo_object").get("locality");
            List<City> cityList = Arrays.asList(objectMapper.readValue(jsonCity.toString(), City.class));
            for (City city : cityList) {
                System.out.print("В городе " + city.getCityName() + " ");
            }

            JsonNode node = objectMapper.readTree(response).get("forecasts");
            List<Forecasts> myForecasts = Arrays.asList(objectMapper.readValue(node.toString(), Forecasts[].class));
            for (Forecasts el : myForecasts) {
                System.out.println("на дату: " + el.getDate() + " ожидаются следующие погодные условия: "
                        + el.getParts().getDay().getCondition() + ", температура: "
                        + el.getParts().getDay().getTemp() + ".");
            }
            DatabaseRepositorySQLiteImpl db = new DatabaseRepositorySQLiteImpl();
            db.saveWeatherData(cityList, myForecasts);

            } else if (periods.equals(Periods.FIVE_DAYS)) {
                HttpUrl url = new HttpUrl.Builder()
                        .scheme("https")
                        .host(BASE_HOST)
                        .addPathSegment(API_VERSION)
                        .addPathSegment("forecast")
                        .addQueryParameter("lat", ApplicationGlobalState.getInstance().getSelectedLat())
                        .addQueryParameter("lon", ApplicationGlobalState.getInstance().getSelectedLon())
                        .addQueryParameter("lang", "ru_RU")
                        .addQueryParameter("limit", "5")
                        .addQueryParameter("hours", "false")
                        .addQueryParameter("extra", "false")
                        .build();

                Request request = new Request.Builder()
                        .addHeader("accept", "application/json")
                        .addHeader("X-Yandex-API-Key", API_KEY)
                        .url(url)
                        .build();
                String response = client.newCall(request).execute().body().string();
                System.out.println(response);

            JsonNode jsonCity = objectMapper.readTree(response).get("geo_object").get("locality");
            List<City> cityList = Arrays.asList(objectMapper.readValue(jsonCity.toString(), City.class));
            for (City city : cityList) {
                System.out.println("В городе " + city.getCityName() + ":");
            }

            JsonNode node = objectMapper.readTree(response).get("forecasts");
            List<Forecasts> myForecasts = Arrays.asList(objectMapper.readValue(node.toString(), Forecasts[].class));
            for (Forecasts el : myForecasts) {
                System.out.println("На дату: " + el.getDate() + " ожидаются следующие погодные условия: "
                        + el.getParts().getDay().getCondition() + ", температура: "
                        + el.getParts().getDay().getTemp());
            }
            DatabaseRepositorySQLiteImpl db = new DatabaseRepositorySQLiteImpl();

            db.saveWeatherData(cityList, myForecasts);
            } else if (periods.equals(Periods.DATA_BASE)) {
            DatabaseRepositorySQLiteImpl db = new DatabaseRepositorySQLiteImpl();

            db.getAllSavedData();

        }
    }
}