package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="CONTACT_DTLS")
public class Contact {
	@Id
	@Column(name="CONTACT_ID")
	@GeneratedValue
	private Integer contactId;
	
	@NotEmpty
	@Size(min=1, message= "please fill name properly")
	@Column(name="CONTACT_NAME")
	private String contactName;
	
	@Email
	@NotEmpty
	@Size(min=1, message= "please fill contactno properly")
	@Column(name="CONTACT_EMAIL",unique=true)
	private String contactEmail;
	
	
	@Column(name="CONTACT_NUMBER",unique=true)
	private Long contactNumber;
	
	@Column(name="ACTIVE_SW")
	private Character activeSwitch;
	
	@Column(name="CREATED_DATE" , updatable = false)
	@CreationTimestamp
	private LocalDate createdDate;
	
	@Column(name="UPDATED_DATE" , insertable = false)
	@UpdateTimestamp
	private LocalDate updatedDate;

}
