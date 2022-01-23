package com.abhi.model;

import java.util.HashMap;

import java.util.Map;

public class Candidate {

	int candidateId;

	String candidateName;

	String domain;

	double experience;

	boolean asm1;

	boolean asm2;

	boolean asm3;

	public Candidate() {

		super();

	}

	public Candidate(int candidateId, String candidateName, String domain, double experience) {

		super();

		this.candidateId = candidateId;

		this.candidateName = candidateName;

		this.domain = domain;

		this.experience = experience;

	}

	public int getCandidateId() {

		return candidateId;

	}

	public void setCandidateId(int candidateId) {

		this.candidateId = candidateId;

	}

	public String getCandidateName() {

		return candidateName;

	}

	public void setCandidateName(String candidateName) {

		this.candidateName = candidateName;

	}

	public String getDomain() {

		return domain;

	}

	public void setDomain(String domain) {

		this.domain = domain;

	}

	public double getExperience() {

		return experience;

	}

	public void setExperience(double experience) {

		this.experience = experience;

	}

	public boolean isAsm1() {

		return asm1;

	}

	public void setAsm1(boolean asm1) {

		this.asm1 = asm1;

	}

	public boolean isAsm2() {

		return asm2;

	}

	public void setAsm2(boolean asm2) {

		this.asm2 = asm2;

	}

	public boolean isAsm3() {

		return asm3;

	}

	public void setAsm3(boolean asm3) {

		this.asm3 = asm3;

	}

	@Override

	public String toString() {

		return "Candidate [candidateId=" + candidateId + ", candidateName=" + candidateName + ", domain=" + domain

				+ ", experience=" + experience + ", asm1=" + asm1 + ", asm2=" + asm2 + ", asm3=" + asm3 + "]";

	}

}
