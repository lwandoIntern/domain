package za.ac.cput.repository.role.impl;

import za.ac.cput.domain.role.Role;
import za.ac.cput.repository.role.RoleRepository;

import java.util.HashSet;
import java.util.Set;

public class RoleRepositoryImpl implements RoleRepository {
    private static RoleRepository roleRepository = null;
    private Set<Role> roles;

    private RoleRepositoryImpl(){
        this.roles = new HashSet<>();
    }

    public static RoleRepository getRoleRepository() {
        if (roleRepository == null)roleRepository = new RoleRepositoryImpl();
        return roleRepository;
    }

    private Role findRole(String s){
        return this.roles.stream()
                .filter(role -> role.getRoleId().trim().equalsIgnoreCase(s))
                .findAny()
                .orElse(null);
    }
    @Override
    public Role getRoleType(String type) {
        return this.roles.stream()
                .filter(role -> role.getRoleType().equalsIgnoreCase(type))
                .findAny()
                .orElse(null);
    }

    @Override
    public Role create(Role role) {
        this.roles.add(role);
        return role;
    }

    @Override
    public Role read(String s) {
        Role role = findRole(s);
        return role;
    }

    @Override
    public Role update(Role role) {
        Role toDelete = findRole(role.getRoleId());
        if (toDelete != null){
            this.roles.remove(toDelete);
            return create(role);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        Role role = findRole(s);
        if (role != null)
            this.roles.remove(role);
    }

    @Override
    public Set<Role> getAll() {
        return this.roles;
    }
}
