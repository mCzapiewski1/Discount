package pl.discount.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import pl.discount.model.entity.Itempic;


public interface ItempicDAO extends CrudRepository<Itempic, Integer>{
	
	List<Itempic> findAll();
	Itempic findByName(String name);
}
