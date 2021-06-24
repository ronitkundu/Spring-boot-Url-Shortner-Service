package com.ronit.urlshortner.service;

import java.util.List;

import com.ronit.urlshortner.entity.Shortened;

public interface UrlShortenedService {
	public Shortened longUrlfinnder(String id);
	public List<Shortened> getAllShortenedUrl();
	public void saveOrUpdate(Shortened shortend);
	public Shortened findByShortId(String shortid);
	public void setShortUrl(String randomChar,Shortened shortened);
	public String randomAlphaNumeric();
	
}
