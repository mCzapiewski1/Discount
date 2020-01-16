package pl.discount.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.discount.model.entity.Role;

public interface RoleDAO extends CrudRepository<Role, Integer>{
	
	List<Role> findAll();
	Role findByRoleName(String roleName);
}
