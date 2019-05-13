package za.ac.cput.domain.controller.author_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Factory.author.AuthorFactory;
import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.domain.publishers.Publisher;
import za.ac.cput.domain.services.author.impl.AuthorServiceImpl;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/domain/controller/author")
public class AuthorController {
    @Autowired
    private AuthorServiceImpl service;

    @GetMapping("/create/")
    @ResponseBody
    public Author create(Author author){
        return service.create(author);
    }

    @GetMapping("/read/")
    @ResponseBody
    public Author read(Author author){
        return service.read(author);
    }

    @GetMapping("/update/")
    @ResponseBody
    public Author update(Author author){
        return service.update(author);
    }

    @GetMapping("/delete/")
    @ResponseBody
    public void delete(String id){
        service.delete(id);
    }

//    public Set<Publisher> getAll(){
//        Collection<Publisher> publishering = this.publishers.values();
//        Set<Publisher> set = new HashSet<>();
//        set.addAll(publishering);
//        return set;
//    }
}
