package com.allen.transactionmessageservice.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.allen.transactionmessageservice.mapper")
public class MybatisConfig {

}
