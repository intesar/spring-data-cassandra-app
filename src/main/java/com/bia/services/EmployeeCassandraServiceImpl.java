package com.bia.services;

import com.bia.domain.Emp;
import com.bia.repo.cassandra.EmpCassandraRepo;
import com.bia.repo.solr.EmpSolrRepo;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service(value = "cassandraService")
@Transactional
public class EmployeeCassandraServiceImpl {

    @Autowired
    @Qualifier(value = "empCassandraRepo")
    private EmpCassandraRepo empCassandraRepo;

    @Autowired
    @Qualifier(value = "empSolrRepo")
    private EmpSolrRepo empSolrRepo;

    public List<Emp> findAllEmployees() {
        List<Emp> list = new ArrayList<>();
        for (Emp emp : empCassandraRepo.findAll()) {
            list.add(emp);
        }
        return list;
    }

    public Emp findById(String id) {
        return this.empCassandraRepo.findOne(id);
    }

    public List<Emp> findByUsername(String username) {
        return this.empSolrRepo.findByUsername(username);
    }

    public void saveEmployee(Emp emp) {
        this.empCassandraRepo.save(emp);
        this.empSolrRepo.save(emp);
    }

    public void saveEmployee(List<Emp> emps) {
        this.empCassandraRepo.save(emps);
    }

    public void deleteEmployee(Emp emp) {
        this.empCassandraRepo.delete(emp);
        this.empSolrRepo.delete(emp);
    }

    public void deleteAll() {
        for (Emp emp : findAllEmployees()) {
            deleteEmployee(emp);
        }
    }
}
