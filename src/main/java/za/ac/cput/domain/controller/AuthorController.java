package za.ac.cput.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Factory.author.AuthorFactory;
import za.ac.cput.domain.domain.authors.Author;
import za.ac.cput.domain.services.author.impl.AuthorServiceImpl;

@RestController
@RequestMapping("/domain/controller")
public class AuthorController {
    @Autowired
    private AuthorServiceImpl service;

    @RequestMapping(value = "/{name}/{surname}/{cell}/{tell}/{zip}/{surbub}/{city}/{prov}/{numBooks}",method = RequestMethod.GET)
    @ResponseBody
    public Author create(@PathVariable String name, @PathVariable String surname, @PathVariable String cell, @PathVariable String tell,
                         @PathVariable int zip, @PathVariable String surbub, @PathVariable String city, @PathVariable String prov,
                         @PathVariable int numBooks){
        Author author = AuthorFactory.createAuthor(name,surname,cell,tell,zip,surbub,city,prov,numBooks);

        return service.create(author);
    }
}
