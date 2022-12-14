package com.example.spring_batch_0922.job.helloworld;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class HelloWorldJobConfig {
    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job helloWorldJob() {
        return jobBuilderFactory.get("helloWorldJob")
                //.incrementer(new RunIdIncrementer()) // 강제로 매번 다른 ID를 실행시에 파라미터로 부여
                .start(helloWorldStep1()).next(helloWorldStep2())
                .build();
    }



    @Bean
    @JobScope
    public Step helloWorldStep1() {
        return stepBuilderFactory.get("helloWorldStep1")
                .tasklet(helloWorldTasklet())
                .build();
    }

    @Bean
    @JobScope
    public Step helloWorldStep2() {
        return stepBuilderFactory.get("helloWorldStep2")
                .tasklet(helloWorldTasklet2())
                .build();
    }

    @Bean
    @StepScope
    public Tasklet helloWorldTasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("헬로월드!");
            return RepeatStatus.FINISHED;
        };
    }


    @Bean
    @StepScope
    public Tasklet helloWorldTasklet2() {
        return (contribution, chunkContext) -> {
            System.out.println("헬로월드 테스클릿 2");

            if ( false ) {
                throw new Exception("실패 : 헬로월드 테스클릿 2");
            }
            return RepeatStatus.FINISHED;
        };
    }
}