package pl.discount.service;

import java.util.List;
import java.util.Optional;

import pl.discount.model.entity.Opinions;

public interface OpinionsService {
	
	public List<Opinions> getOpinions();
	public Optional<Opinions> getOpinion(int id);
	public void deleteOpinion(int id);
	public void saveOpinion(Opinions opinion);
}
