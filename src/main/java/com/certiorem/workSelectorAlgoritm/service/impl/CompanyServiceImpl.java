package com.certiorem.workSelectorAlgoritm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certiorem.workSelectorAlgoritm.model.Company;
import com.certiorem.workSelectorAlgoritm.repositories.CompanyRepository;
import com.certiorem.workSelectorAlgoritm.service.CompanyService;

@Service
@Transactional
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Company findByName(String name) {
		return companyRepository.findByName(name);
	}

	@Override
	public List<Company> findAllCompanies() {
		return companyRepository.findAll();
	}

}
