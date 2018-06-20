package com.kodinor.configuration;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.kodinor.entity.user.User;
import com.kodinor.repository.user.UserRepository;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackageClasses = UserRepository.class, entityManagerFactoryRef = "userDSEmFactory", transactionManagerRef = "userDSTransactionManager")
public class UserDBConfiguration {
	
	@Primary
	@Bean
	@ConfigurationProperties("spring.datasource1")
	public DataSourceProperties userDSProperties() {
		return new DataSourceProperties();
	}
	
	@Primary
	@Bean
	public DataSource userDS(@Qualifier("userDSProperties") DataSourceProperties userDSProperties) {
		return userDSProperties.initializeDataSourceBuilder().build();
	}
	
	@Bean
	public LocalContainerEntityManagerFactoryBean userDSEmFactory(@Qualifier("userDS") DataSource userDS, EntityManagerFactoryBuilder builder) {
		return builder.dataSource(userDS).packages(User.class).build();
	}
	
	@Primary
	@Bean
	public PlatformTransactionManager userDSTransactionManager(EntityManagerFactory userDSEmFactory) {
		return new JpaTransactionManager(userDSEmFactory);
	}

}
