package pl.discount.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.discount.DAO.DiscountDAO;
import pl.discount.model.entity.Discount;
import pl.discount.service.DiscountService;

@Service
public class DiscountServiceImpl implements DiscountService {
	
	@Autowired
	DiscountDAO discountDAO;
	
	@Override
	public List<Discount> getDiscounts() {
		return discountDAO.findAll();
		
	}

	@Override
	public Optional<Discount> getDiscount(int id) {
		return discountDAO.findById(Integer.valueOf(id));
	}

	@Override
	public void deleteDiscount(int id) {
		discountDAO.deleteById(Integer.valueOf(id));
	}

	@Override
	public void saveDiscount(Discount discount) {
		discountDAO.save(discount);
	}

}
