package com.sp.rest;

  import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;

  import com.sp.model.Card;
  import com.sp.service.CardService;
  @RestController
  public class CardRestCrt {
      @Autowired
      CardService hService;
      
      @RequestMapping(method=RequestMethod.POST,value="/hero")
      public void addCard(@RequestBody Card card) {
          hService.addCard(card);
      }
     
      
      @RequestMapping(method=RequestMethod.GET,value="/card/{id}")
      public Card getCard(@PathVariable String id) {
          Card h=hService.getCard(Integer.valueOf(id));
          return h;
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/{id}/buy")
      public String getBuyList() {
    	  List<Card> list = hService.getBuyList();
    	  return(list.toString());
      }
      
      @RequestMapping(method=RequestMethod.PUT,value="/{id}/buy")
      public void buy(@PathVariable String idUser,String idCard) {
    	  hService.buy(Integer.valueOf(idUser),Integer.valueOf(idCard));
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/{id}/sell")
      public String getUserList(@PathVariable String idUser,String idCard) {
    	  List<Card> list = hService.getUserCollection(idUser);
    	  return(list.toString());
      }
      
      @RequestMapping(method=RequestMethod.PUT,value="/{id}/sell")
      public void sell(@PathVariable String idUser,String idCard) {
    	  hService.sell(Integer.valueOf(idUser),Integer.valueOf(idCard));
      }
      
  }
