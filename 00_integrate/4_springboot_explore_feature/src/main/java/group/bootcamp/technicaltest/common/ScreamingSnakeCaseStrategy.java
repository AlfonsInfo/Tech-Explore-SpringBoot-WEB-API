package group.bootcamp.technicaltest.common;


import com.fasterxml.jackson.databind.PropertyNamingStrategy;

public class ScreamingSnakeCaseStrategy extends PropertyNamingStrategy.SnakeCaseStrategy {

    @Override
    public String translate(String input) {
        String lowerSnakeCase = super.translate(input);
        return lowerSnakeCase.toUpperCase();
    }


}
