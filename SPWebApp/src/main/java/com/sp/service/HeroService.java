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
	
	public List<Hero> getUserCollection(String idUser){
		List<Hero> userCollection = new LinkedList<Hero>();		
		return(userCollection);
	}


	public Boolean buy(Integer idUser, Integer idCard) {
		Optional<Hero> optionalCard = hRepository.findById(idCard);
		Hero card = optionalCard.get();
		card.setOwned(true);
		//userService.addCard(card);
		return null;
	}

}

