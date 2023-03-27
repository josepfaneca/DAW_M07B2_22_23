package org.ioc.daw.config;


import org.ioc.daw.user.UserDAO;
import org.ioc.daw.user.UserHibernateDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DAOConfig {

    @Bean
    public UserDAO userDAO() {
        return new UserHibernateDAO();
    }
}
