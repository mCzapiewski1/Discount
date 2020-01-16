package pl.discount.service;

import java.util.List;
import java.util.Optional;
import pl.discount.model.entity.Discount;

public interface DiscountService {
	
	public List<Discount> getDiscounts();
	public Optional<Discount> getDiscount(int id);
	public void deleteDiscount(int id);
	public void saveDiscount(Discount discount);
	
}
