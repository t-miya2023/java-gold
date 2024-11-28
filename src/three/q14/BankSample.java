package three.q14;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BankSample {

	public static void main(String[] args) throws Exception{
		// TODO 自動生成されたメソッド・スタブ
		BankAccount a = new BankAccount(100);
		BankAccount b = new BankAccount(100);
		
		ExecutorService exec = Executors.newFixedThreadPool(2);
		//aから出金してbに入金
		exec.submit(()->{
			synchronized(a) {
				a.withdrawals(20);
				synchronized(b) {
					b.deposit(20);
					System.out.println("aの残高：" + a.getBalance());
					System.out.println("bの残高：" + b.getBalance());
				}
			}
		});
		//デッドロックが起きる
		/*
		exec.submit(()->{
			synchronized(b) {
				b.withdrawals(30);
				synchronized(a) {
					a.deposit(30);
					System.out.println("aの残高：" + a.getBalance());
					System.out.println("bの残高：" + b.getBalance());
				}
			}
		});
		*/
		//処理の流れを一定にすることでデットロックは対策できる　a->b
		exec.submit(()->{
			synchronized(a) {
				a.deposit(30);
				synchronized(b) {
					b.withdrawals(30);
					System.out.println("aの残高：" + a.getBalance());
					System.out.println("bの残高：" + b.getBalance());
				}
			}
		});
		
		
		exec.shutdown();
	}

}
