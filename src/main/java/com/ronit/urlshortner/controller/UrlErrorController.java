package com.ronit.urlshortner.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;


import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UrlErrorController implements ErrorController {
	 @Override
	    public String getErrorPath() {
	        return "/error";
	    }

	    @RequestMapping("/error")
	    public ModelAndView handleError(HttpServletRequest request) {
	    	StringBuffer link = request.getRequestURL();
	    	
	    	ModelAndView mav = new ModelAndView("error");
	       
	        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

	        if (status != null) {
	            int statusCode = Integer.parseInt(status.toString());
	            
	            
	            if (statusCode == HttpStatus.NOT_FOUND.value()) {
	            	mav.addObject("status","404");
	            	
	                
	            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
	            	mav.addObject("status","500"); 
	            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
	            	mav.addObject("status","403");
	            }
	        }
	        mav.addObject("link",link);
	        // display generic error
	        return mav;
	    }
}
 