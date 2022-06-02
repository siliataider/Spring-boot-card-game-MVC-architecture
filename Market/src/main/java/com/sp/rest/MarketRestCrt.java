package com.sp.rest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sp.dto.DTO_Card;
import com.sp.service.MarketService;

import antlr.collections.List;

@RestController
public class MarketRestCrt {
	@Autowired
    MarketService hService;
	
	 @RequestMapping(method=RequestMethod.GET,value="/buy")
     public DTO_Card[] getBuyList(@RequestBody String idUser) {
        return hService.getBuyList(idUser);
     }
	 
	 @RequestMapping(method=RequestMethod.GET, value="/sell")
	 public DTO_Card[] getSellList(@RequestBody String idUser) {
		 return hService.getSellList(idUser);
	 }
	 
	 @RequestMapping(method=RequestMethod.POST, value="/buy/{id_card}")
	 public void buy(@PathVariable String id_card,@RequestBody String id_user) {
		 hService.buy(id_user,id_card);
	 }
	 
	 @RequestMapping(method=RequestMethod.POST, value="/sell/{id_card}")
	 public void sell(@PathVariable String id_card,@RequestBody String id_user) {
		 hService.sell(id_user,id_card);
	 }
}
