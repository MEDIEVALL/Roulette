package net.test.masivian.roulette.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.test.masivian.roulette.api.model.Bet;
import net.test.masivian.roulette.api.model.Roulette;

public interface BetRepository extends JpaRepository<Bet, Integer> {
	
}
