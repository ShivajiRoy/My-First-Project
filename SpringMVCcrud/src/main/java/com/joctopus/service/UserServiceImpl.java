package com.joctopus.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import com.joctopus.deo.UserDao;
import com.joctopus.entity.UserEntity;

public class UserServiceImpl implements UserService{
	@Autowired
	UserDao userdao;
	public UserDao getUserdao() {
		return userdao;
	}
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	@Override
	public boolean isValieduser(String username,String password) throws SQLException {
		// TODO Auto-generated method stub
		return userdao.isValieduser(username, password);
	}
	

}
