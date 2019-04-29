package za.ac.cput.domain.repository.borrow_repository.impl;

import za.ac.cput.domain.Factory.author.AuthorFactory;
import za.ac.cput.domain.Factory.books.ArticleFactory;
import za.ac.cput.domain.Factory.loan.BorrowFactory;
import za.ac.cput.domain.Factory.member.RegularMemberFactory;
import za.ac.cput.domain.Factory.publisher.PublisherFactory;
import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.borrowingProccess.Borrow;
import za.ac.cput.domain.domain.members.Member;
import org.junit.Before;
import org.junit.Test;
import za.ac.cput.domain.domain.publishers.Publisher;
import za.ac.cput.domain.repository.borrow_repository.BorrowRepository;

import static org.junit.Assert.*;

public class BorrowRepositoryImplTest {

    private BorrowRepository repository;
    private Borrow borrow;
    private Book book;
    private Member member;
    private Author author;
    private Publisher publisher;

    @Before
    public void setUp() throws Exception {
        repository = BorrowRepositoryImpl.getRepository();
        author = AuthorFactory.createAuthor("Zoe","Saldana","555-747-8164","555-814-7414",
                2166,"MIT","LA","",14);
        publisher = PublisherFactory.createPublisher(author,book,"Norman Publishers","0215489963",8000,"D6",
                "CPT","WC");
        member = RegularMemberFactory.createRegularMember("John","Sminorf0","0840147521","0217415566",
                7441,"MIL","CPT","WC");
        book = ArticleFactory.createArticle("1",2012,"Cyberwarfare At its Best",author,publisher,"Technology");
        borrow = BorrowFactory.createLoan("125",book,member);
    }

    @Test
    public void create() {
        assertEquals(repository.create(borrow),repository.create(borrow));
    }

    @Test
    public void read() {
        assertEquals(repository.read(borrow),repository.read(borrow));
    }

    @Test
    public void update() {
        assertEquals(repository.update(borrow), repository.update(borrow));
    }

    @Test
    public void delete() {
        repository.delete(borrow.getLoanId());
    }
}