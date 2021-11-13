package springboot.dao;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import springboot.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserDaoImpl() {
    }

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void deleteUser(long id) {
        entityManager.remove(getUserById(id));
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        User user = entityManager.createQuery("SELECT u FROM User u where u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
        return user;
    }

    @Override
    public User getUserByName(String name) {
        User user = entityManager.createQuery("SELECT u FROM User u where u.name = :name", User.class)
                .setParameter("name", name)
                .getSingleResult();
        return user;
    }
}
