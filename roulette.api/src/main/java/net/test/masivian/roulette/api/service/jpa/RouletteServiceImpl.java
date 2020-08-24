package net.test.masivian.roulette.api.service.jpa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import net.test.masivian.roulette.api.model.Bet;
import net.test.masivian.roulette.api.model.Roulette;
import net.test.masivian.roulette.api.repository.RouletteRpository;
import net.test.masivian.roulette.api.service.IBetService;
import net.test.masivian.roulette.api.service.IRouletteService;

@Service
public class RouletteServiceImpl implements IRouletteService {

	@Autowired
	private IBetService serviceBet;
	
	@Autowired
	private RouletteRpository repoRoulette;
	
	@Override
	public List<Roulette> findAllRoulettes() {
		// TODO Auto-generated method stub
		return repoRoulette.findAll();
	}

	@Override
	public void save(Roulette roulette) {
		repoRoulette.save(roulette);
		
	}

	

	@Override
	public String bet( int number, int money, int idrulette) {
		
		double aux=0;
		Bet bets = new Bet();
		Roulette roulettes = new Roulette();
		roulettes.setId(idrulette);
		Optional<Roulette>list=repoRoulette.findById(idrulette);
			if (list.isPresent() && list.get().getStatus()==1) {
				List<Bet> lista = serviceBet.findAllBets();
				for (Bet bet : lista) {
					if (bet.getRoulette().getId()== idrulette) {
						aux = bet.getMoney()+aux;
						
					}
				}
				if (aux<10000) {
					bets.setNumber(number);
					bets.setMoney(money);
					bets.setRoulette(roulettes);
					serviceBet.save(bets);
					return "recived bet";
				}else {
					try {
						Roulette roulette= new Roulette();
						roulette.setId(idrulette);
						roulette.setDate_open(new Date());
						roulette.setDate_close(new Date());
						roulette.setStatus(0);
						repoRoulette.save(roulette);
						return " close Roulette";
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
			return "out of service";
	}
}
