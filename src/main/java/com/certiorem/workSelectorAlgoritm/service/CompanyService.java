package com.certiorem.workSelectorAlgoritm.service;

import java.util.List;

import com.certiorem.workSelectorAlgoritm.model.Company;

public interface CompanyService {
	
	Company findByName(String name);

	List<Company> findAllCompanies();
}
