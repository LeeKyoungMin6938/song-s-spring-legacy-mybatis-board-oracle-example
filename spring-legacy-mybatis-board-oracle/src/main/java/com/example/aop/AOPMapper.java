package com.example.aop;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface AOPMapper {
	public int insert(AOPModel aop);
	
	@Select("SELECT * FROM aoptable")
	public ArrayList<AOPModel> selectAll();
}
