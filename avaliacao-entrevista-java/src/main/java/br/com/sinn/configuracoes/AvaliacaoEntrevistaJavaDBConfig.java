package br.com.sinn.configuracoes;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"br.com.sinn"})
@PropertySource(value = "classpath:application.properties")
public class AvaliacaoEntrevistaJavaDBConfig {

	@Autowired
	private Environment environment;
	
	private DataSource avaliacaoEntrevistaJavaDataSource;
	
	@Bean
	public LocalContainerEntityManagerFactoryBean audespEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(audespDataSource());
		em.setPackagesToScan(new String[] {"br.com.sinn"});

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		em.setJpaProperties(this.hibernateProperties());

		return em;
	}

	@Bean
	public DataSource audespDataSource() {
		try {
			Context initCtx = new InitialContext();
			avaliacaoEntrevistaJavaDataSource = (DataSource) initCtx.lookup(environment.getProperty("jdbc.jndi"));
			initCtx.close();
			return avaliacaoEntrevistaJavaDataSource;
		} catch (NamingException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Bean
	public PlatformTransactionManager audespTransactionManager(EntityManagerFactory emf) {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(emf);
		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
      return new PersistenceExceptionTranslationPostProcessor();
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(audespDataSource());
		sessionFactory.setPackagesToScan(new String[] { "br.com.sinn"});
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	private Properties hibernateProperties() {
		Properties properties = new Properties();
		if (environment.containsProperty("hibernate.hbm2ddl.auto")) {
			properties.setProperty("hibernate.hbm2ddl.auto", environment.getProperty("hibernate.hbm2ddl.auto"));
		}
		properties.setProperty("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql", "true"));
		properties.setProperty("hibernate.format_sql", environment.getProperty("hibernate.format_sql", "true"));
		properties.setProperty("hibernate.generate_statistics", environment.getProperty("hibernate.generate_statistics", "true"));
		properties.setProperty("hibernate.current_session_context_class", environment.getProperty("hibernate.current_session_context_class", "thread"));
		properties.setProperty("hibernate.dbcp.testOn", environment.getProperty("hibernate.dbcp.testOn", "SELECT 1+1"));

		return properties;
	}

}
