package za.ac.cput.domain.role;

import java.util.Objects;

public class Role {
    private String roleId,roleType;

    public Role(Builder builder) {
        this.roleId = builder.roleId;
        this.roleType = builder.roleType;
    }

    public String getRoleId() {
        return roleId;
    }

    public String getRoleType() {
        return roleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role = (Role) o;
        return roleId.equals(role.roleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId);
    }
    public static class Builder{
        private String roleId,roleType;

        public Builder roleId(String id){
            this.roleId = id;
            return this;
        }
        public Builder roleType(String roleType){
            this.roleType = roleType;
            return this;
        }
        public Role build(){
            return new Role(this);
        }
    }
}
