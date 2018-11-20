package com.spring.configuration;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan(basePackages = "com.spring")
@EnableTransactionManagement
public class HibernateConfiguration {

	@Autowired
	private Environment environment;

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource source = new DriverManagerDataSource();
		source.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
		source.setUrl(environment.getRequiredProperty("jdbc.url"));
		source.setUsername(environment.getRequiredProperty("jdbc.username"));
		source.setPassword(environment.getRequiredProperty("jdbc.password"));
		return source;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean session = new LocalSessionFactoryBean();
		session.setDataSource(dataSource());
		session.setPackagesToScan("com.spring.model");
		session.setHibernateProperties(hibernateProperties());
		return session;
	}

	private Properties hibernateProperties() {
		final Properties prop = new Properties();
		prop.put("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		prop.put("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
		prop.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		prop.put("hibernate.c3p0.max_size", environment.getRequiredProperty("hibernate.c3p0.max_size"));
		prop.put("hibernate.c3p0.acquire_increment",
				environment.getRequiredProperty("hibernate.c3p0.acquire_increment"));
		prop.put("hibernate.c3p0.timeout", environment.getRequiredProperty("hibernate.c3p0.timeout"));
		prop.put("hibernate.c3p0.min_size", environment.getRequiredProperty("hibernate.c3p0.min_size"));
		prop.put("hibernate.c3p0.max_statements", environment.getRequiredProperty("hibernate.c3p0.max_statements"));
		return prop;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory session){
		HibernateTransactionManager tx = new HibernateTransactionManager();
		tx.setSessionFactory(session);
		return tx;
		
	}

}
