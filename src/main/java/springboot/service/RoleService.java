package springboot.service;


import springboot.model.Role;

import java.util.List;

public interface RoleService {

    void addRole(Role role);

    void deleteRole(long id);

    List<Role> getRoles();

    Role getRoleById(long id);

    Role getRoleByName(String rolename);
}
