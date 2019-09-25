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

    private Set<NewAuthor> newAuthors = new HashSet<>();

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
    /**
     * CREATE METHOD
     * @param author
     * @return an Author object, accepts a NewAuthor object: which contains gender,address,race,book
     */
    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody NewAuthor author){
        System.out.println(author);
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(),
                "Employee create!");
        if (author.getAuthorEmail() == null || author.getFirstName() == null || author.getLastName() == null){
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
            this.newAuthors.add(author);
        }
        return ResponseEntity.ok(responseObject);
    }
    /**
     * READ METHOD
     * @param email
     * @return a Response entity: that is if successful a NewAuthor object(an Author object with gender, race, address and books written)
     *
     */
    @GetMapping(value = "/read")
    public ResponseEntity read(@PathVariable String email){
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(),"Author retrieved");
        if (findNewAuthor(email) == null || email ==null){
            responseObject.setResponse(HttpStatus.PRECONDITION_FAILED.toString());
            responseObject.setResponseDescription("Please provide an email!");
        }else {
            Author author = authorService.read(email);
            AuthorBook authorBook = authorBookService.read(email);
            AuthorDemography authorDemography = authorDemographyService.read(email);
            AuthorAddress authorAddress = authorAddressService.read(email);
            if (author == null || authorBook == null || authorDemography == null || authorAddress == null){
                responseObject.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
                String message = author == null ? "Author not found":"";
                message = authorAddress == null ? "Address not found":"";
                message = authorBook == null ? "Book not found":"";
                message = authorDemography == null ? "Race and Gender not found":"";
                responseObject.setResponseDescription(message);
            }else {
                Gender gender = genderService.read(authorDemography.getGenderId());
                Race race = raceService.read(authorDemography.getRaceId());
                Book book = bookService.read(authorBook.getIsbn());
                Address address = addressService.read(authorAddress.getAddressId());
                NewAuthor newAuthor = new NewAuthor(author.getAuthorEmail(),author.getFirstName(),author.getLastName(),
                        gender.getGenderDescription(),race.getRaceDescription(),address.getTown(),book.getTitle()
                        ,author.getNumOfBooksWritten());
                responseObject.setResponse(newAuthor);
            }

        }

        return ResponseEntity.ok(responseObject);
    }
    /**
     * UPDATE METHOD
     * @param newAuthor
     * @return an update Author
     */
    @PutMapping("/update")
    public ResponseEntity update(@RequestBody NewAuthor newAuthor){
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(),"updating author!");
        NewAuthor toDelete = findNewAuthor(newAuthor.getAuthorEmail());
        if (toDelete != null || authorService.read(newAuthor.getAuthorEmail()) != null){
            this.newAuthors.remove(toDelete);
            this.newAuthors.add(newAuthor);
            Author author = authorService.update(AuthorFactory.createAuthor(newAuthor.getAuthorEmail(),newAuthor.getFirstName(),newAuthor.getLastName(),newAuthor.getNumOfBooks()));
            responseObject.setResponse(author);
        }else {
            responseObject.setResponse(HttpStatus.PRECONDITION_FAILED.toString());
        }

        return ResponseEntity.ok(responseObject);
    }

    /**
     * DELETE METHOD
     * @param email
     */
    @DeleteMapping("/delete")
    public void delete(String email){
        NewAuthor newAuthor = findNewAuthor(email);
        this.newAuthors.remove(newAuthor);
        authorService.delete(email);
    }

    /**
     *
     * @return authors
     */
    @GetMapping("/getAll")
    public Set<NewAuthor> getAll(){
        return this.newAuthors;
    }
    /**
     *
     * @param saveAuthor
     * @param saveRace
     * @param saveGender
     * @return an AuthorDemography object
     */
    private AuthorDemography saveAuthorDemography(Author saveAuthor, Race saveRace, Gender saveGender){
        AuthorDemography authorDemography = AuthorDemographyFactory.createAuthorDemography(saveAuthor.getAuthorEmail(),saveRace.getRaceId(),saveGender.getGenderId());
        return authorDemographyService.create(authorDemography);
    }
    /**
     *
     * @param author
     * @return an Author object
     */
    private Author saveAuthor(NewAuthor author){
        Author writer = AuthorFactory.createAuthor(author.getAuthorEmail(),author.getFirstName(),author.getLastName(),author.getNumOfBooks());
        return authorService.create(writer);
    }
    /**
     *
     * @param author
     * @param address
     * @return an AuthorAddress object
     */
    private AuthorAddress saveAuthorAddress(Author author,Address address){
        AuthorAddress authorAddress = AuthorAddressFactory.createAuthorAddress(author.getAuthorEmail(),address.getAddressId());
        return authorAddressService.create(authorAddress);
    }
    /**
     *
     * @param newAuthor
     * @param book
     * @return an AuthorBook object
     */
    private AuthorBook saveAuthorBook(Author newAuthor,Book book){
        AuthorBook authorBook = AuthorBookFactory.createAuthorBook(newAuthor.getAuthorEmail(),book.getIsbn());
        return authorBookService.create(authorBook);
    }
    /**
     *
     * @param author
     * @return a gender object by description from the NewAuthor class
     */
    private Gender getGender(NewAuthor author){
        return genderService.getByDesc(author.getGender());
    }
    /**
     *
     * @param author
     * @return a race object by description from the NewAuthor class
     */
    private Race getRace(NewAuthor author){
        return raceService.getByDesc(author.getRace());
    }
    /**
     *
     * @param author
     * @return an address object by town from the NewAuthor class
     */
    private Address getAddress(NewAuthor author){
        return addressService.getByTown(author.getAddress());
    }
    /**
     *
     * @param author
     * @return a book object by book title from the NewAuthor class
     */
    private Book getBook(NewAuthor author){
        return bookService.getByTitle(author.getBook());
    }
    /**
     *
     * @param email
     * @return NewAuthor object
     */
    private NewAuthor findNewAuthor(String email){
        return this.newAuthors.stream()
                .filter(newAuthor -> newAuthor.getAuthorEmail().equalsIgnoreCase(email))
                .findAny()
                .orElse(null);
    }

}
