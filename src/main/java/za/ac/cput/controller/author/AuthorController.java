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

@RestController
@RequestMapping("/domain/author")
public class AuthorController {
    @Autowired
    AuthorServiceImpl authorService;
    @Autowired
    AuthorDemographyServiceImpl authorDemographyService;
    @Autowired
    AuthorAddressServiceImpl authorAddressService;
    @Autowired
    AuthorBookServiceImpl authorBookService;
    @Autowired
    GenderServiceImpl genderService;
    @Autowired
    RaceServiceImpl raceService;
    @Autowired
    AddressServiceImpl addressService;
    @Autowired
    BookServiceImpl bookService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }


    @GetMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createEmployee(@RequestBody NewAuthor author){
        System.out.println(author);
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(),"Employee create!");
        if (author.getFirstName() == null || author.getLastName() == null){
            responseObject.setResponse(HttpStatus.PRECONDITION_FAILED.toString());
            responseObject.setResponseDescription("Please provide first and/or last name!");
        }else {
            Gender gender = getGender(author);
            Race race = getRace(author);
            Address address = getAddress(author);
            Book book = getBook(author);
            if (gender == null || race == null || address == null || book == null){
                responseObject.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
                String message = gender == null ? "Gender not found|" : "";
                message += race == null ? "Race not found|" : "";
                message += address == null ? "Address not found|": "";
                message += book == null ? "Book not found": "";
                responseObject.setResponseDescription(message);
            }else {
                Author saveAuth = saveAuthor(author);
                AuthorDemography saveAuthorDem = saveAuthorDemography(saveAuth,race,gender);
                AuthorAddress saveAuthAddr = saveAuthorAddress(saveAuth,address);
                AuthorBook saveAuthBook = saveAuthorBook(saveAuth,book);
                responseObject.setResponse(saveAuth);
            }
        }
        return ResponseEntity.ok(responseObject);
    }
    private AuthorDemography saveAuthorDemography(Author saveAuthor, Race saveRace, Gender saveGender){
        AuthorDemography authorDemography = AuthorDemographyFactory.createAuthorDemography(saveAuthor.getAuthorId(),saveRace.getRaceId(),saveGender.getGenderId());
        return authorDemographyService.create(authorDemography);
    }
    private Author saveAuthor(NewAuthor author){
        Author writer = AuthorFactory.createAuthor(author.getFirstName(),author.getLastName(),author.getNumOfBooks());
        return authorService.create(writer);
    }
    private AuthorAddress saveAuthorAddress(Author author,Address address){
        AuthorAddress authorAddress = AuthorAddressFactory.createAuthorAddress(author.getAuthorId(),address.getAddressId());
        return authorAddressService.create(authorAddress);
    }
    private AuthorBook saveAuthorBook(Author newAuthor,Book book){
        AuthorBook authorBook = AuthorBookFactory.createAuthorBook(newAuthor.getAuthorId(),book.getIsbn());
        return authorBookService.create(authorBook);
    }
    private Gender getGender(NewAuthor author){
        return genderService.getByDesc(author.getGender());
    }
    private Race getRace(NewAuthor author){
        return raceService.getByDesc(author.getRace());
    }
    private Address getAddress(NewAuthor author){
        return addressService.getByTown(author.getAddress());
    }
    private Book getBook(NewAuthor author){
        return bookService.getByTitle(author.getBook());
    }

}
