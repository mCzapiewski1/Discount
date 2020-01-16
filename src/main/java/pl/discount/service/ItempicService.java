package pl.discount.service;

import java.util.List;
import java.util.Optional;

import pl.discount.model.entity.Itempic;

public interface ItempicService {
	
	public List<Itempic> getAllPictres();
	public Optional<Itempic> getPicture(int id);
	public Itempic getPictureByName(String name);
	public void savePicure(Itempic itempic);
	public void deletePicture(Itempic itempic);
}
