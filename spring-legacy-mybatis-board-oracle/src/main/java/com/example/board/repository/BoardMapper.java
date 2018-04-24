package com.example.board.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.board.model.Board;

@Mapper
public interface BoardMapper {
	public int insert(Board board);
	public int update(Board board);
	public int delete(long id);
	
	@Select("select count(*) from xboard")
	public int count();
	
	@Select("select * from xboard order by id desc")
	public List<Board> selectAll();
	
	public Board selectById(long id);
	public List<Board> selectByLimit(@Param("page") int page, @Param("size") int size);
	public int increment(@Param("id") long id, @Param("requester") String requester);
	
}
