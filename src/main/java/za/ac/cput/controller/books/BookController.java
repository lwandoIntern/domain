package za.ac.cput.controller.books;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ResponseObject;
import za.ac.cput.domain.author.Author;
import za.ac.cput.domain.author.AuthorBook;
import za.ac.cput.domain.books.Book;
import za.ac.cput.domain.books.BookCategory;
import za.ac.cput.domain.books.BookPublisher;
import za.ac.cput.domain.books.Category;
import za.ac.cput.domain.publisher.Publisher;
import za.ac.cput.domain.request.NewBook;
import za.ac.cput.factory.ResponseObjectFactory;
import za.ac.cput.factory.author.AuthorBookFactory;
import za.ac.cput.factory.books.BookCategoryFactory;
import za.ac.cput.factory.books.BookFactory;
import za.ac.cput.factory.books.BookPublisherFactory;
import za.ac.cput.service.author.impl.AuthorBookServiceImpl;
import za.ac.cput.service.author.impl.AuthorServiceImpl;
import za.ac.cput.service.books.impl.BookCategoryServiceImpl;
import za.ac.cput.service.books.impl.BookPublisherServiceImpl;
import za.ac.cput.service.books.impl.BookServiceImpl;
import za.ac.cput.service.books.impl.CategoryServiceImpl;
import za.ac.cput.service.publisher.impl.PublisherServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/domain/books")
public class BookController {
    @Autowired
    BookServiceImpl bookService;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public @ResponseBody Book create(@RequestBody Book book){
        return this.bookService.create(book);
    }

    @RequestMapping(value = "/read",method = RequestMethod.GET)
    public @ResponseBody Book read(@PathVariable String isbn){
        return this.bookService.read(isbn);
    }

    @RequestMapping(value = "/update",method = RequestMethod.PUT)
    public Book update(@RequestBody Book book){
        return this.bookService.update(book);
    }
    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public void delete(@PathVariable String s){
        this.bookService.delete(s);
    }

    @RequestMapping(value = "/getall",method = RequestMethod.GET)
    public Set<Book> getAll(){
        return this.bookService.getAll();
    }
}
