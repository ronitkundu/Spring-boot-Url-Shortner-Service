package com.ronit.urlshortner.controller;


import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;


import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ronit.urlshortner.entity.Shortened;
import com.ronit.urlshortner.service.UrlShortenedService;


@RestController
public class UrlShortnerRestController {
	
	
	@Autowired
	UrlShortenedService urlShortenedServiceImpl;
	
	@RequestMapping(value="/shortenurl",method=RequestMethod.POST)
	public ResponseEntity<Object> getShortenUrl(@RequestBody Shortened shortened) throws URISyntaxException, MalformedURLException{
	
		UrlValidator urlValidator=new UrlValidator(UrlValidator.ALLOW_LOCAL_URLS);
		

		if(urlValidator.isValid(shortened.getLongid())||shortened.getLongid().isEmpty()){
			Shortened longCheck = urlShortenedServiceImpl.longUrlfinnder(shortened.getLongid());
			if(Objects.isNull(longCheck)){
				
			
				String randomUrl=urlShortenedServiceImpl.randomAlphaNumeric();
				urlShortenedServiceImpl.setShortUrl(randomUrl,shortened);
				shortened.setHitcount(1);
				urlShortenedServiceImpl.saveOrUpdate(shortened);

				return new ResponseEntity<Object>(shortened,HttpStatus.OK);
			}
		
			else {
				return new ResponseEntity<Object>(longCheck,HttpStatus.OK);
			}
		}
		else {
			return new ResponseEntity<Object>("Invalid URL provided",HttpStatus.BAD_REQUEST);

		}
		

		
	}
	
	
	
	
	
	
	
	@RequestMapping(value="/allUrls",method=RequestMethod.POST)
	public ResponseEntity<List<Shortened>> getAllUrl(){
		//System.out.println(shortened.getLongid());
		List<Shortened> getAllShortenedUrl=urlShortenedServiceImpl.getAllShortenedUrl();
		
		
		//System.out.println(getAllShortenedUrl.size());

		return new ResponseEntity<List<Shortened>>(getAllShortenedUrl,HttpStatus.OK);
	}
	
	
	
	
	
	
}

