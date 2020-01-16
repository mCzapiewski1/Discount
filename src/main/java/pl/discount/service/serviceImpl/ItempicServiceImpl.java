package pl.discount.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.discount.DAO.ItempicDAO;
import pl.discount.model.entity.Itempic;
import pl.discount.service.ItempicService;

@Service
public class ItempicServiceImpl implements ItempicService {
	
	@Autowired
	ItempicDAO itempicDAO;
	
	@Override
	public List<Itempic> getAllPictres() {
		
		return itempicDAO.findAll();
	}

	@Override
	public Optional<Itempic> getPicture(int id) {
		
		return itempicDAO.findById(Integer.valueOf(id));
	}

	@Override
	public Itempic getPictureByName(String name) {
		
		return itempicDAO.findByName(name);
	}

	@Override
	public void savePicure(Itempic itempic) {
		
		itempicDAO.save(itempic);
	}

	@Override
	public void deletePicture(Itempic itempic) {
		
		itempicDAO.delete(itempic);
	}

}
