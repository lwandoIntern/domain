package za.ac.cput.domain.controller.publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.domain.publisher.Publisher;
import za.ac.cput.domain.services.employee.impl.EmployeeServiceImpl;
import za.ac.cput.domain.services.publisher.impl.PublisherServiceImpl;

@RestController
@RequestMapping("/domain/controller/publisher")
public class PublisherController {
    @Autowired
    private PublisherServiceImpl service;

    @GetMapping("/create/")
    @ResponseBody
    public Publisher create(Publisher publisher){
        return service.create(publisher);
    }

    @GetMapping("/read/")
    @ResponseBody
    public Publisher read(Publisher publisher){
        return service.read(publisher);
    }

    @GetMapping("/update/")
    @ResponseBody
    public Publisher update(Publisher publisher){
        return service.update(publisher);
    }

    @GetMapping("/delete/")
    @ResponseBody
    public void delete(String id){
        service.delete(id);
    }
}
