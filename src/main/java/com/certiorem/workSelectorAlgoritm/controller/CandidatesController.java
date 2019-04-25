package com.certiorem.workSelectorAlgoritm.controller;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.certiorem.workSelectorAlgoritm.model.Candidate;
import com.certiorem.workSelectorAlgoritm.service.CandidateService;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
class CandidatesController {

	public static final Logger logger = LoggerFactory.getLogger(CandidatesController.class);

	
	@Autowired
	private CandidateService candidateService;

	
	@RequestMapping("/candidate/{number}")
	String hell(@PathVariable String number) {

		return getCandidateInfo(number);
	}

	private String getCandidateInfo(String number) {
		System.out.println(number);
		Candidate candidate = candidateService.findByNumber(number);
		System.out.println(candidate);
		
		JSONObject jsonCandidates = new JSONObject();
		jsonCandidates.put("Candidate", candidate);
		
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(jsonCandidates.toString()).getAsJsonObject();
		
		return json.toString();
	}


}