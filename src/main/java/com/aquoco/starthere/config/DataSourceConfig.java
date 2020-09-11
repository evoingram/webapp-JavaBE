package com.aquoco.starthere.config;

import com.aquoco.starthere.StartHereApplication;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {
    private static final Logger logger = LoggerFactory.getLogger(StartHereApplication.class);
    private static boolean stop = false;
    /*
    */

    @Autowired
    private ApplicationContext appContext;
    @Autowired
    private Environment env;

    @Value("${local.run.db:H2}")
    private String dbValue;
    @Value("${spring.datasource.url:}")
    private String dbURL;

    private static void checkEnvironmentVariable(String envvar) {
        if (System.getenv(envvar) == null) {
            logger.error("Environment Variable " + envvar + " missing");
            stop = true;
        }
    }

    @Bean(name = "dsCustom")
    public DataSource dataSource() {

        String myUrlString = "";
        String myDriverClass = "";
        String myDBUser = "";
        String myDBPassword = "";

        String dbValue = env.getProperty("local.run.db");
        String dbURL = env.getProperty("spring.datasource.url");
        // String dbValue = env.getProperty("local.run.db");
        if (dbValue.equalsIgnoreCase("POSTGRESQL")) {

            // checkEnvironmentVariable("MYDBHOST");
            // checkEnvironmentVariable("MYDBNAME");
            // checkEnvironmentVariable("MYDBUSER");
            // checkEnvironmentVariable("MYDBPASSWORD");

            if (stop) {
                logger.info("Manually shutting down system");
                int exitCode = SpringApplication.exit(appContext, (ExitCodeGenerator) () -> 1);
                System.exit(exitCode);
            }

            HikariConfig config = new HikariConfig();
            config.setDriverClassName("org.postgresql.Driver");
            config.setJdbcUrl(dbURL);
            logger.info("Heroku Database URL is " + dbURL);
            return new HikariDataSource(config);


        } else {
            // Assumes H2
            myUrlString = "jdbc:h2:mem:testdb";
            myDriverClass = "org.h2.Driver";
            myDBUser = "sa";
            myDBPassword = "";
            logger.info("H2 Database URL is " + myUrlString);
            return DataSourceBuilder.create()
                                    .username(myDBUser)
                                    .password(myDBPassword)
                                    .url(myUrlString)
                                    .driverClassName(myDriverClass)
                                    .build();
        }

    }

    @Bean(name = "jdbcCustom")

    @Autowired
    public JdbcTemplate jdbcTemplate(
            @Qualifier("dsCustom")
                    DataSource dsCustom) {
        return new JdbcTemplate(dsCustom);
    }
}
