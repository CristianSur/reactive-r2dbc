package com.example.orange.config;

import com.example.orange.util.PropertyReader;
import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.core.DatabaseClient;

@Configuration
public class DatabaseConfig {

    private static final String DB_USERNAME = PropertyReader.DATABASE_USERNAME;
    private static final String DB_PASSWORD = PropertyReader.DATABASE_PASSWORD;
    private static final String DB_NAME = PropertyReader.DATABASE_NAME;
    private static final String HOST = PropertyReader.HOST;

    @Bean
    public ConnectionFactory connectionFactory() {

        return new PostgresqlConnectionFactory(
                PostgresqlConnectionConfiguration.builder()
                        .host(HOST)
                        .database(DB_NAME)
                        .username(DB_USERNAME)
                        .password(DB_PASSWORD)
                        .build()
        );
    }

    @Bean
    DatabaseClient databaseClient(ConnectionFactory connectionFactory) {
        return DatabaseClient.builder()
                .connectionFactory(connectionFactory)
                .namedParameters(true)
                .build();
    }

}