package za.ac.cput.controller.role;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.role.Role;
import za.ac.cput.service.role.impl.RoleServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/domain/role")
public class RoleController {
    @Autowired
    RoleServiceImpl roleService;


    @PostMapping("/create")
    public Role create(@RequestBody Role role){
        return roleService.create(role);
    }
    @GetMapping("/read")
    public Role read(String id){
        return roleService.read(id);
    }
    @PutMapping("/update")
    public Role update(Role role){
        return roleService.update(role);
    }
    @DeleteMapping("/delete")
    public void delete(String id){
        roleService.delete(id);
    }
    @GetMapping("/getAll")
    public Set<Role> getAll(){
        return roleService.getAll();
    }
}
