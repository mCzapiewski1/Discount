package pl.discount.validation;

import java.util.Optional;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.discount.annotation.UserExists;
import pl.discount.model.entity.Users;
import pl.discount.service.UsersService;

public class UserExistsConstraintValidator implements ConstraintValidator<UserExists, String> {
	
	private UsersService usersService;
	
	public UserExistsConstraintValidator(UsersService usersService) {
        this.usersService = usersService;
    }
	
	@Override
	public void initialize(UserExists constraintAnnotation) {}
	
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		boolean result;
		Users user = usersService.findByUserName(value);
		
		if(user != null ) {
			result = false;
		}else {
			result = true;
		}
		return result;
	}
}
