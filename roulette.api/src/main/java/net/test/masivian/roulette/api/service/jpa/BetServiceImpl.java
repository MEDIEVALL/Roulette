package net.test.masivian.roulette.api.service.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.test.masivian.roulette.api.model.Bet;
import net.test.masivian.roulette.api.repository.BetRepository;
import net.test.masivian.roulette.api.service.IBetService;

@Service
public class BetServiceImpl implements IBetService {
	
	@Autowired
	private BetRepository repoBet;
	
	@Override
	public List<Bet> findAllBets() {
		// TODO Auto-generated method stub
		return repoBet.findAll();
	}

	@Override
	public void save(Bet bet) {
		repoBet.save(bet);
		
	}

}
