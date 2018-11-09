package de.kimrudolph.dbmigrations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Provides the spring context to FlyWay migrations.
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    @Autowired
    private static ApplicationContext applicationContext;

    public void setApplicationContext(
            final ApplicationContext applicationContext) {

        this.applicationContext = applicationContext;
    }

    /**
     * Get a class bean from the application context
     */
    public static <T> T getBean(final Class<T> clazz) {

        return applicationContext.getBean(clazz);
    }

}