package it.unibo.oop.lab.exception2;

public class NotEnoughFoundsException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1159808475879283028L;

	private final double balance;
	private final double amount;
	
	public NotEnoughFoundsException(double balance, double amount) {
		super();
		this.balance = balance;
		this.amount = amount;
	}


	public String toString() {
		return "NotEnoughFounds [balance=" + balance + ", amount=" + amount + "]";
	}
	
	
	
}
