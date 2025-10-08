package com.example.batch.config;

import com.example.batch.processor.SaludoProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  private StepBuilderFactory stepBuilderFactory;

  @Bean
  public Step saludoStep(SaludoProcessor saludoProcessor) {
    return stepBuilderFactory.get("saludoStep")
        .tasklet(saludoProcessor) // Vincula el tasklet y asegura que sea transaccional
        .build();
  }

  @Bean
  public Job saludoJob(Step saludoStep) {
    return jobBuilderFactory.get("saludoJob")
        .incrementer(new RunIdIncrementer())
        .start(saludoStep) // Define el flujo del job
        .build();
  }
}
