package com.certiorem.workSelectorAlgoritm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "COMPANIES")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "PHONE", nullable = false)
	private String phone;

	@Column(name = "HEADQUARTERS", nullable = false)
	private String headquarters;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "company")
	private List<Offer> offers;

	public Company() {

	}

	public Company(String name, String email, String phone, String headquarters) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.headquarters = headquarters;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHeadquarters() {
		return headquarters;
	}

	public void setHeadquarters(String headquarters) {
		this.headquarters = headquarters;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	@Override
	public String toString() {
		return "Company [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", headquarters="
				+ headquarters + ", offers=" + offers + "]";
	}

}