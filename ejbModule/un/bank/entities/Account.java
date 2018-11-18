package un.bank.entities;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: account
 *
 */
@Entity
public class Account implements Serializable {
	   
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="account_id_seq")
	@SequenceGenerator(name="account_id_seq", sequenceName="ACCOUNT_ID_SEQ")
	private Long code;
	private double balance;
	private Date dateCreation;
	private static final long serialVersionUID = 1L;

	public Account() {
		super();
	}
	
	
	public Account(Long code, double balance, Date dateCreation) {
		super();
		this.code = code;
		this.balance = balance;
		this.dateCreation = dateCreation;
	}


	public Long getCode() {
		return this.code;
	}

	public void setCode(Long code) {
		this.code = code;
	}   
	public double getBalance() {
		return this.balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}   
	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
   
}
