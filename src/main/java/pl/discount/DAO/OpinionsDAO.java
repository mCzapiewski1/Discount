package pl.discount.DAO;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pl.discount.model.entity.Opinions;

public interface OpinionsDAO extends CrudRepository<Opinions, Integer>{
	
	List<Opinions> findAll();
}
