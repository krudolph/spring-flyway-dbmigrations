package de.kimrudolph.dbmigrations;

import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

import javax.sql.DataSource;

/**
 * Manually configured to allow spring context injections using @DependsOn.
 */
@Configuration
public class FlywayConfiguration {

    @Autowired
    DataSource dataSource;

    @Bean(initMethod = "migrate")
    @DependsOn("springContextUtil")
    public Flyway flyway() {

        return Flyway.configure().dataSource(dataSource).load();
    }
}
