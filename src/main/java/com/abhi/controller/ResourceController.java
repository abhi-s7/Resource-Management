package com.abhi.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.abhi.model.Candidate;
import com.abhi.service.ResourceService;

@Controller

@SessionAttributes("employeeId-session")

public class ResourceController {

	private ResourceService service = new ResourceService();

	@RequestMapping(value = "/addCandidate", method = RequestMethod.GET)

	public String showAddCustomerPage(HttpSession session) {

		int employeeId = (Integer) session.getAttribute("employeeId-session");

		System.out.println("User id is  => " + employeeId);

		return "addCandidate";// this sends the request to the login page

	}

	@RequestMapping(value = "/addCandidate", method = RequestMethod.POST)

	public ModelAndView processAddCandidatePage(HttpSession session, @RequestParam("candidateId") int candidateId,

			@RequestParam("candidateName") String candidateName, @RequestParam("domain") String domain,

			@RequestParam("experience") double experience, Model model) {

		int employeeId = (Integer) session.getAttribute("employeeId-session");

		boolean addResult = service.addCandidate(employeeId, candidateId, candidateName, domain, experience);

		if (addResult == false) {

			model.addAttribute("msg", "Error while adding the candidate...");

			return new ModelAndView("addCandidate");

		}

		return new ModelAndView("redirect:addCandidate");// this sends the request to the login page

	}

	@RequestMapping(value = "/fetchCandidate", method = RequestMethod.GET)

	public String showFetchCandidatePage(HttpSession session, Model model) {

		return "fetchCandidate";

	}

	@RequestMapping(value = "/fetchCandidate", method = RequestMethod.POST)

	public ModelAndView processFetchCandidatePage(HttpSession session, @RequestParam("candidateId") int candidateId,
			Model model) {

		int employeeId = (Integer) session.getAttribute("employeeId-session");

		Candidate candidate = service.getCandidateDetails(employeeId, candidateId);

		if (candidate == null) {

			model.addAttribute("msg", "No Such Candidate exist");

			return new ModelAndView("fetchCandidate");

		}

		model.addAttribute("modelAttribute", candidate);

		/*
		 * model.addAttribute("candidateId", candidateId);
		 * 
		 * model.addAttribute("candidateName", candidate.getCandidateName());
		 * 
		 * model.addAttribute("domain", candidate.getDomain());
		 * 
		 * model.addAttribute("experience", candidate.getExperience());
		 * 
		 * model.addAttribute("asm1", candidate.isAsm1());
		 * 
		 * model.addAttribute("asm2", candidate.isAsm2());
		 * 
		 * model.addAttribute("asm3", candidate.isAsm3());
		 */
		return new ModelAndView("updateCandidate");

	}

	@RequestMapping(value = "/updateCandidate", method = RequestMethod.GET)

	public ModelAndView showUpdateCustomerPage(HttpSession session, Model model) {

		int employeeId = (Integer) session.getAttribute("employeeId-session");

		System.out.println("User id is  => " + employeeId);

// service.retrieveCustomerDetails(employeeId, ) 

		return new ModelAndView("updateCandidate");// this sends the request to the login page

	}

	@RequestMapping(value = "/updateCandidate", method = RequestMethod.POST)

	/*
	 * public String processUpdateCustomerPage(HttpSession
	 * session, @RequestParam("candidateId") int candidateId,
	 * 
	 * @RequestParam("candidateName") String candidateName, @RequestParam("domain")
	 * String domain,
	 * 
	 * @RequestParam("experience") double experience, @RequestParam("check1")
	 * boolean check1,
	 * 
	 * @RequestParam("check2") boolean check2, @RequestParam("check3") boolean
	 * check3, Model model) {
	 * 
	 */ public ModelAndView processUpdateCandidatePage(HttpSession session, @ModelAttribute Candidate candidate,
			Model model) {

		int employeeId = (Integer) session.getAttribute("employeeId-session");

		/*
		 * model.addAttribute("candidateId", candidate.getCandidateId());
		 * 
		 * model.addAttribute("candidateName", candidate.getCandidateName());
		 * 
		 * model.addAttribute("domain", candidate.getDomain());
		 * 
		 * model.addAttribute("experience", candidate.getExperience());
		 * 
		 * model.addAttribute("asm1", candidate.isAsm1());
		 * 
		 * model.addAttribute("asm2", candidate.isAsm2());
		 * 
		 * model.addAttribute("asm3", candidate.isAsm3());
		 */
		
		boolean isValid = service.validateAssessment(candidate);

		if (!isValid) {

			model.addAttribute("msg", "Assessments are not correctly selected");
			model.addAttribute("modelAttribute", candidate);
			return new ModelAndView("updateCandidate");

		}

		boolean isUpdated = service.updateCandidateDetails(candidate);

		if (!isUpdated) {

			model.addAttribute("msg", "Error While updating");

			return new ModelAndView("updateCandidate");

		}
		model.addAttribute("msg", "Details of candidate: " + candidate.getCandidateName() + ", updated successfully.");
		return new ModelAndView("home");// this sends the request to the login page

	}

	@RequestMapping(value = "/viewAll", method = RequestMethod.GET)

	public ModelAndView viewAllCandidates(HttpSession session, Model model)

			throws JsonGenerationException, JsonMappingException, IOException {

		int employeeId = // 893980;//789090;

				(Integer) session.getAttribute("employeeId-session");

		List<Candidate> allCandidates = service.getAllCandidates(employeeId);

		if (allCandidates == null || allCandidates.isEmpty()) {

			model.addAttribute("msg", "No Candidates available");

			return new ModelAndView("viewAll");

		}

		ObjectMapper mapper = new ObjectMapper();

		model.addAttribute("candidateList", mapper.writeValueAsString(allCandidates));

		return new ModelAndView("viewAll");

	}

}