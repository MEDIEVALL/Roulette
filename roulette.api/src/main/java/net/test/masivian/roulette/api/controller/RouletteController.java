package net.test.masivian.roulette.api.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.test.masivian.roulette.api.model.Bet;
import net.test.masivian.roulette.api.model.Roulette;
import net.test.masivian.roulette.api.repository.BetRepository;
import net.test.masivian.roulette.api.repository.RouletteRpository;
import net.test.masivian.roulette.api.service.IBetService;
import net.test.masivian.roulette.api.service.IRouletteService;

@RestController
@RequestMapping("/api")
public class RouletteController {

	@Autowired
	private IRouletteService serviceRoulette;
	
	@Autowired
	private RouletteRpository repo;
	
	@Autowired
	private BetRepository repobet;
	
	
	@Autowired
	private IBetService serviceBet;
	
	@PostMapping("/roulette")
	public Integer create() {
		Roulette roulette= new Roulette();
		roulette.setStatus(0);
		serviceRoulette.save(roulette);
		
		return roulette.getId();
	}
	
	@PutMapping("/roulette/open/{id}")
	public String modificar(@PathVariable("id")String idroulette) {
		try {
			int auxId= Integer.parseInt(idroulette);
			Roulette roulette= new Roulette();
			roulette.setId(auxId);
			roulette.setDate_open(new Date());
			roulette.setStatus(1);
			serviceRoulette.save(roulette);
			
			return "succesfully";
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "Denied";
	}
	
	
	@PostMapping("/roulette/bet/{number}/{money}/{idrulette}")
	public String bet(@PathVariable("number") int number,@PathVariable("money") int money,@PathVariable("idrulette") int idrulette) {
		
		return serviceRoulette.bet(number, money, idrulette);
	}
	
	
	@GetMapping("/roulette")
	public List<Roulette>findAllRoulettes(){
		
		return serviceRoulette.findAllRoulettes();
	}
}
