package com.ndibsg.spring.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ndibsg.spring.config.RootConfig;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Slf4j
//정원영 (히카리커넥션 검사) 20.12.19
public class DataSourceTest {
	
	@Setter(onMethod_ = { @Autowired })
	private DataSource dataSource;
	
	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void testConnection() { //hikari connection test
		try(Connection con = dataSource.getConnection()){
			log.debug("con==>{}",con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testMybatis() { //mybatis connection test
		try(SqlSession session = sqlSessionFactory.openSession()){
			Connection con = session.getConnection();
			log.debug("con==>{}",con);
		}catch(Exception e) {
			fail(e.getMessage());
		}
	}
	

}
