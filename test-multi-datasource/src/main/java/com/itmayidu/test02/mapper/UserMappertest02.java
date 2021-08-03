package com.itmayidu.test02.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.itmayidu.entity.User;

public interface UserMappertest02 {
	@Select("select * from student where studentName = #{name}")
	User findByName(@Param("name") String name);

	@Insert("insert into student(studentName,studentAge) values(#{name},#{age})")
	int insert(@Param("name") String name,@Param("age") Integer age);
}
