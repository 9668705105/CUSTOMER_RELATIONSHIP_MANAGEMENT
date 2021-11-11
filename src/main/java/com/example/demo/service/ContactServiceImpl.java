package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.AppConstant;
import com.example.demo.entity.Contact;
import com.example.demo.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService {
	
	@Autowired
	public ContactRepository crp;

	@Override
	public boolean saveContact(Contact contact) {
		contact.setActiveSwitch(AppConstant.YES);
		Contact save = new Contact();
				crp.save(contact);
		
		if(save!=null || save.getContactId()!=null || save.getContactNumber()!=null || save.getContactEmail()!=null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateContact(Contact contact) {
		contact.setActiveSwitch(AppConstant.YES);
		Contact save = new Contact();
				crp.save(contact);
		
		if(save!=null || save.getContactId()!=null || save.getContactNumber()!=null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> findAll = crp.findAll();
		return findAll;
		//return crp.findAll();
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Optional<Contact> findById = crp.findById(contactId);
		if(findById.isPresent()) {
			/*Contact contact= findById.get();
			return contact;*/
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		//HardDeleted(It means when we deleted record it's deleted from screen also from  database )
		boolean status = crp.existsById(contactId);
		if(status) {
		  crp.deleteById(contactId);
		  return true;
		}
		//SoftDeleted(It means when we deleted record it's deleted only from screen not from  database )
		/*Optional<Contact> fi = crp.findById(contactId);
		if(fi.isPresent()) {
			Contact contact = fi.get();
			contact.setActiveSwitch(AppConstant.NO);
			crp.save(contact);
			return true;
		}*/
		 
		return false;
	}

	

}
