package za.ac.cput.domain.controller.system_access.registration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.domain.sysemAccess.Register;
import za.ac.cput.domain.services.systemAccess.registration.impl.RegisterServiceImpl;

@RestController
@RequestMapping("/domain/controller/register")
public class RegisterController {
    @Autowired
    private RegisterServiceImpl service;

    @GetMapping("/create/")
    @ResponseBody
    public Register create(Register register){
        return service.create(register);
    }

    @GetMapping("/read/")
    @ResponseBody
    public Register read(Register register){
        return service.read(register);
    }

    @GetMapping("/update/")
    @ResponseBody
    public Register update(Register register){
        return service.update(register);
    }

    @GetMapping("/delete/")
    @ResponseBody
    public void delete(String id){
        service.delete(id);
    }
}

