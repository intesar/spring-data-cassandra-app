package com.bia.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.config.java.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages="com.bia.repo")
public class CassandraConfig extends AbstractCassandraConfiguration {

	// run the below commends on cql cli.
	// create keyspace vchest with replication = {'class':'SimpleStrategy', 'replication_factor':1} ;
	// use demo ;
	// CREATE COLUMNFAMILY emp ( id varchar PRIMARY KEY, username varchar, joinDate timestamp, storageSize double, content blob);
	
	@Value("${keyspace}")
	private String keyspace;
	
    @Override
    public String getKeyspaceName() {
        return this.keyspace;
    }
    
    @Override
    public SchemaAction getSchemaAction() {
		return SchemaAction.RECREATE_DROP_UNUSED;
	}
    
    @Override
    public String[] getEntityBasePackages() {
    	return new String[] {"com.bia.domain"};
    }

}