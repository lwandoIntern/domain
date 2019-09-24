package za.ac.cput.controller.books;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

@RestController
@RequestMapping("/domain/books")
public class BookController {
    @Autowired
    BookServiceImpl bookService;
    @Autowired
    CategoryServiceImpl categoryService;
    @Autowired
    BookPublisherServiceImpl bookPublisherService;
    @Autowired
    BookCategoryServiceImpl bookCategoryService;
    @Autowired
    AuthorBookServiceImpl authorBookService;
    @Autowired
    AuthorServiceImpl authorService;
    @Autowired
    PublisherServiceImpl publisherService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createBook(@RequestBody NewBook newBook){
        System.out.println(newBook);
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(),"Book create!");
        if (newBook.getBookTitle() == null || newBook.getCategoryName() == null || newBook.getEditionNumber() <= 0 || newBook.getYearPublished() == null){
            responseObject.setResponse(HttpStatus.PRECONDITION_FAILED.toString());
            responseObject.setResponseDescription("Please provide book title and/or category name and/or edition number and/or year of publishing");
        }else {
            Category category = getCategory(newBook);
            Author author = getAuthor(newBook);
            Publisher publisher = getPublisher(newBook);

            if (category == null || author == null || publisher == null){
                responseObject.setResponseCode(HttpStatus.PRECONDITION_FAILED.toString());
                String msg = category == null ? "Category not found|":"";
                msg += author == null ? "Author not found|":"";
                msg += publisher == null ? "Publisher not found":"";
                responseObject.setResponseDescription(msg);
            }else {
                Book saveBoo = saveBook(newBook);
                BookCategory saveBookCat = saveBookCategory(saveBoo,category);
                BookPublisher saveBookPublish = saveBookPublisher(saveBoo,publisher);
                AuthorBook saveAuthBook = saveAuthorBook(author,saveBoo);
                responseObject.setResponse(saveBoo);
            }
        }
        return ResponseEntity.ok(responseObject);
    }
    private Book saveBook(NewBook book){
        Book book1 = BookFactory.createBook(book.getBookTitle(),book.getEditionNumber(),book.getYearPublished());
        return bookService.create(book1);
    }
    private BookCategory saveBookCategory(Book book,Category saveCat){
        BookCategory bookCategory = BookCategoryFactory.createBookCategory(book.getIsbn(),saveCat.getCategoryId());
        return bookCategoryService.create(bookCategory);
    }
    private AuthorBook saveAuthorBook(Author newAuthor,Book book){
        AuthorBook authorBook = AuthorBookFactory.createAuthorBook(newAuthor.getAuthorEmail(),book.getIsbn());
        return authorBookService.create(authorBook);
    }
    private BookPublisher saveBookPublisher(Book book,Publisher publisher){
        BookPublisher bookPublisher = BookPublisherFactory.createBookPublisher(book.getIsbn(),publisher.getPublisherId());
        return bookPublisherService.create(bookPublisher);
    }
    private Category getCategory(NewBook book){
        return categoryService.getByCategoryName(book.getCategoryName());
    }
    private Publisher getPublisher(NewBook newBook){
        return publisherService.getByName(newBook.getPublisherName());
    }
    private Author getAuthor(NewBook newBook){
        return authorService.getByFullName(newBook.getFullname());
    }
}
