package springboot.dao;

import org.springframework.stereotype.Repository;
import springboot.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public RoleDaoImpl() {
    }

    @Override
    public void addRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void deleteRole(long id) {
        entityManager.remove(getRoleById(id));
    }

    @Override
    public List<Role> getRoles() {
        return entityManager.createQuery("from Role", Role.class).getResultList();
    }

    @Override
    public Role getRoleByName(String rolename) {
        Role role = entityManager.createQuery("SELECT r FROM Role r where r.name = :name", Role.class)
                .setParameter("name", rolename)
                .getSingleResult();
        return role;
    }

    @Override
    public Role getRoleById(long id) {
        Role role = entityManager.createQuery("SELECT r FROM Role r where r.id = :id", Role.class)
                .setParameter("id", id)
                .getSingleResult();
        return role;
    }
}
