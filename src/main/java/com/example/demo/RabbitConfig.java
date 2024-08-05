package com.example.demo;

import java.time.Duration;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.autoconfigure.amqp.EnvironmentBuilderCustomizer;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.rabbit.stream.support.StreamAdmin;

import com.rabbitmq.stream.Address;
import com.rabbitmq.stream.Environment;

@Configuration
@EnableRabbit
public class RabbitConfig {

    @Bean
    StreamAdmin streamAdmin(Environment env) {
        return new StreamAdmin(env, sc -> {
            sc.stream("stream.queue1").maxAge(Duration.ofHours(2)).create();
            sc.stream("stream.queue2").create();
        });
    }
    
}
