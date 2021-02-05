package com.ndibsg.spring.persistence;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ndibsg.spring.config.RootConfig;
import com.ndibsg.spring.mapper.UserMapper;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
@Slf4j
public class TimeMapperTests {
	
	@Setter(onMethod_ = @Autowired)
	private UserMapper userMapper;
	
	@Test
	public void testGetTime() {
		log.debug("userMapper===>{}",userMapper);
		log.debug("getTime===>{}",userMapper.getTime());
		log.debug("getTime===>{}",userMapper.getClass().getName());
		
	}

}
