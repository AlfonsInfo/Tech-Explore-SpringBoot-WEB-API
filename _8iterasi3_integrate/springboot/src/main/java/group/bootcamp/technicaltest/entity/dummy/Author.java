package group.bootcamp.technicaltest.entity.dummy;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public record Author(String id, String firstName, String lastName){
    private static List<Author> AUTHORS = Arrays.asList(
            new Author("author-1","Alfons","Setiawan"),
            new Author("author-2","Ucup","Surucup"),
            new Author("author-3","Udin","Saprudin")
    );
    public static Author getById(String id){
        return AUTHORS.stream()
                .filter(author -> Objects.equals(author.id(), id))
                .findFirst()
                .orElse(null);
    }

}
