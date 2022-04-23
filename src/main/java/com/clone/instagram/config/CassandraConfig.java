package com.clone.instagram.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.cassandra.SessionFactory;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.session.init.CompositeKeyspacePopulator;
import org.springframework.data.cassandra.core.cql.session.init.ResourceKeyspacePopulator;
import org.springframework.data.cassandra.core.cql.session.init.SessionFactoryInitializer;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@EnableCassandraRepositories(basePackages = "com.clone.instagram.dao")
public class CassandraConfig extends AbstractCassandraConfiguration {

    @Value("${spring.data.cassandra.keyspaceName}")
    private String keyspace;

    @Value("${spring.data.cassandra.contactPoints}")
    private String contactPoints;

    @Value("${spring.data.cassandra.port}")
    private int port;

    @Override
    protected String getKeyspaceName(){
        return keyspace;
    }

    @Override
    public SchemaAction getSchemaAction(){
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }

    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.clone.instagram.model"};
    }

    @Bean
    SessionFactoryInitializer sessionFactoryInitializer(SessionFactory sessionFactory) {

        SessionFactoryInitializer initializer = new SessionFactoryInitializer();
        initializer.setSessionFactory(sessionFactory);

        ResourceKeyspacePopulator populator1 = new ResourceKeyspacePopulator();
        populator1.setSeparator(";");

        populator1.setScripts(new ClassPathResource("cql/schema.cql"));

        ResourceKeyspacePopulator populator2 = new ResourceKeyspacePopulator();
        populator2.setSeparator("@@");
        populator2.setScripts(new ClassPathResource("cql/data.cql"));

        initializer.setKeyspacePopulator(new CompositeKeyspacePopulator(populator1, populator2));

        return initializer;
    }
}
