package com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Service;/*
import org.springframework.transaction.annotation.Transactional;*/

@Service
public class CountriesService implements ICountries {
	
	@Override
	//@Transactional
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

}
