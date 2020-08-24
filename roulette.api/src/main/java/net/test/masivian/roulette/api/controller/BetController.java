package net.test.masivian.roulette.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.test.masivian.roulette.api.model.Bet;
import net.test.masivian.roulette.api.service.IBetService;

@RestController
@RequestMapping("/api")
public class BetController {

	@Autowired
	private IBetService serviceBet;
	
	@GetMapping("/bet")
	public List<Bet>findAllBets(){
		
		return serviceBet.findAllBets();
	}
}
