package net.test.masivian.roulette.api.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roulette")
public class Roulette {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date date_open;
	private Date date_close;
	private int status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getDate_open() {
		return date_open;
	}
	public void setDate_open(Date date_open) {
		this.date_open = date_open;
	}
	public Date getDate_close() {
		return date_close;
	}
	public void setDate_close(Date date_close) {
		this.date_close = date_close;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Roulette [id=" + id + ", date_open=" + date_open + ", date_close=" + date_close + ", status=" + status
				+ "]";
	}
	
	
	
}
