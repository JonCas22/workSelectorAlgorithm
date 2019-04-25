package com.certiorem.workSelectorAlgoritm.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.certiorem.workSelectorAlgoritm.model.Company;


@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    Company findByName(String name);

}