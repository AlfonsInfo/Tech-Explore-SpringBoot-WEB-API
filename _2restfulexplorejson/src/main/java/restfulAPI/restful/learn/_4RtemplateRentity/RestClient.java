package restfulAPI.restful.learn._4RtemplateRentity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import restfulAPI.restful.learn._0data.Film;

import java.net.URL;
import java.util.Map;

import static restfulAPI.restful.learn.Constant.URL_EXAMPLE;

public class RestClient {

    //Working
    public static void caraObjectGson(){
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object>  responseEntityAsFilm = restTemplate.getForEntity(URL_EXAMPLE, Object.class);
        Object responseBody2 = responseEntityAsFilm.getBody();
        Gson gson = new Gson();
        Film film = gson.fromJson(gson.toJson(responseBody2),Film.class);

    }


    //Not Working : karena Object tidak memiliki " " hasil konversi
    public static void caraObjectMapper(){
        try{

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Object>  responseEntityAsFilm = restTemplate.getForEntity(URL_EXAMPLE, Object.class);
        Object responseBody2 =  responseEntityAsFilm.getBody();
        System.out.println(responseBody2);


        ResponseEntity<Object> responseEntity = restTemplate.getForEntity(URL_EXAMPLE, Object.class);
        Map<String, Object> responseData = (Map<String, Object>) responseEntity.getBody();
//            System.out.println(responseData.get("Year"));
//        ObjectMapper objectMapper = new ObjectMapper();
//        Film film = objectMapper.convertValue(responseBody2, Film.class);
//        System.out.println(film.getTitle() + film.getYear());
        }catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public static void caraMapping()
    {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Map> responseEntity = restTemplate.getForEntity(URL_EXAMPLE, Map.class);
        Map responseBody = responseEntity.getBody();
        System.out.println(responseBody.get("Title"));
        Film film =  new Film((String)responseBody.get("Title"), (String)responseBody.get("Year"));
    }



    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntityAsString    = restTemplate.getForEntity(URL_EXAMPLE,String.class);
        caraObjectMapper();
//        caraMapping();



        if (responseEntityAsString.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntityAsString.getBody();
            System.out.println("Response Body: " + responseBody);

        } else {
            System.out.println("Request failed with status code: " + responseEntityAsString.getStatusCodeValue());
        }
    }

}
