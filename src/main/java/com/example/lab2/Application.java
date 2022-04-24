package com.example.lab2;


import com.example.lab2.controler.entityСontrollers.PersonController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.net.InetAddress;


@SpringBootApplication
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @EventListener
    public void printApplicationUrl(ApplicationStartedEvent event) {
        LoggerFactory.getLogger(Application.class).info("Application started at "
                + "http://localhost:"
                + environment.getProperty("local.server.port")
        );
    }
}
