package za.ac.cput.domain.services.loan.impl;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Factory.author.AuthorFactory;
import za.ac.cput.domain.Factory.books.ArticleFactory;
import za.ac.cput.domain.Factory.loan.BorrowFactory;
import za.ac.cput.domain.Factory.member.StudentMemberFactory;
import za.ac.cput.domain.Factory.publisher.PublisherFactory;
import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.book.Book;
import za.ac.cput.domain.domain.loan.Borrow;
import za.ac.cput.domain.domain.member.Member;
import za.ac.cput.domain.domain.publisher.Publisher;

import static org.junit.Assert.*;

public class BorrwServiceImplTest {

    @Autowired
    private BorrwServiceImpl service;
    private Borrow borrow;
    private Book book;
    private Publisher publisher;
    private Author author;
    private Member member;
    @Before
    public void setUp() throws Exception {
        member = StudentMemberFactory.createStudentMember(1);
        author = AuthorFactory.createAuthor("Nceba","Goniwe","0740740918","0217149555",7441,"MLT",
                "CPT","WC",5);
        publisher = PublisherFactory.createPublisher(author,book,"Norman Publishers","0215489963",8000,"D6",
                "CPT","WC");
        book = ArticleFactory.createArticle(2012,"Cyberwarfare At its Best",author,publisher,"Technology");
        borrow = BorrowFactory.createLoan(book,member);
    }

    @Test(expected = NullPointerException.class)
    public void create() {
        assertEquals(service.create(borrow),service.create(borrow));
    }

    @Test
    @Ignore
    public void update() {
        assertEquals(service.update(borrow),service.update(borrow));
    }

    @Test
    @Ignore
    public void delete() {
        service.delete(borrow.getLoanId());
    }

    @Test
    @Ignore
    public void read() {
        assertEquals(service.read(borrow),service.read(borrow));
    }
}