package pl.discount.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pl.discount.validation.UserExistsConstraintValidator;

@Constraint(validatedBy = UserExistsConstraintValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserExists {
	
	public String message() default "User exists";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {}; 
}
