package com.certiorem.workSelectorAlgoritm.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CANDIDATES")
public class Candidate implements Comparable<Candidate>, Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "AGE", nullable = false)
	private int age;

	@Column(name = "EXPERIENCE", nullable = false)
	private String experience;

	@Column(name = "PREVIOUS_WORK", nullable = false)
	private String previousWork;

	@ManyToMany
	@JoinTable(name = "candidates_offer", joinColumns = @JoinColumn(name = "candidate_id"), inverseJoinColumns = @JoinColumn(name = "offer_id"))
	private List<Offer> offers;
	
	@Column(name = "NUMBER", nullable = false)
	private String number;
	
	@Column(name = "CATEGORY_WORK", nullable = false)
	private Integer category;
	
	private Integer points;
	
	public Candidate() {
		this.points = 0;
	}	

	public Candidate(String name, int age, String experience, String previousWork, String number,
			Integer category, Integer points) {
		super();
		this.name = name;
		this.age = age;
		this.experience = experience;
		this.previousWork = previousWork;
		this.number = number;
		this.category = category;
		this.points = points;
	}

	@Override
	public int compareTo(Candidate candidate) {
		 return (this.getPoints() > candidate.getPoints() ? -1 : 
	            (this.getPoints() == candidate.getPoints() ? 0 : 1));
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getPreviousWork() {
		return previousWork;
	}

	public void setPreviousWork(String previousWork) {
		this.previousWork = previousWork;
	}

	public List<Offer> getOffers() {
		return offers;
	}

	public void setOffers(List<Offer> offers) {
		this.offers = offers;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}
	
	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}
	
	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}
	
	@Override
	public String toString() {
		return "Candidates [id=" + id + ", name=" + name + ", age=" + age + ", experience=" + experience
				+ ", previousWork=" + previousWork + ", number=" + number + ", Work_Category=" + category + "]";
	}
	

}
