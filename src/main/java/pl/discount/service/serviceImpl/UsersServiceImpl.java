package pl.discount.service.serviceImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import pl.discount.DAO.RoleDAO;
import pl.discount.DAO.UsersDAO;
import pl.discount.formtemplates.UserRegistrationTemplate;
import pl.discount.model.entity.Role;
import pl.discount.model.entity.Users;
import pl.discount.service.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	UsersDAO usersDAO;
	
	@Autowired
	RoleDAO roleDAO;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public List<Users> getUsers() {
		return usersDAO.findAll();
	}

	@Override
	public Optional<Users> getUser(Integer id) {
		return usersDAO.findById(id);
	}

	@Override
	public void deleteUsers(Integer id) {
		usersDAO.deleteById(id);
	}

	@Override
	public void saveUsers(UserRegistrationTemplate userTemplate) {
		
		Role userRole = roleDAO.findByRoleName("ROLE_USER");
		Collection<Role> roles = new ArrayList<Role>();
		roles.add(userRole);
		Users user = new Users();
		user.setUsername(userTemplate.getUsername());
		user.setPassword(passwordEncoder.encode(userTemplate.getPassword()));
		user.setFirstName(userTemplate.getFirstName());
		user.setLastName(userTemplate.getLastName());
		user.setEmail(userTemplate.getEmail());
		user.setBirthDate(userTemplate.getBirthDate());
		user.setRoles(roles);
		user.setStatus(1);
		
		usersDAO.save(user);
	}

	@Override
	public Users findByUserName(String username) {
		return usersDAO.findByUsername(username);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = usersDAO.findByUsername(username);
		if(user == null) {
			throw new UsernameNotFoundException("Niepoprawny login badz haslo");
		}
		if(user.getStatus() == 0) {
			throw new UsernameNotFoundException("Użytkownik został zablokowany");
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),mapRolesToAuthorities(user.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<pl.discount.model.entity.Role> roles){
		
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toList());
	}

}
