package pl.discount.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.discount.model.entity.Discount;

public interface DiscountDAO extends CrudRepository<Discount, Integer>{
	
	List<Discount> findAll();
}
