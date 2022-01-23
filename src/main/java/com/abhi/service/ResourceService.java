package com.abhi.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.abhi.db.ResourceDao;
import com.abhi.model.Candidate;

public class ResourceService {

	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");

	ResourceDao dao = (ResourceDao) ctx.getBean("daoBean");

	public boolean addCandidate(int employeeId, int candidateId, String candidateName, String domain,

			double experience) {

// TODO Auto-generated method stub 

		Candidate candidate = new Candidate(candidateId, candidateName, domain, experience);

		Candidate saveCandidate = dao.saveCandidate(candidate);

		if (saveCandidate == null) {

			return false;

		}

// save candidate to candidate-employee-mapping 

		boolean saveCandidateForEmployee = dao.saveCandidateForEmployee(employeeId, candidateId);

		return saveCandidateForEmployee;

	}

	public List<Candidate> getAllCandidates(int employeeId) {

// TODO Auto-generated method stub 

		List<Candidate> allCandidates = dao.retrieveAllCandidatesForaEmployeeUsingSUBQRY(employeeId);

		return allCandidates;

	}

	public Candidate getCandidateDetails(int employeeId, int candidateId) {

// TODO Auto-generated method stub 

		Candidate retrievedCandidate = dao.retrieveOneCandidateForaEmployeeUsingSUBQRY(employeeId, candidateId);

		return retrievedCandidate;

	}

	public boolean validateAssessment(Candidate candidate) {

		boolean check1 = candidate.isAsm1();

		boolean check2 = candidate.isAsm2();

		boolean check3 = candidate.isAsm3();

		boolean checkArray[] = { check1, check2, check3 };

		boolean lastBool = true;

		for (boolean currBool : checkArray) {

// case 1 lastBool = T and currBool = F => set lastBool = F 

			if (lastBool && !currBool)

				lastBool = false;

// case 2 lastBool = F and currBool = T => invalid array elements return false 

			if (!lastBool && currBool)

				return false;

// case 3 lastBool and currBool = True => continue the array 

// case 4 lastBool and currBool = False => continue the array 

		}

// if there is no discrepancy then the array is correct and return true 

		return true;

	}

	public boolean updateCandidateDetails(Candidate candidate) {

		return dao.updateCandidateAssessments(candidate);

	}

}
