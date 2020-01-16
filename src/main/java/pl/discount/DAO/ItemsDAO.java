package pl.discount.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.discount.model.entity.Items;

public interface ItemsDAO extends CrudRepository<Items, Integer>{
	
	List<Items> findAll();
}
