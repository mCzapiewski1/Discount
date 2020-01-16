package pl.discount.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.discount.model.entity.Users;

public interface UsersDAO extends CrudRepository<Users, Integer>{
	
	List<Users> findAll();
	Users findByUsername(String username);
}
