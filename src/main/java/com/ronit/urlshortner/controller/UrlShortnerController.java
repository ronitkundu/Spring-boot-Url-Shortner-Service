package com.ronit.urlshortner.controller;

import java.io.IOException;
import java.util.Objects;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ronit.urlshortner.entity.Shortened;
import com.ronit.urlshortner.service.UrlShortenedServiceImpl;



@Controller
public class UrlShortnerController {

	
	@Autowired
	UrlShortenedServiceImpl urlShortenedServiceImpl;
	
	
	
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView start(){
		
	ModelAndView mv=new ModelAndView("index");
	
	return mv;
	}
	
	  @GetMapping ("/longURl/{id}") private String getLongURllink(@PathVariable
			  String id) throws IOException,NullPointerException {

		  Shortened check= urlShortenedServiceImpl.findByShortId(id);
		  if(!Objects.isNull(check)){
			  check.setHitcount(check.getHitcount()+1);
			  urlShortenedServiceImpl.saveOrUpdate(check);
			  String redirectUrl = check.getLongid();
			  return "redirect:" + redirectUrl;
		  }
		  else {
			  
			  return "/error:";
		  }

		   }
			 
	
}
