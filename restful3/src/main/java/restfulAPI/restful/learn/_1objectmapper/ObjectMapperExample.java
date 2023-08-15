package restfulAPI.restful.learn._1objectmapper;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import restfulAPI.restful.learn._0data.Person;

public class ObjectMapperExample {
    public static ObjectMapper objectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        return mapper;
    }
    public static void main(String[] args) throws Exception {
        Person person =new Person("Alfons",21);
        String json = objectMapper().writeValueAsString(person);;
        System.out.println("JSON : " + json);
    }

}


