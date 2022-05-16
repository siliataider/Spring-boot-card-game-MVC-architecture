package com.sp.rest;

  import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
  import org.springframework.web.bind.annotation.RestController;

  import com.sp.model.Hero;
  import com.sp.service.HeroService;

  @RestController
  public class HeroRestCrt {
      @Autowired
      HeroService hService;
      
      @RequestMapping("/salut")
	  	public String sayHello() {
	  		return "Salut Hero !!!";
	  	}
      @RequestMapping(method=RequestMethod.POST,value="/hero")
      public void addHero(@RequestBody Hero hero) {
          hService.addHero(hero);
      }
      
      @RequestMapping(method=RequestMethod.GET,value="/hero/{id}")
      public Hero getHero(@PathVariable String id) {
          Hero h=hService.getHero(Integer.valueOf(id));
          return h;
      }
      
      @RequestMapping(value="/{id}/buy")
      public String getBuyList() {
    	  List<Hero> h = hService.getBuyList();
    	  return(h.toString());
      }
      
      @RequestMapping(method=RequestMethod.PATCH,value="/{id}/buy")
      public void buy(@PathVariable String idUser,String idCard) {
    	  Boolean result= hService.buy(Integer.valueOf(idUser),Integer.valueOf(idCard));
      }
  }
