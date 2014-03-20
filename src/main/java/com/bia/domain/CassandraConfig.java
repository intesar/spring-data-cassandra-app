package com.bia.domain;

import org.springframework.cassandra.core.CqlOperations;
import org.springframework.cassandra.core.CqlTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages="com.bia.repo")
public class CassandraConfig extends AbstractCassandraConfiguration {

	// run the below commends on cql cli.
	//create keyspace demo with replication = {'class':'SimpleStrategy', 'replication_factor':1} ;
	//use demo ;
	//CREATE COLUMNFAMILY emp ( id varchar PRIMARY KEY, username varchar);
	
    @Override
    public String getKeyspaceName() {
        return "proj";
    }
    
    public SchemaAction getSchemaAction() {
		return SchemaAction.RECREATE_DROP_UNUSED;
	}
    
    //@Bean
    //public CqlOperations getCqlTemplate() throws Exception {
    	//CqlTemplate ct ;
    //    return new CqlTemplate(this.session().getObject());
    //}
}