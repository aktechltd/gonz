package com.bskyb.nebula.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Value("${api.jdbcProperties.url}")
    private String jdbcUrl;

    @Value("${api.jdbcProperties.username}")
    private String username;

    @Value("${api.jdbcProperties.password}")
    private String password;

    @Value("${api.driver.class.name}")
    private String driverClassName;

    @Bean
    public DataSource contentDataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setUrl(jdbcUrl);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource contentDataSource){
        return new JdbcTemplate(contentDataSource);
    }

}
