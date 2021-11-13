package springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dao.RoleDao;
import springboot.model.Role;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public void addRole(Role role) {
        roleDao.addRole(role);
    }

    @Override
    public void deleteRole(long id) {
        roleDao.deleteRole(id);
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public Role getRoleById(long id) {
        return roleDao.getRoleById(id);
    }

    @Override
    public Role getRoleByName(String rolename) {
        return roleDao.getRoleByName(rolename);
    }
}
