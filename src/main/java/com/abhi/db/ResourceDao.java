package com.abhi.db;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

import com.abhi.model.Candidate;
import com.abhi.model.Employee;

public interface ResourceDao {

	boolean saveEmployee(Employee employee);

	boolean updateEmployee(Employee employee);

	Employee retrieveEmployee(int employeeId);

	Employee loginEmployee(Employee employee);

	Candidate saveCandidate(Candidate candidate); // return statement is required as

	boolean updateCandidateDetails(Candidate candidate);

	boolean updateCandidateAssessments(Candidate candidate);

	Candidate retrieveCandidate(int candidateId);

	boolean saveCandidateForEmployee(int employeeId, int candidateId);

	List<Integer> retrieveCandidatesForaEmployee(int employeeId);

	List<List<Integer>> retrieveAllCandidatesForaEmployee(int employeeId);

	List<Candidate> retrieveAllCandidatesForaEmployeeUsingSUBQRY(int employeeId);

	Candidate retrieveOneCandidateForaEmployeeUsingSUBQRY(int employeeId, int candidateId);

	void setJdbcTemplate(JdbcTemplate template);

	String INSERT_EMPLOYEE_QRY = "INSERT INTO EMPLOYEES VALUES(?,?,?)";

	String FIND_EMPLOYEE_BY_ID_QRY = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=?";

	String LOGIN_EMPLOYEE_BY_ID_AND_PASSWORD_QRY = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=? AND EMPLOYEE_PASSWORD=?";

	String UPDATE_EMPLOYEE_DETAILS_QRY = "UPDATE EMPLOYEES SET EMPLOYEE_NAME=?, EMPLOYEE_PASSWORD=? WHERE EMPLOYEE_ID=?";

	String INSERT_CANDIDATE_QRY = "INSERT INTO CANDIDATES VALUES(?,?,?,?,?,?,?)";

	String UPDATE_CANDIDATE_DETAILS_QRY = "UPDATE CANDIDATES SET NAME=?, DOMAIN=?, EXPERIENCE=? WHERE CANDIDATE_ID=?";

	String UPDATE_CANDIDATE_ASSESSMENT_QRY = "UPDATE CANDIDATES SET ASSESSMENT1 = ?, ASSESSMENT2 = ?, ASSESSMENT3 = ? WHERE CANDIDATE_ID=?";

	String DELETE_CANDIDATE_QRY = "DELETE FROM CANDIDATE WHERE CANDIDATE_ID=?";

	String FIND_CANDIDATE_BY_ID_QRY = "SELECT * FROM CANDIDATEs WHERE CANDIDATE_ID=?";

	String LOGIN_QRY = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID=? AND EMPLOYEE_PASSWORD=?";

	String INSERT_CANDIADTES_FOR_A_EMPLOYEE_QRY = "INSERT INTO EMPLOYEE_CANDIDATE_MAPPING VALUES(?, ?, ?)";

	String RETRIEVE_ALL_CANDIADTES_FOR_A_EMPLOYEE = "SELECT * FROM EMPLOYEE_CANDIDATE_MAPPING WHERE E_ID = ? ORDER BY E_ID";

	String RETRIEVE_ALL_CANDIADTES_FOR_A_EMPLOYEE_SUBQRY = "select * from candidates where candidate_id in (" +

			"	select c_id as candidate_id from employees e JOIN employee_candidate_mapping ec on e.employee_id = ec.e_id where e.employee_id = ? );";

	String RETRIEVE_ONE_CANDIADTE_FOR_A_EMPLOYEE_SUBQRY = "select * from candidates where candidate_id = (select c_id as candidate_id from employees e JOIN employee_candidate_mapping ec on e.employee_id = ec.e_id where e.employee_id = ? and c_id=?)";

}