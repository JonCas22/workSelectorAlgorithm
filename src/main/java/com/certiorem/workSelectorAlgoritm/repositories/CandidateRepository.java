package com.certiorem.workSelectorAlgoritm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certiorem.workSelectorAlgoritm.model.Candidate;


@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {

    Candidate findByNumber(String number);

}