package com.example.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {
   /*
    * 分页插件，自动识别数据库类型
    */
   @Bean
   public PaginationInterceptor paginationInterceptor() {
      PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
      paginationInterceptor.setDialectType("mysql");
      return paginationInterceptor;
   }
}