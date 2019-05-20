package za.ac.cput.domain.controller.system_access.forgot_password;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.domain.sysemAccess.ForgotPassword;
import za.ac.cput.domain.services.systemAccess.forgot_password.ForgotPasswordService;
import za.ac.cput.domain.services.systemAccess.forgot_password.impl.ForgotPasswordServiceImpl;

@RestController
@RequestMapping("/domain/controller/forgot_pass")
public class ForgotPasswordController {
    @Autowired
    private ForgotPasswordServiceImpl service;

    @GetMapping("/create/")
    @ResponseBody
    public ForgotPassword create(ForgotPassword forgotPassword){
        return service.create(forgotPassword);
    }

    @GetMapping("/read/")
    @ResponseBody
    public ForgotPassword read(ForgotPassword forgotPassword){
        return service.read(forgotPassword);
    }

    @GetMapping("/update/")
    @ResponseBody
    public ForgotPassword update(ForgotPassword forgotPassword){
        return service.update(forgotPassword);
    }

    @GetMapping("/delete/")
    @ResponseBody
    public void delete(String id){
        service.delete(id);
    }
}

