package za.ac.cput.service.role.impl;

import org.springframework.stereotype.Service;
import za.ac.cput.domain.role.Role;
import za.ac.cput.repository.role.RoleRepository;
import za.ac.cput.repository.role.impl.RoleRepositoryImpl;
import za.ac.cput.service.role.RoleService;

import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {
    private static RoleService roleService = null;
    private RoleRepository roleRepository;

    private RoleServiceImpl(){
        this.roleRepository = RoleRepositoryImpl.getRoleRepository();
    }

    public static RoleService getRoleService() {
        if (roleService == null)roleService = new RoleServiceImpl();
        return roleService;
    }

    @Override
    public Role create(Role role) {
        return this.roleRepository.create(role);
    }

    @Override
    public Role read(String s) {
        return this.roleRepository.read(s);
    }

    @Override
    public Role update(Role role) {
        return this.roleRepository.update(role);
    }

    @Override
    public void delete(String s) {
        this.roleRepository.delete(s);
    }

    @Override
    public Set<Role> getAll() {
        return this.roleRepository.getAll();
    }

    @Override
    public Role getRoleType(String type) {
        return this.roleRepository.getRoleType(type);
    }
}
