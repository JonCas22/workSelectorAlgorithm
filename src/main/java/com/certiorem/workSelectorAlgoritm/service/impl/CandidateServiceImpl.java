package com.certiorem.workSelectorAlgoritm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.certiorem.workSelectorAlgoritm.model.Candidate;
import com.certiorem.workSelectorAlgoritm.repositories.CandidateRepository;
import com.certiorem.workSelectorAlgoritm.service.CandidateService;

@Service
@Transactional
public class CandidateServiceImpl implements CandidateService {

	@Autowired
	private CandidateRepository candidateRepository;
	
	@Override
	public Candidate findByNumber(String number) {
		return candidateRepository.findByNumber(number);
	}



}
