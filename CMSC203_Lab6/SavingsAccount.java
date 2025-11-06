
public class SavingsAccount extends BankAccount {
	double rate = 0.025;
	int savingsNumber = 0;
	String accountNumber;
	
	public SavingsAccount(String name, double initial) {
		super(name, initial);
		accountNumber = super.getAccountNumber().concat("-" + savingsNumber);
	}
	
	public SavingsAccount(SavingsAccount other, double initial) {
		super(other, initial);
		savingsNumber = other.savingsNumber + 1;
		accountNumber = super.getAccountNumber().concat("-" + savingsNumber);
	}
	
	public void postInterest() {
		setBalance(getBalance() * (1 + rate / 12.0));
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
}
