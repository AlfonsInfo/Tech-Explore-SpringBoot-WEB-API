package group.learn.graphql;

import group.learn.graphql.data.Author;
import group.learn.graphql.data.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BookController {

    @QueryMapping
    public Book bookById(@Argument String id){
        return Book.getById(id);
    }

    @QueryMapping
    public List<Book> getAll(){
        return Book.BOOKS;
    }

    @SchemaMapping
    public Author author(Book book){
        return Author.getById(book.authorId());
    }
}
