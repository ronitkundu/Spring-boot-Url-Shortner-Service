package com.ronit.urlshortner;


import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import com.ronit.urlshortner.controller.UrlShortnerController;
import com.ronit.urlshortner.controller.UrlShortnerRestController;
import com.ronit.urlshortner.entity.Shortened;
import com.ronit.urlshortner.repository.UrlShortnerRepoImpl;
import com.ronit.urlshortner.service.UrlShortenedServiceImpl;

@SpringBootTest
@AutoConfigureMockMvc
class UrlShortnerApplicationTests {
	
	
		@Autowired
		private WebApplicationContext webApplicationContext;
		@InjectMocks 
		UrlShortnerRestController urlrestcontroller;
		
		@InjectMocks 
		UrlShortnerController urlcontroller;
		
		
		@Mock
		UrlShortenedServiceImpl empservice;
    
		@Mock
		UrlShortnerRepoImpl dao;
		@Autowired
        private MockMvc mockMvc;
   
	   @Before
	   public void init() {
	       MockitoAnnotations.initMocks(this);
	       
	   }
	@Test
	@DisplayName("Test 1 is used to check if all the short urls are getting fetched from Shortened table  ")
	public void getAllUrl() throws MalformedURLException {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
		List<Shortened> list = new ArrayList<Shortened>();
		Shortened empOne = new Shortened(1, "http://localhost:8080/dfg", "WvL0m", 1);
		Shortened empTwo = new Shortened(2, "http://localhost:8080/abc", "kolenc", 2);
        Shortened empThree = new Shortened(3, "http://localhost:8080/xyz", "Waugh", 2);
        
       list.add(empOne);
       list.add(empTwo);
       list.add(empThree);
       when(empservice.getAllShortenedUrl()).thenReturn(list);
       
		
       
       ResponseEntity<List<Shortened>> responseEntity=urlrestcontroller.getAllUrl();
       List<Shortened> allFetchedUrls = new ArrayList<Shortened>();
       allFetchedUrls=responseEntity.getBody();
       assertEquals(3, allFetchedUrls.size());
       assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
		
	}
	
	@Test
	@DisplayName("Test 2 getShortenUrl function with different conditions  ")
	public void getShortenUrlTest() throws MalformedURLException, URISyntaxException {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        
        
		List<Shortened> list = new ArrayList<Shortened>();
		Shortened empOne = new Shortened(1, "http://localhost:8080/dfg", "WvL0m", 1);
		Shortened empTwo = new Shortened(2, "http://localhost:8080/abc1234", "kolenc", 2);
		Shortened empThree = new Shortened(3, "abc", "Waugh", 2);
		Shortened empFour= new Shortened(4, "http://localhost:8080/xyaa", "WvL0m", 1);
        list.add(empOne);
        list.add(empTwo);
        list.add(empThree);
       
       when(dao.findAll()).thenReturn(list);
     
       
       
       ResponseEntity<Object> responseEntity = urlrestcontroller.getShortenUrl(empFour);
       ResponseEntity<Object> responseEntity1 = urlrestcontroller.getShortenUrl(empThree);
       ResponseEntity<Object> responseEntity2 = urlrestcontroller.getShortenUrl(empTwo);
       
       Shortened empFive=(Shortened) responseEntity2.getBody();
       assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
       assertThat(responseEntity1.getStatusCodeValue()).isEqualTo(400);
       assertThat(empFive.getShortid()).isEqualTo("kolenc");
       
	}
	 
	
	@Test
	@DisplayName("Test Long url return from short url  ")
    public void getLongURllink() throws Exception {
	
		Shortened shortenedEntity = new Shortened(2, "http://localhost:8080/abc1234", "kolenc", 2);
		 when(dao.findByShortID("kolenc")).thenReturn(shortenedEntity);
    mockMvc.perform(get("/longURl/kolenc", 1L))
    .andExpect(status().isOk());
    mockMvc.perform(get("/longURl/hhhhhhhhhhhhhh", 1L))
    .andExpect(forwardedUrl("/WEB-INF/jsp//error:.jsp"));
    }
	
	
	@Test
	@DisplayName("Test Home page  ")
    public void testHomePage() throws Exception {

		
    mockMvc.perform(get("/", 1L))
    .andExpect(status().isOk())
    .andExpect(forwardedUrl("/WEB-INF/jsp/index.jsp"));
    }

}
