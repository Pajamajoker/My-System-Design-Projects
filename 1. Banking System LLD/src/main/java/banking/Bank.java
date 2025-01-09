package banking;

import java.util.LinkedHashMap;

/**
 * Private Variables:<br>
 * {@link #accounts}: List&lt;Long, Account&gt;
 */
public class Bank implements BankInterface {
	private LinkedHashMap<Long, Account> accounts;
	private static long newAvailableAccountId = 0;
	public Bank() {
		// complete the function
	}

	private Long getAvailableAccountId(){

		newAvailableAccountId++;
		return newAvailableAccountId;

	}

	private Account getAccount(Long accountNumber) {
        return accounts.get(accountNumber);
	}

	public Long openCommercialAccount(Company company, int pin, double startingDeposit) {
		
		Long newAvailableAccountId = getAvailableAccountId();
		Account newCommercialAccount = new CommercialAccount(company, newAvailableAccountId, pin, startingDeposit);
		
		return newCommercialAccount.getAccountNumber();
	}

	public Long openConsumerAccount(Person person, int pin, double startingDeposit) {

		Long newAvailableAccountId = getAvailableAccountId();

        Account newConsumerAccount = new ConsumerAccount(person, newAvailableAccountId, pin, startingDeposit);
		
		return newConsumerAccount.getAccountNumber();
	}

	public boolean authenticateUser(Long accountNumber, int pin) {

		Account account = getAccount(accountNumber);
		
		return account.validatePin(pin);

	}

	public double getBalance(Long accountNumber) {
		Account account = getAccount(accountNumber);
		
		return account.getBalance();
	}

	public void credit(Long accountNumber, double amount) {
		
		Account account = getAccount(accountNumber);
		account.creditAccount( amount);
	
	}

	public boolean debit(Long accountNumber, double amount) {
		
		Account account = getAccount(accountNumber);
		
		return account.debitAccount(amount);
	}
}
