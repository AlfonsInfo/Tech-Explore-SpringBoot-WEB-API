package restfulAPI.restful.learn._3httpcomponents;

import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import restfulAPI.restful.learn.Constant;
import restfulAPI.restful.learn._0data.Film;


public class ConsumeApi {
    public static void main(String[] args) {
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){
            HttpGet httpGet = new HttpGet(Constant.URL_EXAMPLE);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
                String line = reader.readLine();
//                while ((line = reader.readLine()) != null) {
//                    System.out.println(line);
//                }

                //Combine with GSON
                Gson gson = new Gson();
                Film film = gson.fromJson(line, Film.class);
                System.out.println(film);
            }
        }catch (IOException e){
            System.out.println(e);
        }
    }
}

