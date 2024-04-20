package group.bootcamp.technicaltest.controller;

import group.bootcamp.technicaltest.entity.dummy.Author;
import group.bootcamp.technicaltest.entity.dummy.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GraphQLController {

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
