package io.github.YuriLopess.DeliverySystemOrders.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DatabaseConfig {

    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String username;
    @Value("${spring.datasource.password}")
    String password;
    @Value("${spring.datasource.driver-class-name}")
    String driver;

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();

        config.setJdbcUrl(url);
        config.setPassword(password);
        config.setUsername(username);
        config.setDriverClassName(driver);

        config.setPoolName("payments-db-pool");
        config.setMaximumPoolSize(10);
        config.setMinimumIdle(1);

        return new HikariDataSource(config);
    }

}