package com.example.diplomprojectmanagementprogramc51.configuration;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@PropertySource({"classpath:application-dev.properties"})
public class HibernateConfiguration {
    @Value("${spring.datasource.driver}")
    private String driver;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;
    @Value("${spring.jpa.hibernate.hbm2ddl.auto}")
    private String databaseSchemaStrategy;
    @Value("${spring.jpa.hibernate.dialect}")
    private String hibernateDialect;
    @Value("${spring.jpa.hibernate.show_sql}")
    private String showSql;
    @Value("${spring.jpa.hibernate.format_sql}")
    private String formatSql;
    @Value("${spring.jpa.hibernate.hbm2ddl.import_files}")
    private String dataInitializationFile;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    private Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", databaseSchemaStrategy);
        hibernateProperties.setProperty("hibernate.dialect", hibernateDialect);
        hibernateProperties.setProperty("hibernate.show_sql", showSql);
        hibernateProperties.setProperty("hibernate.format_sql", formatSql);
        hibernateProperties.setProperty("hibernate.hbm2ddl.import_files", dataInitializationFile);
        return hibernateProperties;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.example.diplomprojectmanagementprogramc51.entity");
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
