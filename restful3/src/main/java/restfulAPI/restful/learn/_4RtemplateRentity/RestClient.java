package restfulAPI.restful.learn._4RtemplateRentity;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import restfulAPI.restful.learn._0data.Film;

import static restfulAPI.restful.learn.Constant.URL_EXAMPLE;

public class RestClient {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> responseEntityAsString    = restTemplate.getForEntity(URL_EXAMPLE,String.class);
        ResponseEntity<Film>  responseEntityAsFilm = restTemplate.getForEntity(URL_EXAMPLE, Film.class);
        if (responseEntityAsString.getStatusCode().is2xxSuccessful()) {
            String responseBody = responseEntityAsString.getBody();
            System.out.println("Response Body: " + responseBody);
        } else {
            System.out.println("Request failed with status code: " + responseEntityAsString.getStatusCodeValue());
        }
    }

}
