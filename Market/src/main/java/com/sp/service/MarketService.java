package com.sp.service;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sp.dto.DTO_Card;

import antlr.collections.List;

@Service
public class MarketService {
	
	public DTO_Card[] getBuyList() {
		ResponseEntity<DTO_Card[]> response
        = new RestTemplate().getForEntity(
            "http://localhost:8081/buy", DTO_Card[].class);
		return response.getBody();
	}
	
	public DTO_Card[] getSellList(int id_user) {
		ResponseEntity<DTO_Card[]> response
        = new RestTemplate().getForEntity(
            "http://localhost:8081/sell/"+ Integer.toString(id_user), DTO_Card[].class);
		return response.getBody();
	}

	public void buy(int id,int id_user) {
		Boolean response
        = new RestTemplate().patchForObject("http://localhost:8080/buy", new DTO_Card(id,id_user), Boolean.class);
		if(response) {
			
		}
	}

	public void sell(int id,int id_user) {
		Boolean response
        = new RestTemplate().patchForObject("http://localhost:8080/sell/"+ Integer.toString(id_user) +"/"+Integer.toString(id), new DTO_Card(id,id_user), Boolean.class);
		if(response) {
			
		}
	}
	
	
}
