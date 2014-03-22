package com.bia.repo.solr;

import com.bia.domain.Emp;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpSolrRepo extends SolrCrudRepository<Emp, String> {

    List<Emp> findByUsername(String username);

}
