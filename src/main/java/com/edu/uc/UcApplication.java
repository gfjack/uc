package com.edu.uc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan("com")
@EnableJpaRepositories(basePackages = "com.edu.uc.repository")
@EntityScan(basePackages = "com.edu.uc.model.entity")
@SpringBootApplication
public class UcApplication extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(UcApplication.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
    return applicationBuilder.sources(UcApplication.class);
  }

  @Bean
  public ThreadPoolTaskExecutor taskExecutor() {
    ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
    pool.setCorePoolSize(30);
    pool.setMaxPoolSize(200);
    pool.setWaitForTasksToCompleteOnShutdown(true);
    pool.setQueueCapacity(20000);
    return pool;
  }

}
