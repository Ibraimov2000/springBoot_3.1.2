package springboot.service;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import springboot.model.Role;
import springboot.model.User;

import javax.annotation.PostConstruct;
import java.util.Set;


@Component
@Transactional
public class DBInitializer {

    private UserService userService;

    public DBInitializer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void initUsers() {
        User admin = new User();
        admin.setName("Name");
        admin.setLastName("Last Name");
        admin.setEmail("admin@email.com");
        admin.setPassword("admin");
        admin.setRoles(Set.of(new Role("ADMIN")));
        userService.createUser(admin);

        User user = new User();
        user.setName("UserName");
        user.setLastName("UserLastName");
        user.setEmail("user@email.com");
        user.setPassword("user");
        user.setRoles(Set.of(new Role("USER")));
        userService.createUser(user);
    }
}
