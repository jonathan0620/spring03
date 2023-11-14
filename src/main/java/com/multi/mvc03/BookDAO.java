package com.multi.mvc03;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDAO {

	@Autowired
	SqlSessionTemplate my;
	
	public int update(BookDTO dto) {
		return my.update("book.update", dto);
	}
	
	public int insert(BookDTO dto) {
		return my.insert("book.create", dto);
	}
	

	public BookDTO one(String id) {//id = 4
		return my.selectOne("book.one", id);
	}
	
}