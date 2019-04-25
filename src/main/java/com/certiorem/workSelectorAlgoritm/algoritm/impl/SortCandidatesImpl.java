package com.certiorem.workSelectorAlgoritm.algoritm.impl;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.certiorem.workSelectorAlgoritm.algoritm.SortCandidates;
import com.certiorem.workSelectorAlgoritm.model.Candidate;
import com.certiorem.workSelectorAlgoritm.model.Company;
import com.certiorem.workSelectorAlgoritm.model.Offer;

@Service
public class SortCandidatesImpl implements SortCandidates {

	public void sort(Company company) {
		Integer points;
		List<Candidate> offerCandidates = null;
		for (Offer offer : company.getOffers()) {
			offerCandidates = offer.getCandidates();
			for (Candidate candidate : offerCandidates) {
				points = 0;
				points += getPointsByAge(candidate);
				points += getPointsByCategory(offer, candidate);
				
				candidate.setPoints(points);
			}
			Collections.sort(offerCandidates);
			offer.setCandidates(offerCandidates);
		}
	}

	private Integer getPointsByAge(Candidate candidate) {
		int cAge = candidate.getAge();
		int points = 0;
		if (cAge < 20 || cAge > 40) {
			points += 5;
		} else if (cAge >= 20 && cAge <= 30) {
			points += 10;
		} else if (cAge > 30 && cAge <= 40) {
			points += 8;
		} else {
			points += 0;
		}
		return points;
	}

	private Integer getPointsByCategory(Offer offer, Candidate candidate) {
		System.out.println("JON - getPointsByCategory, offer: " + offer);
		System.out.println("JON - getPointsByCategory, candidate: " + candidate);
		if (candidate.getCategory() == offer.getCategoryRequest()) {
			return 10;
		}
		return 0;
	}

}
