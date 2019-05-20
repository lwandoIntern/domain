package za.ac.cput.domain.controller.employee;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.domain.domain.employee.Employee;
import za.ac.cput.domain.services.employee.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("/domain/controller/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl service;

    @GetMapping("/create/")
    @ResponseBody
    public Employee create(Employee employee){
        return service.create(employee);
    }

    @GetMapping("/read/")
    @ResponseBody
    public Employee read(Employee employee){
        return service.read(employee);
    }

    @GetMapping("/update/")
    @ResponseBody
    public Employee update(Employee employee){
        return service.update(employee);
    }

    @GetMapping("/delete/")
    @ResponseBody
    public void delete(String id){
        service.delete(id);
    }
}
