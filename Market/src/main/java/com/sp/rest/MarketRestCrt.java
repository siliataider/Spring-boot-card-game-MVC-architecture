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
	 
	 @RequestMapping(method=RequestMethod.PATCH, value="/buy")
	 public void buy(@RequestBody String id,@RequestBody String id_user) {
		 hService.buy(Integer.valueOf(id),Integer.valueOf(id_user));
	 }
	 
	 @RequestMapping(method=RequestMethod.PATCH, value="/sell")
	 public void sell(@RequestBody String id_user,@RequestBody String id) {
		 hService.sell(Integer.valueOf(id),Integer.valueOf(id_user));
	 }
}
