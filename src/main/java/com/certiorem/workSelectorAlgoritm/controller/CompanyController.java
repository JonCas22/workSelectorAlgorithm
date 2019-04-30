package com.certiorem.workSelectorAlgoritm.controller;

import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.certiorem.workSelectorAlgoritm.algoritm.SortCandidates;
import com.certiorem.workSelectorAlgoritm.model.Candidate;
import com.certiorem.workSelectorAlgoritm.model.Company;
import com.certiorem.workSelectorAlgoritm.model.Offer;
import com.certiorem.workSelectorAlgoritm.service.CompanyService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
class CompanyController {

	public static final Logger logger = LoggerFactory.getLogger(CompanyController.class);

	@Autowired
	private CompanyService companyService;

	@Autowired
	private SortCandidates sortCandidate;

	@RequestMapping("/company/{name}")
	String companyInfo(@PathVariable String name, HttpServletRequest request) {
		
		return buildCompletJSON(request, name);

	}

	@RequestMapping(value = "/company")
	public String listAllCompanies() {
		List<Company> companies = companyService.findAllCompanies();
		System.out.println("JON - companies size: " + companies.size());
		System.out.println(companies);
		return buildAllCompaniesJSON(companies);
	}

	List<Company> getAllCompanies() {
		return companyService.findAllCompanies();
	}
	
	private JSONObject getHeadersInfo(HttpServletRequest request) {

		JSONObject jsonObjectHeades = new JSONObject();

        Enumeration<?> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            String value = request.getHeader(key);
            jsonObjectHeades.put(key, value);
        }

        return jsonObjectHeades;
    }
	
	public JSONObject getCookies (HttpServletRequest request)
	{
	  Cookie [] cookies = request.getCookies ();
	  JSONObject jsonObjectCookies = new JSONObject();
	  for (int i = 0; cookies != null && i < cookies.length; i++) {
	    Cookie cookie = cookies [i];
	    if (cookie != null) {
	      String name = cookie.getName ();
	       jsonObjectCookies.put(name, cookie);
	    }
	  }
	  return jsonObjectCookies;
	}
	
	private String buildCompletJSON(HttpServletRequest request, String name) {
		
		JSONObject jsonComplete = new JSONObject();
		jsonComplete.put("companyInfo", getCompanyInfo(name));
		jsonComplete.put("cookies", getCookies(request));
		jsonComplete.put("headers", getHeadersInfo(request));

		return jsonComplete.toString();
	}

	private String buildAllCompaniesJSON(List<Company> companiesList) {
		JSONArray jsonCompaniesList = new JSONArray();
		for (Company company : companiesList) {
			jsonCompaniesList.put(getCompanyInfo(company.getName()));
		}
		JSONObject jsonCompanies = new JSONObject();
		jsonCompanies.put("Companies", jsonCompaniesList);

		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(jsonCompanies.toString()).getAsJsonObject();

		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String prettyJson = gson.toJson(json);

		return prettyJson;
	}

	private JSONObject getCompanyInfo(String companyName) {

		Company company = companyService.findByName(companyName);
		
		System.out.println("Company: " + company);
		
		JSONObject companyJSON = new JSONObject();
		
		if(company!=null) {
			sortCandidate.sort(company);
			companyJSON.put("CompanyName", company.getName());
			companyJSON.put("CompanyEmail", company.getEmail());
			companyJSON.put("CompanyOfferList", getCompanyOffersArray(company));
		}else{
			companyJSON.put("CompanyName", "No company with this name available");
			
		}
		return companyJSON;
		
	}



	private JSONArray getCompanyOffersArray(Company company) {
		JSONArray companyOffersArray = new JSONArray();
		JSONObject offerJSON = null;
		for (Offer offer : company.getOffers()) {
			offerJSON = new JSONObject();
			offerJSON.put("offerName", offer.getName());
			offerJSON.put("offerSalary", offer.getSalary());
			offerJSON.put("candidates", getOfferCandidatesArray(offer));

			companyOffersArray.put(offerJSON);
		}
		return companyOffersArray;
	}

	private JSONArray getOfferCandidatesArray(Offer offer) {
		JSONArray offersCandidatesArray = new JSONArray();
		JSONObject candidatesJSON = null;
		for (Candidate candidates : offer.getCandidates()) {
			candidatesJSON = new JSONObject();
			candidatesJSON.put("candidateName", candidates.getName());
			candidatesJSON.put("candidateAge", candidates.getAge());
			candidatesJSON.put("candidateNum", candidates.getNumber());
			candidatesJSON.put("candidatePoints", candidates.getPoints());

			offersCandidatesArray.put(candidatesJSON);
		}
		return offersCandidatesArray;
	}

}