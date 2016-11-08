package com.apex.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.apex.validation.PersonalVO;
@Controller
@SessionAttributes("personalVO")
public class PersonalController {
	private Validator validator;
 
	public PersonalController() {
	ValidatorFactory validatorFactory=Validation.buildDefaultValidatorFactory();
	validator= validatorFactory.getValidator();
	}
	
	 @RequestMapping("/addNew")
	    public String setupForm(Model model) {
		 System.out.println("THis is PersonalController");
	       PersonalVO personalVO = new PersonalVO();
	        model.addAttribute("personalVO", personalVO);
	        return "addPersonalInfo";
	}
	 
	 @RequestMapping(value="/addPersonalInfo",method= RequestMethod.POST)
	 public String submit(@ModelAttribute PersonalVO personalVO,BindingResult result,SessionStatus status)
	 {
		 Set<ConstraintViolation<PersonalVO>> violations=validator.validate(personalVO);
		 for(ConstraintViolation<PersonalVO> violation: violations)
		 {
			 String propertyPath=violation.getPropertyPath().toString();
			 String message=violation.getMessage();
			 result.addError(new FieldError("personalVO", propertyPath, "Invalid ( "+message+")"));
		 }
		 if(result.hasErrors())
		 {
			 return "addPersonalInfo";
		 }
		 
		 status.setComplete();
		 return "addSuccess";
	 }
}
