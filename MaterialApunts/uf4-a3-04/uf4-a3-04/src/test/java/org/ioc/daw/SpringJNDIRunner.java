package org.ioc.daw;

import org.ioc.daw.config.HibernateMysqlConfiguration;
import org.junit.runners.model.InitializationError;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.mock.jndi.SimpleNamingContextBuilder;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.naming.NamingException;

public class SpringJNDIRunner extends SpringJUnit4ClassRunner {
    public static boolean isJNDIactive;
    public SpringJNDIRunner(Class<?> klass) throws InitializationError, IllegalStateException, NamingException, javax.naming.NamingException {
        super(klass);

        synchronized (SpringJNDIRunner.class) {
            if (!isJNDIactive) {

                ApplicationContext applicationContext = new AnnotationConfigApplicationContext(HibernateMysqlConfiguration.class);
                SimpleNamingContextBuilder builder = new SimpleNamingContextBuilder();
                builder.bind("jdbc/socioc", applicationContext.getBean("dataSource"));
                builder.activate();

                isJNDIactive = true;
            }
        }
    }
}

