package za.ac.cput.domain.controller.system_access.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.domain.sysemAccess.Login;
import za.ac.cput.domain.services.systemAccess.login.impl.LoginServiceImpl;

@RestController
@RequestMapping("/domain/controller/login")
public class LoginController {
    @Autowired
    private LoginServiceImpl service;

    @GetMapping("/create/")
    @ResponseBody
    public Login create(Login login){
        return service.create(login);
    }

    @GetMapping("/read/")
    @ResponseBody
    public Login read(Login login){
        return service.read(login);
    }

    @GetMapping("/update/")
    @ResponseBody
    public Login update(Login login){
        return service.update(login);
    }

    @GetMapping("/delete/")
    @ResponseBody
    public void delete(String id){
        service.delete(id);
    }
}

