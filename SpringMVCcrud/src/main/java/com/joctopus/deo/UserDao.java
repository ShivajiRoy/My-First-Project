package com.joctopus.deo;

import java.sql.SQLException;

import com.joctopus.entity.UserEntity;

public interface UserDao {
	public boolean isValieduser(String username,String password) throws SQLException;
}
