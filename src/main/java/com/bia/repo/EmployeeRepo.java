/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bia.repo;

import java.util.List;

import com.bia.domain.Emp;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.cassandra.repository.TypedIdCassandraRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author mdshannan
 */
@Component
public interface EmployeeRepo extends TypedIdCassandraRepository<Emp, String> {
    
	//@Query("SELECT * FROM emp e WHERE e.username = ?1")
	//List<Emp> findAllByUsername(String username);
}
