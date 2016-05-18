package com.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Repository;

class User {
	private String username;
    private String password;
 
    public String toString() {
        return String.format("[%s %s]", getUsername(), getPassword());
    }

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
    
}
@Repository
public class test {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
	    this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	 public void handler() throws SQLException {
		 String sqlUpdate = "UPDATE user set password=? where username=?";
		 this.jdbcTemplate.update(sqlUpdate, "tomee@mail.com", "Tom");
		 String sqlSelect = "SELECT * FROM user";
		 List<User> listContact = this.jdbcTemplate.query(sqlSelect, new RowMapper<User>() {
			 public User mapRow(ResultSet result, int rowNum) throws SQLException {
				 User contact = new User();
				 contact.setUsername(result.getString("username"));
				 contact.setPassword(result.getString("password"));
				 return contact;
			 }
		 });
	
		 for (User aContact : listContact) {
			 System.out.println(aContact);
		 }
		 System.out.println(listContact.get(0).getPassword());
    }
}