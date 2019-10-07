package za.ac.cput.controller.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ResponseObject;
import za.ac.cput.domain.author.Author;
import za.ac.cput.domain.author.AuthorAddress;
import za.ac.cput.domain.author.AuthorBook;
import za.ac.cput.domain.author.AuthorDemography;
import za.ac.cput.domain.books.Book;
import za.ac.cput.domain.demography.Gender;
import za.ac.cput.domain.demography.Race;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.request.NewAuthor;
import za.ac.cput.factory.ResponseObjectFactory;
import za.ac.cput.factory.author.AuthorAddressFactory;
import za.ac.cput.factory.author.AuthorBookFactory;
import za.ac.cput.factory.author.AuthorDemographyFactory;
import za.ac.cput.factory.author.AuthorFactory;
import za.ac.cput.service.author.impl.AuthorAddressServiceImpl;
import za.ac.cput.service.author.impl.AuthorBookServiceImpl;
import za.ac.cput.service.author.impl.AuthorDemographyServiceImpl;
import za.ac.cput.service.author.impl.AuthorServiceImpl;
import za.ac.cput.service.books.impl.BookServiceImpl;
import za.ac.cput.service.demography.impl.GenderServiceImpl;
import za.ac.cput.service.demography.impl.RaceServiceImpl;
import za.ac.cput.service.location.impl.AddressServiceImpl;

import java.util.*;

@RestController
@RequestMapping("/domain/author")
public class AuthorController {
    @Autowired
    AuthorServiceImpl authorService;

    @RequestMapping(value = "/create/{email}/{firstName}/{lastName}/{numberOfBooks}",method = RequestMethod.POST)
    @ResponseBody
    public Author create(@PathVariable String email,@PathVariable String firstName,@PathVariable String lastName,@PathVariable Integer numberOfBooks){
        Author author = AuthorFactory.createAuthor(email,firstName,lastName,numberOfBooks);
        return authorService.create(author);
    }
    @RequestMapping(value = "/read/{email}",method = RequestMethod.GET)
    //@ResponseBody
    public Author read(@PathVariable String email){
        return this.authorService.read(email);
    }
    @PutMapping(value = "/update")
    @ResponseBody
    public Author update(@RequestBody Author author){
        return this.authorService.update(author);
    }
    @DeleteMapping(value = "/delete{email}")
    public void delete(@PathVariable String email){
        this.authorService.delete(email);
    }
    @GetMapping(value = "/getall")
    @ResponseBody
    public Set<Author> getAll(){
        return this.authorService.getAll();
    }

}
