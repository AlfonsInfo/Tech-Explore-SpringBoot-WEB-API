package restfulAPI.restful.learn._2gson;


import com.google.gson.Gson;


import restfulAPI.restful.learn.Constant;
import restfulAPI.restful.learn._0data.Film;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//Deserialisasi
public class ConsumeApiGson {
    public static void main(String[] args) throws Exception{
        // Membuat koneksi ke API
        URL url = new URL(Constant.URL_EXAMPLE);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Membaca respons JSON
        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        // Deserialisasi JSON dengan Gson
        Gson gson = new Gson();
        Film data = gson.fromJson(response.toString(), Film.class);

        // Menggunakan data yang dihasilkan
        System.out.println("Data from API: " + data);
    }
}

