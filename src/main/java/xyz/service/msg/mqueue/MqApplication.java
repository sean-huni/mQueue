package xyz.service.msg.mqueue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
@EnableRabbit
@ComponentScan(basePackages = "xyz.service.msg.mqueue")
@Configuration
public class MqApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(MqApplication.class);

    public static void main(String[] args) {
        // Launch the application
        LOGGER.info("LAUNCHING...");
        SpringApplication.run(MqApplication.class, args);
        LOGGER.info("LAUNCHING SEQUENCE COMPLETED!");
    }

}
