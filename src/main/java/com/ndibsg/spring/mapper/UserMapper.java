package com.ndibsg.spring.mapper;

import org.apache.ibatis.annotations.Select;

public interface UserMapper {

	
	@Select("SELECT sysdate FROM DUAL")
	public String getTime();
	
}
