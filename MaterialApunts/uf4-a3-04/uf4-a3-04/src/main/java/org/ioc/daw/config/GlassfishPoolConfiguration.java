package org.ioc.daw.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@PropertySource(value = {"glassfish.properties","hibernate.properties" })
@Import(value = {HibernateConfiguration.class})
public class GlassfishPoolConfiguration {

    @Autowired
    private Environment environment;

    @Bean(name = "jndiDataSource")
    public DataSource dataSource() {
        String jndiName = environment.getRequiredProperty("jndi.socioc");
        JndiDataSourceLookup lookup = new JndiDataSourceLookup();
        lookup.setResourceRef(true);
        return lookup.getDataSource(jndiName);
    }
}