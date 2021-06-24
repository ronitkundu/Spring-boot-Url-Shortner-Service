package com.ronit.urlshortner.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.ronit.urlshortner.entity.Shortened;

public interface UrlShortnerRepoImpl extends JpaRepository<Shortened, Integer>  
{
	@Query("select u from Shortened u where u.shortid=:shortid")
	Shortened findByShortID(String shortid);  
	
}  