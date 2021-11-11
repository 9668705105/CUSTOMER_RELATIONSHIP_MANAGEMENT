package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.entity.Contact;
import com.example.demo.service.ContactServiceImpl;

@Controller
public class ViewContactsController {
	
	@Autowired
	public ContactServiceImpl cs;
	
	@GetMapping("/edit")
	public String editContact(@Valid @RequestParam("cid")Integer contactId,Model model) {
		Contact contactById = cs.getContactById(contactId);
		model.addAttribute("contact", contactById);
		return "contactInfo2";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@Valid @RequestParam("cid")Integer contactId) {
		cs.deleteContactById(contactId);
		return "redirect:viewContacts";
	}

}
