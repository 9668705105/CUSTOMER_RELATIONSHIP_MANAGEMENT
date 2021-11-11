package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.AppConstant;
import com.example.demo.entity.Contact;
import com.example.demo.props.AppProps;
import com.example.demo.service.ContactServiceImpl;

@Controller
public class ContactInfoController {
	
	@Autowired
	public AppProps ap;
	
	@Autowired
	public ContactServiceImpl cs;

	@GetMapping("/contact")
	public String loadContactForm(@Valid Model model) {
		Contact contactobj=new Contact();
		model.addAttribute("contact", contactobj);
		return AppConstant.CONTACTINFO;
	}
	
	@PostMapping("/saveContact")
	public String saveContact(@Valid Contact contact,Model model) {
		boolean isSaved = cs.saveContact(contact);
		
		Map<String, String> messages = ap.getMessages();
		
		if(isSaved) {
			model.addAttribute(AppConstant.SUCCESS,messages.get("saveSuccess"));
		}
		else {
			model.addAttribute(AppConstant.FAIL, messages.get("saveFail"));
		}
		 model.addAttribute("msg","Student Registration Successfull...");
	       return "dashboard";
		//return AppConstant.CONTACTINFO;
		
	}
	
	@PostMapping("/updateContact")
	public String updateContact(@Valid Contact contact,Model model) {
		boolean isUpdate = cs.updateContact(contact);
		
		Map<String, String> messages = ap.getMessages();
		
		if(isUpdate) {
			model.addAttribute(AppConstant.SAVE_UPDATE,messages.get("saveUpdate"));
		}
		else {
			model.addAttribute(AppConstant.FAIL, messages.get("saveFail"));
		}
		 model.addAttribute("up","Student Update Successfull...");
	       return "dashboard";
		//return AppConstant.CONTACTINFO;
		
	}
	
	
	
	@GetMapping("/viewContacts")
	public String showAllContacts(@Valid Model model) {
		List<Contact> allContacts = cs.getAllContacts();
		model.addAttribute("contacts", allContacts);
		return AppConstant.CONTACTS;
	}
	
	
	
	
}
