package code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import code.model.UserModel;
import code.utility.UserValidator;

@Controller
public class UserController {
	@Autowired
	UserModel usr;
	@Autowired
	UserValidator userValidator;
	@RequestMapping(value="open", method= RequestMethod.GET)
	public ModelAndView GetDetail(){
		
		return new ModelAndView("a","h1",usr);
	} 
	
	
	@RequestMapping(value="login",method=RequestMethod.POST )
	public ModelAndView getData(@ModelAttribute("h1") UserModel usr,BindingResult br){
		userValidator.validate(usr, br);
	
		if(!br.hasErrors())
		{
			ModelAndView modelAndView = new ModelAndView("s","etc",usr);
			
			return modelAndView;
		}
	  return new ModelAndView("a");
	}
}
