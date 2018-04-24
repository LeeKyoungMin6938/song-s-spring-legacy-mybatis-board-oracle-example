package com.example.user.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.user.model.User;

@Mapper
public interface UserMapper {
	@Insert("insert into xuser(email,password) values(#{email},#{password})")
	public int insert(User user);
	
	@Update("update xuser set password = #{password} where email=#{email}")
	public int update(String email);
	
	@Delete("delete from xuser where email = #{email}")
	public int delete(String email);
	
	@Select("select count(*) from xuser")
	public int count();
	
	@Select("select * from xuser order by email asc")
	@ResultType(User.class)
	public List<User> selectAll();
	
	@Select("select * from xuser where email = #{email}")
	@Results(id = "userResultMap", value= {
			@Result(property = "email", column="email"),
			@Result(property = "password", column="password")})
	public User selectByEmail(String email);
}
