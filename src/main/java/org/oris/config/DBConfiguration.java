package org.oris.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfiguration {

    @Bean
    public HikariConfig getHicariConfig(){
        DBProperties dbProperties = new DBProperties();
        HikariConfig hikariConfig = new HikariConfig();

        hikariConfig.setJdbcUrl(dbProperties.getValue("db.url"));
        hikariConfig.setUsername(dbProperties.getValue("db.user"));
        hikariConfig.setPassword(dbProperties.getValue("db.password"));
        hikariConfig.setMaximumPoolSize(Integer.parseInt(dbProperties.getValue("db.pool.size")));

        return hikariConfig;
    }

    @Bean
    public DataSource getDataSource(){
        DataSource dataSource = new HikariDataSource(getHicariConfig());
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate(){
        return new JdbcTemplate(getDataSource());
    }

}
