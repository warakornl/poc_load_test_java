package com.example.demo.configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

@Configuration
public class DatasourceConfig {

    @Bean
    @Primary
    @ConfigurationProperties("postgres.datasource")
    public DataSourceProperties postgresProperties() {
        return new DataSourceProperties();
    }

    @Bean(name="postgresDatasource")
    @Primary
    public DataSource postgresDatasource(){

        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://rptcomm.postgres.database.azure.com:5432/rpt_poc");
        config.setDriverClassName("org.postgresql.Driver");
        config.setUsername("rpt_read");
        config.setPassword("rpt1234!!");
//        config.setMinimumIdle(minimumIdle);
//        config.setMaximumPoolSize(maxPoolSize);
//        config.setConnectionTimeout(connectionTimeout);
//        config.setIdleTimeout(idleTimeout);
//        config.setValidationTimeout(validationTimeout);
//        config.setMaxLifetime(maxLifetime);
//        config.setInitializationFailTimeout(initializationFailTimeout);

        return new HikariDataSource(config);
        //return postgresProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name="postgresJdbcTemplate")
    @Primary
    public NamedParameterJdbcTemplate postgresJdbcTemplate(@Qualifier("postgresDatasource")final DataSource dataSource){
        return new NamedParameterJdbcTemplate(dataSource);
    }

    @Bean(name="postgresTransactionManager")
    @Primary
    public PlatformTransactionManager postgresTransactionManager(@Qualifier("postgresDatasource")final DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
