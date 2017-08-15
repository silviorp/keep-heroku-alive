package br.com.intelize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KeepHerokuAliveApplication {

    public static void main(String[] args) {
        SpringApplication.run(KeepHerokuAliveApplication.class, args);
    }
}
