package un.bank;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import un.bank.entities.Account;

@Stateless(name="BK")
public class BankEJBImpl implements BankLocal, BankRemote{

	@PersistenceContext(unitName="BankEJB")
	private EntityManager em;
	
	@Override
	public Account addAccount(Account acc) {
		em.persist(acc);
		return acc;
	}

	@Override
	public Account getAccount(Long code) {
		Account acc = em.find(Account.class, code);
		if(acc == null) throw new RuntimeException("Account not found");
		return acc;
	}

	@Override
	public List<Account> listAccounts() {
		Query qy = em.createQuery("select c from ACCOUNT c");
		return qy.getResultList();
	}

	@Override
	public void credit(Long code, double amt) {
		Account acc = getAccount(code);
		acc.setBalance(acc.getBalance() + amt);
	}

	@Override
	public void withdraw(Long code, double amt) {
		Account acc = getAccount(code);
		if(acc.getBalance() < amt) throw new RuntimeException("Insufficient account balance");
		else acc.setBalance(acc.getBalance() - amt);
	}

	@Override
	public void transfer(Long code1, Long code2, double amt) {
		withdraw(code1, amt);
		credit(code2, amt);
	}

}
