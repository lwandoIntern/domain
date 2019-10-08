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
    StaffRoleServiceImpl staffRoleService;
    @Autowired
    StaffDemographyServiceImpl staffDemographyService;
    @Autowired
    GenderServiceImpl genderService;
    @Autowired
    RaceServiceImpl raceService;
    @Autowired
    AddressServiceImpl addressService;
    @Autowired
    StaffAddressServiceImpl staffAddressService;
    @Autowired
    RoleServiceImpl roleService;
    @Autowired
    StaffServiceImpl staffService;

    @PostMapping(value = "/create",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity createStaff(@RequestBody NewStaff newStaff) {
        System.out.println(newStaff);
        ResponseObject responseObject = ResponseObjectFactory.buildGenericResponseObject(HttpStatus.OK.toString(), "Staff created");
        if (newStaff.getFirstName() == null || newStaff.getLastName() == null) {
            responseObject.setResponse(HttpStatus.PRECONDITION_FAILED.toString());
            responseObject.setResponseDescription("Please provide a name and/or last name");
        } else {
            Address address = getAddress(newStaff);
            Gender gender = getGender(newStaff);
            Race race = getRace(newStaff);
            Role role = getRole(newStaff);
            if (address == null || gender == null || race == null || role == null) {
                String message = address == null ? "Address not found|" : "";
                message += gender == null ? "Gender not found|" : "";
                message += race == null ? "Race not found|" : "";
                message += role == null ? "Role not found" : "";
                responseObject.setResponse(message);
            } else {
                Staff theStaff = saveStaff(newStaff);
                StaffAddress staffAddress = saveStaffAddress(theStaff, address);
                StaffDemography staffDemography = saveStaffDemography(theStaff, gender, race);
                StaffRole staffRole = saveStaffRole(theStaff, role);
                responseObject.setResponse(theStaff);
            }
        }
        return ResponseEntity.ok(responseObject);
    }

    private Staff saveStaff(NewStaff newStaff){
        return staffService.create(StaffFactory.createStaff(newStaff.getFirstName(),newStaff.getLastName()));
    }
    private StaffRole saveStaffRole(Staff staff,Role role){
        return staffRoleService.create(StaffRoleFactory.createStaffRole(staff.getStaffNum(),role.getRoleId()));
    }
    private StaffDemography saveStaffDemography(Staff staff,Gender gender,Race race){
        return staffDemographyService.create(StaffDemographyFactory.createStaffDemography(staff.getStaffNum(),gender.getGenderId(),race.getRaceId()));
    }
    private StaffAddress saveStaffAddress(Staff staff,Address address){
        return staffAddressService.create(StaffAddressFactory.createStaffAddress(staff.getStaffNum(),address.getAddressId()));
    }
    private Address getAddress(NewStaff newStaff) {
        return addressService.getByTown(newStaff.getAddressByTown());
    }
    private Role getRole(NewStaff newStaff) {
        return roleService.getRoleType(newStaff.getRole());
    }
    private Gender getGender(NewStaff newStaff) {
        return genderService.getByDesc(newStaff.getGender());
    }
    private Race getRace(NewStaff newStaff) {
        return raceService.getByDesc(newStaff.getRace());
    }

}
