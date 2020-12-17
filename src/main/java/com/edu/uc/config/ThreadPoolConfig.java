package com.edu.uc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ThreadPoolConfig {

  private static final int MAX_POOL_SIZE = 10;

  /**
   * 任务处理器
   *
   * @return 线程池处理器
   */
  @Bean(name = "task_executor")
  public ExecutorService taskExecutor() {
    return Executors.newFixedThreadPool(MAX_POOL_SIZE);
  }
}
