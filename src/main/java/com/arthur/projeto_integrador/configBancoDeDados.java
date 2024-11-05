package com.arthur.projeto_integrador;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class configBancoDeDados {
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver"); //declara as configurações de acesso
        dataSource.setUrl("jdbc:postgresql://localhost:5433/loja");
        dataSource.setUsername("postgres");//usuario
        dataSource.setPassword("postgres");//senha
        return dataSource;
    }
}
