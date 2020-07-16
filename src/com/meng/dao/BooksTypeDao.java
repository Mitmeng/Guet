package com.meng.dao;

import java.util.List;

import com.meng.beans.BooksType;
import com.meng.util.BeanListHandler;

public class BooksTypeDao extends BaseDao{

	public List<BooksType> findall() {
		String sql = "select * from guet_bookstype_table";
		return (List<BooksType>) find(sql, null, new BeanListHandler(BooksType.class));
	}

}
