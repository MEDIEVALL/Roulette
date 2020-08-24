package net.test.masivian.roulette.api.service;

import java.util.List;

import net.test.masivian.roulette.api.model.Roulette;

public interface IRouletteService {

	List<Roulette>findAllRoulettes();
	void save(Roulette roulette);
	public String bet( int number, int money, int idrulette);
}
