package pl.discount.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.discount.DAO.OpinionsDAO;
import pl.discount.model.entity.Opinions;
import pl.discount.service.OpinionsService;

@Service
public class OpinionsServiceImpl implements OpinionsService {
	
	@Autowired
	OpinionsDAO opinionsDAO;
	
	@Override
	public List<Opinions> getOpinions() {
		return opinionsDAO.findAll();
	}

	@Override
	public Optional<Opinions> getOpinion(int id) {
		return opinionsDAO.findById(Integer.valueOf(id));
	}

	@Override
	public void deleteOpinion(int id) {
		opinionsDAO.deleteById(Integer.valueOf(id));;
	}

	@Override
	public void saveOpinion(Opinions opinion) {
		opinionsDAO.save(opinion);
	}

}
