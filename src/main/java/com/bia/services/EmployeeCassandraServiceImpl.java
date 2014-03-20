package com.bia.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cassandra.core.CqlOperations;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.data.cassandra.repository.support.BasicMapId;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bia.domain.Emp;
import com.bia.repo.EmployeeRepo;

@Service(value = "cassandraService")
@Transactional
public class EmployeeCassandraServiceImpl {

	@Autowired
	EmployeeRepo repo;
	
	//@Autowired
	//protected CassandraOperations template;

	public List<Emp> findAllEmployees() {
		// return Employee.findAllEmployees();
		List<Emp> list = new ArrayList<Emp>();
		for (Emp emp : repo.findAll()) {
			list.add(emp);
		}
		return list;
	}
	
	public Emp findById(String id) {
		//return this.repo.findOne(new BasicMapId().with("id", id));
		return this.repo.findOne(id);
	}
    
	public List<Emp> findByUsername(String username) {
		String cql = "select count(*) from emp where username=" + username;
		//List<Emp> list = template.queryForObject(cql, List.class);
		//return list;//this.repo.findAllByUsername(username);
		//return this.template.select(cql, Emp.class);
		return null;
	}
	
	public void saveEmployee(Emp employee) {
		this.repo.save(employee);
	}
	
	public void saveEmployee(List<Emp> employee) {
		this.repo.save(employee);
	}

	public void deleteEmployee(Emp emp) {
		this.repo.delete(emp);
	}
}
