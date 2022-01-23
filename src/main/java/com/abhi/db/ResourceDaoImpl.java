package com.abhi.db;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.abhi.model.Candidate;
import com.abhi.model.Employee;

public class ResourceDaoImpl implements ResourceDao {

	private JdbcTemplate jdbcTemplate;

	@Override

	public Candidate saveCandidate(Candidate candidate) {

// TODO Auto-generated method stub 

		try {

			int r;

			Object[] arr = new Object[7];

			arr[0] = candidate.getCandidateId();

			arr[1] = candidate.getCandidateName();

			arr[2] = candidate.getDomain();

			arr[3] = candidate.getExperience();

			arr[4] = candidate.isAsm1();

			arr[5] = candidate.isAsm2();

			arr[6] = candidate.isAsm3();

			r = this.jdbcTemplate.update(INSERT_CANDIDATE_QRY, arr);

			if (r > 0) {

				return candidate;

			} else {

				return null;

			}

		} catch (Throwable e) {

			e.printStackTrace();

			return null;

		}

	}

	@Override

	public boolean updateEmployee(Employee employee) {

		try {

			int r;

			Object[] arr = new Object[3];

			arr[0] = employee.getEmployeeName();

			arr[1] = employee.getPassword();

			arr[2] = employee.getEmployeeId(); // since third parameter is employee id

			r = this.jdbcTemplate.update(INSERT_EMPLOYEE_QRY, arr);

			if (r > 0) {

				return true;

			} else {

				return false;

			}

		} catch (Throwable e) {

			e.printStackTrace();

			return false;

		}

	}

	@Override

	public Employee retrieveEmployee(int employeeId) {

		Object[] arr = new Object[] { employeeId };

		try {

			Employee emp = this.jdbcTemplate.queryForObject(FIND_EMPLOYEE_BY_ID_QRY, arr, new EmployeeRowMapper());

			return emp;

		} catch (Throwable t) {

			t.printStackTrace();

			return null;

		}

	}

	@Override

	public boolean updateCandidateDetails(Candidate candidate) {

		try {

			int r;

			Object[] arr = new Object[4];

			arr[0] = candidate.getCandidateName();

			arr[1] = candidate.getDomain();

			arr[2] = candidate.getExperience();

// since last parameter is candidate id 

			arr[3] = candidate.getCandidateId();

			r = this.jdbcTemplate.update(UPDATE_CANDIDATE_DETAILS_QRY, arr);

			if (r > 0) {

				return true;

			} else {

				return false;

			}

		} catch (Throwable e) {

			e.printStackTrace();

			return false;

		}

	}

	@Override

	public boolean updateCandidateAssessments(Candidate candidate) {

		try {

			System.out.println("Candidate in update candidate is " + candidate);

			int r;

			Object[] arr = new Object[4];

			arr[0] = candidate.isAsm1();

			arr[1] = candidate.isAsm2();

			arr[2] = candidate.isAsm3();

// since last parameter is candidate id 

			arr[3] = candidate.getCandidateId();

			r = this.jdbcTemplate.update(UPDATE_CANDIDATE_ASSESSMENT_QRY, arr);

			if (r > 0) {

				return true;

			} else {

				return false;

			}

		} catch (Throwable e) {

			e.printStackTrace();

			return false;

		}

	}

	@Override

	public Candidate retrieveCandidate(int candidateId) {

		Object[] arr = new Object[] { candidateId };

		try {

			Candidate candidate = this.jdbcTemplate.queryForObject(FIND_CANDIDATE_BY_ID_QRY, arr,

					new CandidateRowMapper());

			return candidate;

		} catch (Throwable t) {

			t.printStackTrace();

			return null;

		}

	}

	@Override

	public List<List<Integer>> retrieveAllCandidatesForaEmployee(int employeeId) {

		Object[] arr = new Object[] { employeeId };

		try {

			@SuppressWarnings("unchecked")

			List<List<Integer>> candidateList = this.jdbcTemplate.query(RETRIEVE_ALL_CANDIADTES_FOR_A_EMPLOYEE, arr,

					new CandidateEmployeeRowMapper());

			return candidateList;

		} catch (Throwable t) {

			t.printStackTrace();

			return null;

		}

	}

	@Override

	public void setJdbcTemplate(JdbcTemplate template) {

		this.jdbcTemplate = template;

	}

	@Override

	public boolean saveEmployee(Employee employee) {

// TODO Auto-generated method stub 

		try {

			int r;

			Object[] arr = new Object[3];

			arr[0] = employee.getEmployeeId();

			arr[1] = employee.getEmployeeName();

			arr[2] = employee.getPassword();

			r = this.jdbcTemplate.update(INSERT_EMPLOYEE_QRY, arr);

			if (r > 0) {

				return true;

			} else {

				return false;

			}

		} catch (Throwable e) {

			e.printStackTrace();

			return false;

		}

	}

	@Override

	public boolean saveCandidateForEmployee(int employeeId, int candidateId) {

		try {

			int r;

			Object[] arr = new Object[] { 0, employeeId, candidateId };

			r = this.jdbcTemplate.update(INSERT_CANDIADTES_FOR_A_EMPLOYEE_QRY, arr);

			if (r > 0) {

				return true;

			} else {

				return false;

			}

		} catch (Throwable e) {

			e.printStackTrace();

			return false;

		}

	}

	@Override

	public List<Integer> retrieveCandidatesForaEmployee(int employeeId) {

		Object[] arr = new Object[] { employeeId };

		try {

			@SuppressWarnings("unchecked")

			List<Integer> ec = this.jdbcTemplate.queryForObject("SELECT * FROM EMPLOYEE_CANDIDATE_MAPPING WHERE E_ID=?",

					arr, new CandidateEmployeeRowMapper());

			return ec;

		} catch (Throwable t) {

			t.printStackTrace();

			return null;

		}

	}

	@Override

	public List<Candidate> retrieveAllCandidatesForaEmployeeUsingSUBQRY(int employeeId) {

// 

		Object[] arr = new Object[] { employeeId };

		try {

			@SuppressWarnings("unchecked")

			List<Candidate> candidateList = this.jdbcTemplate.query(RETRIEVE_ALL_CANDIADTES_FOR_A_EMPLOYEE_SUBQRY, arr,

					new CandidateRowMapper());

			return candidateList;

		} catch (Throwable t) {

			t.printStackTrace();

			return null;

		}

	}

	@Override

	public Employee loginEmployee(Employee employee) {

		Object[] arr = new Object[] { employee.getEmployeeId(), employee.getPassword() };

		try {

			Employee emp = this.jdbcTemplate.queryForObject(LOGIN_QRY, arr, new EmployeeRowMapper());

			return emp;

		} catch (Throwable t) {

			t.printStackTrace();

			return null;

		}

	}

	@Override

	public Candidate retrieveOneCandidateForaEmployeeUsingSUBQRY(int employeeId, int candidateId) {

		Object[] arr = new Object[] { employeeId, candidateId };

		try {

			Candidate candidate = this.jdbcTemplate.queryForObject(RETRIEVE_ONE_CANDIADTE_FOR_A_EMPLOYEE_SUBQRY, arr,

					new CandidateRowMapper());

			return candidate;

		} catch (Throwable t) {

			t.printStackTrace();

			return null;

		}

	}

}