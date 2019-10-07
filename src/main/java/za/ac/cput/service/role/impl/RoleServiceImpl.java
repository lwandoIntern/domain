package za.ac.cput.service.role.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.role.Role;
import za.ac.cput.repository.role.RoleRepository;
import za.ac.cput.service.role.RoleService;


import java.util.HashSet;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private static RoleService roleService = null;
    @Autowired
    private RoleRepository roleRepository;

    private RoleServiceImpl(){}

    public static RoleService getRoleService() {
        if (roleService == null)roleService = new RoleServiceImpl();
        return roleService;
    }

    @Override
    public Role create(Role role) {
        this.roleRepository.save(role);
        return this.roleRepository.getOne(role.getRoleId());
    }

    @Override
    public Role read(String s) {
        return this.roleRepository.getOne(s);
    }

    @Override
    public Role update(Role role){
        Role role1 = read(role.getRoleId());
        if (role1 == role){
            delete(role1.getRoleId());
            return create(role);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        if (read(s) != null)
            this.roleRepository.deleteById(s);
    }

    @Override
    public Set<Role> getAll() {
        Set<Role> roles = new HashSet<>();
        roles.addAll(this.roleRepository.findAll());
        return roles;
    }

    @Override
    public Role getRoleType(String type) {
        return getAll().stream()
                .filter(role -> role.getRoleType().equalsIgnoreCase(type))
                .findAny()
                .get();
    }
}
