package pl.discount.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.discount.DAO.RoleDAO;
import pl.discount.model.entity.Role;
import pl.discount.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDAO roleDAO;
	
	@Override
	public List<Role> getRoles() {
		return roleDAO.findAll();
	}

	@Override
	public Optional<Role> getRole(int id) {
		return roleDAO.findById(Integer.valueOf(id));
	}

	@Override
	public void deleteRole(int id) {
		roleDAO.deleteById(Integer.valueOf(id));
	}

	@Override
	public void saveRole(Role role) {
		roleDAO.save(role);
	}

}
