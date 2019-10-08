package za.ac.cput.controller.staff;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.ResponseObject;
import za.ac.cput.domain.demography.Gender;
import za.ac.cput.domain.demography.Race;
import za.ac.cput.domain.location.Address;
import za.ac.cput.domain.request.NewStaff;
import za.ac.cput.domain.role.Role;
import za.ac.cput.domain.staff.Staff;
import za.ac.cput.domain.staff.StaffAddress;
import za.ac.cput.domain.staff.StaffDemography;
import za.ac.cput.domain.staff.StaffRole;
import za.ac.cput.factory.ResponseObjectFactory;
import za.ac.cput.factory.staff.StaffAddressFactory;
import za.ac.cput.factory.staff.StaffDemographyFactory;
import za.ac.cput.factory.staff.StaffFactory;
import za.ac.cput.factory.staff.StaffRoleFactory;
import za.ac.cput.service.demography.impl.GenderServiceImpl;
import za.ac.cput.service.demography.impl.RaceServiceImpl;
import za.ac.cput.service.location.impl.AddressServiceImpl;
import za.ac.cput.service.role.impl.RoleServiceImpl;
import za.ac.cput.service.staff.impl.StaffAddressServiceImpl;
import za.ac.cput.service.staff.impl.StaffDemographyServiceImpl;
import za.ac.cput.service.staff.impl.StaffRoleServiceImpl;
import za.ac.cput.service.staff.impl.StaffServiceImpl;

import java.util.Set;

@RestController
@RequestMapping("/domain/staff")
public class StaffController {
    @Autowired
    StaffServiceImpl staffService;

    @PostMapping(value = "/create")
    @ResponseBody
    public Staff create(@RequestBody Staff staff){
        return this.staffService.create(staff);
    }

    @GetMapping(value = "/read")
    @ResponseBody
    public Staff update(@PathVariable String id){
        return this.staffService.read(id);
    }

    @PutMapping(value = "/update")
    @ResponseBody
    public Staff update(@RequestBody Staff staff){
        return this.staffService.update(staff);
    }

    @DeleteMapping(value = "/delete")
    public void delete(@PathVariable String id){
        this.staffService.delete(id);
    }

    @GetMapping(value = "/getall")
    @ResponseBody
    public Set<Staff> getAll(){
        return this.staffService.getAll();
    }
}
