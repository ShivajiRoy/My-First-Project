package com.joctopus.deo;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.joctopus.entity.UserEntity;

@Repository
public class UserDaoImpl implements UserDao{
		@Autowired
		DataSource datasource;
	
	public DataSource getDatasource() {
			return datasource;
		}

		public void setDatasource(DataSource datasource) {
			this.datasource = datasource;
		}

	@Override
	public boolean isValieduser(String username,String password) throws SQLException {
		
		String query = "Select count(1) from user where username = ? and password = ?";
		 PreparedStatement ps = datasource.getConnection().prepareStatement(query);
        ps.setString(1, username);
        ps.setString(2, password);
        ResultSet resultSet = ps.executeQuery();
        if(resultSet.next())
            return (resultSet.getInt(1) > 0);
        else
           return false;
	   
	}
}
