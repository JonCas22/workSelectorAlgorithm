package com.certiorem.workSelectorAlgoritm.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "OFFERS")
public class Offer implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "NUM_OFFERED", nullable = false)
	private int numOffered;

	@Column(name = "SALARY", nullable = false)
	private double salary;

	@Column(name = "DURATION", nullable = false)
	private String duration;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@Column(name = "REQUEST", nullable = false)
	private String request;

    @ManyToOne
    @JoinColumn(name="company")
	private Company company;
	
	@Column(name = "UPLOAD_DATE", nullable = false)
	private Date uploadDate;
	
	@Column(name = "CATEGORY_REQUEST", nullable = false)
	private int categoryRequest;
	
	@ManyToMany(mappedBy = "offers")
	private List<Candidate> candidates;

	public Offer() {

	}

	public Offer(String name, int numOffered, double salary, String duration, String description, String request,
			Company company, Date uploadDate, int categoryRequest) {
		this.name = name;
		this.numOffered = numOffered;
		this.salary = salary;
		this.duration = duration;
		this.description = description;
		this.request = request;
		this.company = company;
		this.uploadDate = uploadDate;
		this.categoryRequest = categoryRequest;
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

	public int getNumOffered() {
		return numOffered;
	}

	public void setNumOffered(int numOffered) {
		this.numOffered = numOffered;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public List<Candidate> getCandidates() {
		return candidates;
	}

	public void setCandidates(List<Candidate> candidates) {
		this.candidates = candidates;
	}

	public int getCategoryRequest() {
		return categoryRequest;
	}

	public void setCategoryRequest(int categoryRequest) {
		this.categoryRequest = categoryRequest;
	}

	@Override
	public String toString() {
		return "Offer [id=" + id + ", name=" + name + ", numOffered=" + numOffered + ", salary=" + salary
				+ ", duration=" + duration + ", description=" + description + ", request=" + request
				+ ", offerCandidates=" + candidates + ", uploadDate=" + uploadDate + ", category_request=" + categoryRequest + "]";
	}

}