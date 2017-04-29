package co.md.config;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableJpaRepositories(basePackages = "co.md.repository.base", entityManagerFactoryRef = "baseEntityManager", transactionManagerRef = "baseTransactionManager")
public class BaseDbConfig {

	@Bean
	public LocalContainerEntityManagerFactoryBean baseEntityManager() {
		LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
		em.setDataSource(baseDataSource());
		em.setPackagesToScan(new String[] { "co.md.model.base_entity" });

		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		em.setJpaVendorAdapter(vendorAdapter);
		return em;
	}

	@Bean
	@Qualifier("baseDataSource")
	public DataSource baseDataSource() {
		DataSource ds = new DataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/default_schema?useSSL=false");
		ds.setUsername("root");
		ds.setPassword("root");
		ds.setInitialSize(5);
		ds.setMaxActive(1000);
		ds.setMaxIdle(5);
		ds.setMinIdle(2);
		return ds;
	}

	@Bean
	public PlatformTransactionManager baseTransactionManager() {

		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(baseEntityManager().getObject());
		return transactionManager;
	}
}