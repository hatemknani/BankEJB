package un.bank;

import java.util.List;

import javax.ejb.Local;

import un.bank.entities.Account;

@Local
public interface BankLocal {
	public Account addAccount(Account acc);
	public Account getAccount(Long code);
	public List<Account> listAccounts();
	public void credit(Long code, double amt);
	public void withdraw(Long code, double amt);
	public void transfer(Long code1, Long code2, double amt);
}
