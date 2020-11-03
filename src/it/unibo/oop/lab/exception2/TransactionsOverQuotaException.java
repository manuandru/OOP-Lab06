package it.unibo.oop.lab.exception2;

public class TransactionsOverQuotaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5186015990336694793L;

	@Override
	public String toString() {
		return "Reach the ATM transactions limit";
	}

	
	
}
