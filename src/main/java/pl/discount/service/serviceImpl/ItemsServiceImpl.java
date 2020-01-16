package pl.discount.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.discount.DAO.ItemsDAO;
import pl.discount.model.entity.Items;
import pl.discount.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {

	@Autowired
	ItemsDAO itemsDAO;
	
	@Override
	public List<Items> getItems() {
		return itemsDAO.findAll();
	}

	@Override
	public Optional<Items> getItem(int id) {
		return itemsDAO.findById(Integer.valueOf(id));
	}

	@Override
	public void deleteItem(int id) {
		itemsDAO.deleteById(Integer.valueOf(id));
	}

	@Override
	public void saveItem(Items item) {
		itemsDAO.save(item);
	}

}
