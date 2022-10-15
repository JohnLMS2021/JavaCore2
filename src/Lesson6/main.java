package Lesson6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;

import java.io.IOException;

public class main {
    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient();
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.weather.yandex.ru")
                .addPathSegment("v2")
                .addPathSegment("forecast")
                .addQueryParameter("lat", "59.9311")
                .addQueryParameter("lon", "30.3609")
                .addQueryParameter("lang","ru_RU")
                .addQueryParameter("limit","5")
                .addQueryParameter("hours","false")
                .addQueryParameter("extra","true")
                .build();

        Request request = new Request.Builder()
                .url(url)
                .addHeader("X-Yandex-API-Key", "f0d46c92-ac5d-408a-9369-25018d670770")
                .build();
        System.out.println(request.toString());

        String response = client.newCall(request).execute().body().string();
        System.out.println("Ответ: " + response);


    }
}
