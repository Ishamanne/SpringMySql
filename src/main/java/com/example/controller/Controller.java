package com.example.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	@Qualifier("mysqlJdbcTemplate")
	private JdbcTemplate mysqlTemplate;

//	@RequestMapping(value = "/getPGUser")
//	public String getPGUser() {
//		Map<String, Object> map = new HashMap<String, Object>();
//		String query = " select * from usermaster";
//		try {
//			map = postgresTemplate.queryForMap(query);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "PostgreSQL Data: " + map.toString();
//	}

	@RequestMapping(value = "/getMYUser")
	public String getMYUser() {
		List<Map<String,Object>> map = null;
		String query = "select * from user";
		try {
			map = mysqlTemplate.queryForList(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "MySQL Data: " + map.toString();
	}
	
	@RequestMapping(value = "/save")
	public String saveMYUser() {
		
		String query = "insert into user values(2,'pradyun','4428 trinity woods st','pradyun@gmail.com')";
		try {
			mysqlTemplate.update(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "Table Updated!";
	}
	
	
}
