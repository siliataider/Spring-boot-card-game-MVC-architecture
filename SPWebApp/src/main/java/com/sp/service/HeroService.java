package com.sp.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Hero;
import com.sp.repository.HeroRepository;

@Service
public class HeroService {
	@Autowired
	HeroRepository hRepository;
	//UserService uService;
	
	
	public void addHero(Hero h) {
		Hero createdHero=hRepository.save(h);
		System.out.println(createdHero);
	}
	
	public Hero getHero(int id) {
		Optional<Hero> hOpt = hRepository.findById(id);
		if (hOpt.isPresent()) {

			return hOpt.get();
		}else {
			return null;
		}
	}
	
	public List<Hero> getUserCollection(String idUser){
		List<Hero> userCollection = null; //userService.getCards();	
		return(userCollection);
	}
	
	public List<Hero> getBuyList(){
		List<Hero> buyList =  new LinkedList<Hero>();
		Iterable<Hero> cardIt = hRepository.findAll();
		cardIt.forEach((hero) -> {
									if(hero.getOwned() == false){
										buyList.add(hero);
										}
								}
		);
		
		return(buyList);
	}


	public void buy(Integer idUser, Integer idCard) {
		Hero card = getHero(idCard);
		card.setOwned(true);
		//userService.addCard(card);
		//userService.transaction(-card.getValue())
	}
	
	public void sell(Integer idUser, Integer idCard) {
		Hero card = getHero(idCard);
		card.setOwned(false);
		//userService.removeCard(card);
		//userService.transaction(+card.getValue())
		
	}
	
	
	

}

