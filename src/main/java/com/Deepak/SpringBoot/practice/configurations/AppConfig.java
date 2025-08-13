package com.Deepak.SpringBoot.practice.configurations;

import com.Deepak.SpringBoot.practice.DataBase;
import com.Deepak.SpringBoot.practice.DevDB;
import com.Deepak.SpringBoot.practice.ProdDB;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    @ConditionalOnProperty(name = "project.mode", havingValue = "development")
    public static DataBase getDevDataBaseBean()
    {
        return new DevDB();
    }
    @ConditionalOnProperty(name = "project.mode", havingValue = "production")
    @Bean
    public static DataBase getProdDataBaseBean()
    {
        return new ProdDB();
    }
}
