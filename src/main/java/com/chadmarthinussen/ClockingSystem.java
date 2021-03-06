package com.chadmarthinussen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/**
 * Created by ChadMarthinussen2 on 2019/06/11.
 */
@SpringBootApplication
@EnableWebSecurity
public class ClockingSystem {
        public static void main(String[] args) {
            SpringApplication.run(ClockingSystem.class, args);
        }
}