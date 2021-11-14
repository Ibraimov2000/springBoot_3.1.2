package springboot.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.model.Role;
import springboot.repository.RoleRepository;
import springboot.service.RoleService;

import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    public RoleServiceImpl (RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Set<Role> getAllRoles() {
        Iterable<Role>  iterable = roleRepository.findAll();
        Set<Role> set = new HashSet<>();
        iterable.forEach(set::add);
        return set;
    }
}
