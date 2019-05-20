package za.ac.cput.domain.controller.book;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.services.author.impl.AuthorServiceImpl;
import za.ac.cput.domain.services.book.impl.BookServiceImpl;

@RestController
@RequestMapping("/domain/controller/book")
public class BookController {
    @Autowired
    private BookServiceImpl service;

    @GetMapping("/create/")
    @ResponseBody
    public Book create(Book book){
        return service.create(book);
    }

    @GetMapping("/read/")
    @ResponseBody
    public Book read(Book book){
        return service.read(book);
    }

    @GetMapping("/update/")
    @ResponseBody
    public Book update(Book book){
        return service.update(book);
    }

    @GetMapping("/delete/")
    @ResponseBody
    public void delete(String id){
        service.delete(id);
    }
}
