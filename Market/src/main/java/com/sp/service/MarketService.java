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
            "http://localhost:8080/buy", DTO_Card[].class);
		return response.getBody();
	}
}
