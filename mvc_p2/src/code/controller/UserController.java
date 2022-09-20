package code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import code.dao.Getdata;
import code.model.StateModel;
import code.model.UserModel;
import code.model.UserStateModel;



@Controller
@RequestMapping("document/")
public class UserController {
	@Autowired
	UserModel usr;
	@Autowired
	UserStateModel userStateModel;
	@Autowired
	Getdata getdata;
	
	@RequestMapping(value="home", method= RequestMethod.GET)
	public ModelAndView homeDocument(){
		
		return new ModelAndView("home","h1",usr);
	} 
	
	//user state data signin
	@RequestMapping(value="open", method= RequestMethod.GET)
	public ModelAndView userstatedata(Model model){
		/*List<StateModel> stateList = getdata.getStateList();
		model.addAttribute("list", stateList);*/
		return new ModelAndView("a","usm1",userStateModel);
	} 
	//get state list
	@ModelAttribute("stateList")
	public List<StateModel>  getStateList() {
		// TODO Auto-generated method stub
		List<StateModel> stateList = getdata.getStateList();
		System.out.println(stateList.size());
		return stateList;
	}
	@RequestMapping(value="saveRegist",method= RequestMethod.POST)
	public ModelAndView saveRegistrastion(@ModelAttribute("usm1")UserStateModel userStateModel){
		boolean regist = getdata.saveUserRegist(userStateModel);
		if (regist) {
			
			return new ModelAndView("s");
		}
		return new ModelAndView("e");
	}
	@RequestMapping(value="view")
	public ModelAndView viewdata(Model model){
		List<Object[]> sql = getdata.getDataRegistSql();
		for(Object[] a:sql){
			System.out.println(a[0]);
		}
		
		List<UserStateModel> list = getdata.getDataRegist();
		
			model.addAttribute("list", list);
		return new ModelAndView("view");
	}
	
	//save data a page login
	@RequestMapping(value="save",method=RequestMethod.POST )
	public ModelAndView getData(@ModelAttribute("h1") UserModel usr){
		
			ModelAndView modelAndView = new ModelAndView("s","etc",usr);
			return modelAndView;
	}
	@RequestMapping(value="loginpage" )
	public ModelAndView Loginpage(@ModelAttribute("h1") UserModel usr){
			ModelAndView modelAndView = new ModelAndView("login","lgn",usr);
			return modelAndView;
		
	}
}
