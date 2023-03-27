package org.ioc.daw.config;


import org.ioc.daw.user.UserDAO;
import org.ioc.daw.user.UserService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringTestConfig {
  @Bean
  public UserDAO userDAO() {
      return Mockito.mock(UserDAO.class);
  }

  @Bean
  public UserService userService(UserDAO userDAO) {
      return new UserService(userDAO);
  }

}