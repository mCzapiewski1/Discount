package pl.discount.service;

import java.util.List;
import java.util.Optional;
import pl.discount.model.entity.Role;

public interface RoleService {
	
	public List<Role> getRoles();
	public Optional<Role> getRole(int id);
	public void deleteRole(int id);
	public void saveRole(Role role);
}
