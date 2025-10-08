package com.example.batch.processor;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.batch.core.configuration.annotation.StepScope;

@Component
@StepScope // CRÍTICO: Habilita el enlace tardío de los parámetros del job
public class SaludoProcessor implements Tasklet {

  private final String nombre;
  private final Long numero;

  // Los parámetros se inyectan a través del constructor usando @Value y SpEL
  public SaludoProcessor(
      @Value("#{jobParameters['nombre']}") String nombre,
      @Value("#{jobParameters['numero']}") Long numero) {
    this.nombre = nombre;
    this.numero = numero;
  }

  @Override
  public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
    // La lógica ahora usa los valores inyectados
    System.out.println(String.format("hola %s tiene %d annos", nombre, numero));
    return RepeatStatus.FINISHED;
  }
}
