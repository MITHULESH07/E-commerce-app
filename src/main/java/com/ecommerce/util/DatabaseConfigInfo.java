package com.ecommerce.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Simple configuration holder for documenting the active database setup.
 * This keeps a dedicated config/util class in the project structure,
 * similar to the template shown in the assignment.
 */
@Configuration
public class DatabaseConfigInfo {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.driver-class-name}")
    private String driverClassName;

    public String getDatasourceUrl() {
        return datasourceUrl;
    }

    public String getDriverClassName() {
        return driverClassName;
    }
}
