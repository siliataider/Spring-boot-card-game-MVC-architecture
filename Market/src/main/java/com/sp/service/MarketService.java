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
	
	public DTO_Card[] getBuyList(String idUser) {
		ResponseEntity<DTO_Card[]> response
        = new RestTemplate().getForEntity(
            "http://localhost:8081/buy/"+idUser, DTO_Card[].class);
		return response.getBody();
	}
	
	public DTO_Card[] getSellList(String idUser) {
		ResponseEntity<DTO_Card[]> response
        = new RestTemplate().getForEntity(
            "http://localhost:8081/sell/"+idUser, DTO_Card[].class);
		return response.getBody();
	}

	public void buy(String id_user,String id_card) {
		new RestTemplate().postForEntity("http://localhost:8081/buy/"+ id_user +"/"+id_card, new DTO_Card(Integer.valueOf(id_card),Integer.valueOf(id_user)), Boolean.class);
	}

	public void sell(String id_user,String id_card) {
		new RestTemplate().postForEntity("http://localhost:8081/sell/"+ id_user +"/"+id_card, new DTO_Card(Integer.valueOf(id_card),Integer.valueOf(id_user)), Boolean.class);
	}
	
	
}
