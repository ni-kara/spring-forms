package com.service;

import java.util.List;

import com.entity.User;

public interface IUserService {
	
	public void saveUser(User theUser);
	
	public List<String> getCountries();
	
	public String encryptionPassword(String password);
	
}
