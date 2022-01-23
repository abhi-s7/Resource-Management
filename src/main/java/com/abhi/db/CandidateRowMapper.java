package com.abhi.db;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.abhi.model.Candidate;

public class CandidateRowMapper implements RowMapper<Candidate> {

	public Candidate mapRow(ResultSet rs, int rn) throws SQLException {

		Candidate candidate = new Candidate();

		candidate.setCandidateId(rs.getInt(1));

		candidate.setCandidateName(rs.getString(2));

		candidate.setDomain(rs.getString(3));

		candidate.setExperience(rs.getDouble(4));

		candidate.setAsm1(rs.getBoolean(5));

		candidate.setAsm2(rs.getBoolean(6));

		candidate.setAsm3(rs.getBoolean(7));

		return candidate;

	}

}