package three.q14;

public class BankAccount {

	private int balance;
	public BankAccount(int balance) {
		this.balance = balance;
	}
	//入金処理
	public void deposit(int amount) {
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		this.balance += amount;
	}
	
	//出金処理
	public void withdrawals(int amount) {
		try {
			Thread.sleep(100);
		}catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
		
		this.balance -= amount;
	}
	
	public int getBalance() {
		return balance;
	}
}
