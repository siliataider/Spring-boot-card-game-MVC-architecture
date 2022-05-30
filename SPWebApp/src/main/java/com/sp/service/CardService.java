package com.sp.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.model.Card;
import com.sp.repository.CardRepository;

@Service
public class CardService {
	@Autowired
	CardRepository hRepository;
	//UserService uService;
	
	
	public void addCard(Card h) {
		Card createdHero=hRepository.save(h);
		System.out.println(createdHero);
	}
	
	public Card getCard(int id) {
		Optional<Card> hOpt = hRepository.findById(id);
		if (hOpt.isPresent()) {

			return hOpt.get();
		}else {
			return null;
		}
	}
	
	public List<Card> getUserCollection(String idUser){
		List<Card> userCollection = null; //userService.getCards();	
		return(userCollection);
	}
	
	public List<Card> getBuyList(int idUser){
		List<Card> buyList =  new LinkedList<Card>();
		Iterable<Card> cardIt = hRepository.findAll();
		cardIt.forEach((card) -> {
									if(card.getId_user() == idUser){
										buyList.add(card);
										}
								}
		);
		
		return(buyList);
	}


	public void buy(Integer idUser, Integer idCard) {
		Card card = getCard(idCard);
		card.setId_user(idUser);
	}
	
	public void sell(Integer idUser, Integer idCard) {
		Card card = getCard(idCard);
		card.setId_user(0);
	}
	
	
	

}

