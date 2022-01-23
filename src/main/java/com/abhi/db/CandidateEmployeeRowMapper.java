package com.abhi.db;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.ArrayList;

import java.util.List;

import org.springframework.jdbc.core.RowMapper;

public class CandidateEmployeeRowMapper implements RowMapper<List<Integer>> {

	public List<Integer> mapRow(ResultSet rs, int rn) throws SQLException {

		List<Integer> ls = new ArrayList<>();

		ls.add(rs.getInt(1));

		ls.add(rs.getInt(2));

		return ls;

	}

}