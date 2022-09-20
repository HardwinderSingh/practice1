package code.utility;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import code.model.UserModel;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	public void validate(Object object, Errors errors) {
		UserModel userModel=(UserModel)object;
		if(userModel.getName().length()<=5){
			errors.rejectValue("name", "p.name");
		}
		if (userModel.getId().length()<=5) {
			errors.rejectValue("id", "p.name");
		}
		
	}

}
