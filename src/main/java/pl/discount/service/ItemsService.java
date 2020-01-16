package pl.discount.service;

import java.util.List;
import java.util.Optional;

import pl.discount.model.entity.Items;

public interface ItemsService {
	
	public List<Items> getItems();
	public Optional<Items> getItem(int id);
	public void deleteItem(int id);
	public void saveItem(Items item);
}
