package com.ronit.urlshortner.service;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronit.urlshortner.entity.Shortened;
import com.ronit.urlshortner.repository.UrlShortnerRepoImpl;

@Service
public class UrlShortenedServiceImpl implements UrlShortenedService {

	@Autowired
	UrlShortnerRepoImpl urlRepo;

	public Shortened longUrlfinnder(String id) {
		List<Shortened> alldetails = new ArrayList<>();
		alldetails = getAllShortenedUrl();
		Shortened longCheck = alldetails.stream().filter(x -> x.getLongid().equals(id)).findFirst().orElse(null);
		return longCheck;
	}

	public List<Shortened> getAllShortenedUrl() {
		List<Shortened> alldetails = new ArrayList<>();
		alldetails = (List<Shortened>) urlRepo.findAll();
		return alldetails;

	}
	

	public void saveOrUpdate(Shortened shortend) {
		urlRepo.save(shortend);

	}

	
	 public Shortened findByShortId(String shortid) { Shortened
	  s=urlRepo.findByShortID(shortid); return s; }
	 

	public String randomAlphaNumeric() {
		String rand = "";
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		for (int i = 0; i < 5; i++) {
			rand += ALPHA_NUMERIC_STRING.charAt((int) Math.floor(Math.random() * ALPHA_NUMERIC_STRING.length()));

		}
		return rand;
	}

	@Override
	public void setShortUrl(String randomChar,Shortened shortened) {
		shortened.setShortid(randomChar);
		
	}
}
