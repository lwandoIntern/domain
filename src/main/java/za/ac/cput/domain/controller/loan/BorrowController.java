package za.ac.cput.domain.controller.loan;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.domain.loan.Borrow;
import za.ac.cput.domain.services.loan.impl.BorrwServiceImpl;

@RestController
@RequestMapping("/domain/controller/borrow")
public class BorrowController {
    @Autowired
    private BorrwServiceImpl service;

    @GetMapping("/create/")
    @ResponseBody
    public Borrow create(Borrow borrow){
        return service.create(borrow);
    }

    @GetMapping("/read/")
    @ResponseBody
    public Borrow read(Borrow borrow){
        return service.read(borrow);
    }

    @GetMapping("/update/")
    @ResponseBody
    public Borrow update(Borrow borrow){
        return service.update(borrow);
    }

    @GetMapping("/delete/")
    @ResponseBody
    public void delete(String id){
        service.delete(id);
    }
}
