package net.test.masivian.roulette.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="bet")
public class Bet {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int number;
	private String color;
	private double money;
	@OneToOne
	@JoinColumn(name = "idRoulette")
	private Roulette roulette;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public Roulette getRoulette() {
		return roulette;
	}
	public void setRoulette(Roulette roulette) {
		this.roulette = roulette;
	}
	@Override
	public String toString() {
		return "Bet [id=" + id + ", number=" + number + ", color=" + color + ", money=" + money + ", roulette="
				+ roulette + "]";
	}
	
	
	
	
}
