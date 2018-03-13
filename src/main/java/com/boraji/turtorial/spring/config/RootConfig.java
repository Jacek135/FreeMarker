package com.boraji.turtorial.spring.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories("com.boraji.turtorial.spring.repository")
@PropertySource("classpath:db.properties")
public class RootConfig {
    //Service and Repository beans configuration
    @Value("${db.driver.class.name}")
    private String driver;
    @Value("${db.url}")
    private String url;
    @Value("${db.user.name}")
    private String user;
    @Value("${db.user.password}")
    private String pass;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource());
        em.setPackagesToScan("com.boraji.turtorial.spring.entity");
        em.setJpaVendorAdapter(vendorAdapter());
        em.setJpaProperties(additionalProperties());

        return em;
    }

    @Bean(destroyMethod = "close")
    DataSource dataSource() {
        return prepare();
    }

    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory().getObject());
        return transactionManager;
    }

    private DataSource prepare() {
        BasicDataSource pool = new BasicDataSource();
        pool.setDriverClassName(driver);
        pool.setUrl(url);
        pool.setUsername(user);
        pool.setPassword(pass);

        return pool;
    }

    @Bean
    JpaVendorAdapter vendorAdapter() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        return vendorAdapter;
    }

    private Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.hbm2ddl.auto", "none");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.show_sql", "true");
        properties.put("hibernate.format.sql", "true");

        return properties;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

}
