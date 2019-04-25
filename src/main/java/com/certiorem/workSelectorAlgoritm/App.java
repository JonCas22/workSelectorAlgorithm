package com.certiorem.workSelectorAlgoritm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

import com.certiorem.workSelectorAlgoritm.configuration.JpaConfiguration;
import com.certiorem.workSelectorAlgoritm.hibernate.HibernateUtil;
import com.certiorem.workSelectorAlgoritm.model.Candidate;
import com.certiorem.workSelectorAlgoritm.model.Company;
import com.certiorem.workSelectorAlgoritm.model.Offer;

@SpringBootApplication
@ComponentScan(basePackageClasses = {App.class, JpaConfiguration.class})
public class App extends SpringBootServletInitializer {

	
	public static void main(String[] args) {
		BasicConfigurator.configure();
		SpringApplication.run(App.class, args);
		
		
		
//		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		Date date = new Date();
//		System.out.println(dateFormat.format(date));
//		
//		List<Offer> offers = new ArrayList<Offer>();
//		List<Candidate> candidates = new ArrayList <Candidate>();
//
//		Company company = new Company("Google", "google@gmail.com", "945896587485", "Madrid");
//		
//		Offer offer3 = new Offer("programador", 2, 1500, "1 año", "", "nada", company, date, 1);
//		Offer offer4 = new Offer("programador", 8, 1100, "2 años", "", "nada", company, date, 1);
//		
//		Candidate candidate1 = new Candidate("Jon", 20, "null", "Student", "658795874", 1, 20);
//		Candidate candidate2 = new Candidate("Xavi", 23, "Programador", "Programador", "658741258", 1, 25);
//		
//		candidates.add(candidate2);
//		candidates.add(candidate1);
//		
//		offers.add(offer3);
//		offers.add(offer4);
//
//		company.setOffers(offers);
//		offer3.setCandidates(candidates);
//		offer4.setCandidates(candidates);
//		candidate1.setOffers(offers);
//		candidate2.setOffers(offers);
		

		
		//offer.setCompany(company);
		// offer2.setCompany(company);
		//List<Offer> offers = new ArrayList<Offer>();
		//List<Candidates> candidates = new ArrayList <Candidates>();

		//candidate1.setOffer(offer);
		//candidate2.setOffer(offer);
		
//		candidates.add(candidate1);
//		candidates.add(candidate2);

		//offer.setCandidates(candidates);
		// offer2.setCandidates(candidates);
		
		//offers.add(offer);
		// offers.add(offer2);

//		company.setOffers(offers);
//
//		Transaction transaction = null;
//		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
//			transaction = session.beginTransaction();
//
//			session.save(candidate1);
//			session.save(candidate2);
//			
//			session.save(company);
//			
//			session.save(offer3);
//			session.save(offer4);
			
			


//			Company companyReaded = (Company) session.load(Company.class, 33L);
//			System.out.println("Company: " + companyReaded);
//			for (Offer offerIterable : companyReaded.getOffers()) {
//				System.out.println("\t" + offerIterable);
//				System.out.println("\tCandidates: ");
//				for (Candidate candidate: offerIterable.getCandidates()) {
//					System.out.println("\t\t" + candidate);
//				}
//			}
//
//			transaction.commit();
//		} catch (Exception e) {
//			if (transaction != null) {
//				transaction.rollback();
//			}
//			e.printStackTrace();
//		}
//		JSONObject object = new JSONObject();
//		object.put("JSON", company);
//		System.out.println(object);
//		
//	}
	
	
	
	}
}


