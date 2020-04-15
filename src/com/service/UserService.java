package com.service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.IUserDAO;
import com.entity.User;
import com.google.common.hash.Hashing;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;

	@Override
	@Transactional
	public void saveUser(User theUser) {

		theUser.setPassword(encryptionPassword(theUser.getPassword()));
		userDAO.saveUser(theUser);
	}

	@Override
	@Transactional
	public List<String> getCountries() {
		List<String> countries;

		countries = new ArrayList<String>();

		String[] locales = Locale.getISOCountries();

		for (String countryCode : locales) {

			Locale obj = new Locale("", countryCode);

			countries.add(obj.getDisplayCountry());
		}

		return countries;
	}

	@Override
	public String encryptionPassword(String password) {
		// password encryption
		String hashtext = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();

		return hashtext;
	}

}
