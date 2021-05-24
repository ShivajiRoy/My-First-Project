package com.joctopus.service;

import java.sql.SQLException;

import com.joctopus.entity.UserEntity;

public interface UserService {

	public boolean isValieduser(String username,String password) throws SQLException;
}
