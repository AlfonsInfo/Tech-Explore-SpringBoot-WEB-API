package restfulAPI.restful.learn._2gson;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.FieldNamingStrategy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Locale;


import java.lang.reflect.Field;

//Serialisasi
public class ProduceJsonGson {

    public static void gsonDefault()
    {
        Gson gson = new Gson();
        restfulAPI.restful.learn._0data.Person person = new restfulAPI.restful.learn._0data.Person("John", 30);
        String json = gson.toJson(person);

        System.out.println("JSON: " + json);

    }

    public static Gson gsonConfig()
    {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setFieldNamingStrategy(new SnakeCaseFieldNamingStrategy())
                .create();
        return gson;
        //Expression Expected .setFieldNamingStrategy(SnakeCaseFieldNamingStrategy)
    }
    public static void main(String[] args) {
        restfulAPI.restful.learn._0data.Person person = new restfulAPI.restful.learn._0data.Person("John", 30);
        System.out.println(gsonConfig().toJson(person));
    }


}


class SnakeCaseFieldNamingStrategy implements FieldNamingStrategy {
    @Override
    public String translateName(Field field) {
        return convertToSnakeCase(field.getName());
    }

    private String convertToSnakeCase(String input) {
        return input.replaceAll("([a-z])([A-Z])", "$1_$2").toLowerCase(Locale.ROOT);
    }
}
