package com.baidu.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.baidu.entity.Cat;

public class BaseDao {
	private JdbcTemplate jdbcTemplate;

	public void add(String sql, String name, String age) {
		
		jdbcTemplate.update(sql, new PreparedStatementSetter() {
			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, name);
				ps.setString(2, age);
			}
		});
		
		
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, name);
				ps.setString(2, age);
				return ps;
			}
		});
		
		
		jdbcTemplate.update(sql, new Object[]{1,2});
		
	}
	private Connection con;
	public void get(String sql) throws SQLException{
		Statement statement = con.createStatement();
		statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
		
		ResultSet rs = statement.getGeneratedKeys();
		if(rs.next()){
			//rs.getInt();
		}
	}
	
	public void get(){
		String sql = "";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setString(1, "");
				return statement;
			}
		}, keyHolder);
		
		Number key = keyHolder.getKey();
		int intValue = key.intValue();
		
	}
	
	public Cat get(final int id){
		String sql ="";
		final Cat cat = new Cat();
		jdbcTemplate.query(sql, new Object[]{}, new RowCallbackHandler() {
			
			@Override
			public void processRow(ResultSet rs) throws SQLException {
				
			}
		});
		
		return cat;
	}
	
}
