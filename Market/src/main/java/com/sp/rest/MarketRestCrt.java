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
     public DTO_Card[] getBuyList(@RequestBody String id) {
        return hService.getBuyList();
     }
}
