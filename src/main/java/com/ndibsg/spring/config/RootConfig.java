package com.ndibsg.spring.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

//정원영_web.xml를 대신하는 클래스_20/12/19
@Configuration
@ComponentScan(basePackages = {"com.ndibsg.spring"})
@MapperScan(basePackages = {"com.ndibsg.spring.mapper"})
public class RootConfig{
	
	@Bean
	public DataSource dataSource() { // 정원영 [Hikari Connection] 20/12/19 
		HikariConfig hikariConfig = new HikariConfig();
		hikariConfig.setDriverClassName("oracle.jdbc.OracleDriver");
		hikariConfig.setJdbcUrl("jdbc:oracle:thin:@database-1.crqm2btdpkey.ap-northeast-2.rds.amazonaws.com:6066/orcl");
		hikariConfig.setUsername("admin");
		hikariConfig.setPassword("qkrdnjswns302622");
		
		HikariDataSource dataSource = new HikariDataSource(hikariConfig);
		return dataSource;
	}
	
	@Bean
	public SqlSessionFactory sqlSessionFactory() throws Exception { 
		SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean(); // spring 과 연동 작업 처리하는 spirng-mybatis
		sqlSessionFactoryBean.setDataSource(dataSource());
		return (SqlSessionFactory)sqlSessionFactoryBean.getObject();
	}

}
