package pl.discount.service;

import java.util.List;
import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetailsService;

import pl.discount.formtemplates.UserRegistrationTemplate;
import pl.discount.model.entity.Users;

public interface UsersService extends UserDetailsService{
	
	public List<Users> getUsers();
	public Optional<Users> getUser(Integer id);
	public Users findByUserName(String username);
	public void deleteUsers(Integer id);
	public void saveUsers(UserRegistrationTemplate userTemplate);
}
