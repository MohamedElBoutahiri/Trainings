package app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Account {

	private @Id @GeneratedValue Long id;
	String name;
	String currency;
	double balance;
	boolean treasury;

}
