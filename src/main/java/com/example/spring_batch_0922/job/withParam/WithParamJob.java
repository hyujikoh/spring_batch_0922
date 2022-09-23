package com.example.spring_batch_0922.job.withParam;

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
public class WithParamJob {
    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    @Bean
    public Job WithParamJob() {
        return jobBuilderFactory.get("WithParamJob")
                .incrementer(new RunIdIncrementer()) // 강제로 매번 다른 ID를 실행시에 파라미터로 부여
                .start(WithParamJobStep1())
                .build();
    }

    @Bean
    @JobScope
    public Step WithParamJobStep1() {
        return stepBuilderFactory.get("helloWorldStep1")
                .tasklet(WithParamJodTasklet())
                .build();
    }


    @Bean
    @StepScope
    public Tasklet WithParamJodTasklet() {
        return (contribution, chunkContext) -> {
            System.out.println("WithParam 테스클릿 2!");
            return RepeatStatus.FINISHED;
        };
    }
}
