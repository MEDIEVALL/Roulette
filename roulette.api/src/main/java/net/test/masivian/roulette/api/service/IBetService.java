package net.test.masivian.roulette.api.service;

import java.util.List;

import net.test.masivian.roulette.api.model.Bet;

public interface IBetService {
	
	List<Bet>findAllBets();
	void save(Bet bet);
	
}
