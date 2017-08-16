package br.com.intelize.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.net.URI;
import java.net.URISyntaxException;

@Configuration
public class DatabaseConfiguration {

    @Bean
    public DataSource dataSource() throws URISyntaxException {
        String environment = System.getenv("ENVIRONMENT");

        String username = "";
        String password = "";
        String dbUrl = "";

        if (environment == null || environment.equals("DEVELOPMENT")) {
            username = "keepherokualive";
            password = "keepherokualive";
            dbUrl = "jdbc:postgresql://localhost:5432/keep_heroku_alive";
        } else if (environment.equals("PRODUCTION")) {
            URI dbUri = new URI(System.getenv("DATABASE_URL"));

            username = dbUri.getUserInfo().split(":")[0];
            password = dbUri.getUserInfo().split(":")[1];
            dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();
        } else {

        }

        DriverManagerDataSource driver = new DriverManagerDataSource();
        driver.setDriverClassName("org.postgresql.Driver");
        driver.setUrl(dbUrl);
        driver.setUsername(username);
        driver.setPassword(password);

        return driver;
    }
}
