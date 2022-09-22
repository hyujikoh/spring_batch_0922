package com.example.spring_batch_0922;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SpringBatch0922Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringBatch0922Application.class, args);
    }

}
