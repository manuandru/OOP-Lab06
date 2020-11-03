package it.unibo.oop.lab.exception2;

import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test to test
 * {@link StrictBankAccount}.
 * 
 */
public class TestStrictBankAccount {

    /**
     * Used to test Exceptions on {@link StrictBankAccount}.
     */
    @Test
    public void testBankOperations() {
        /*
         * 1) Creare due StrictBankAccountImpl assegnati a due AccountHolder a
         * scelta, con ammontare iniziale pari a 10000 e nMaxATMTransactions=10
         * 
         * 2) Effetture un numero di operazioni a piacere per verificare che le
         * eccezioni create vengano lanciate soltanto quando opportuno, cioè in
         * presenza di un id utente errato, oppure al superamento del numero di
         * operazioni ATM gratuite.
         */
    	final AccountHolder a1 = new AccountHolder("Mario", "Rossi", 10);
    	final AccountHolder a2 = new AccountHolder("Luigi", "Verdi", 11);
    	
    	
    	
    	final BankAccount b1 = new StrictBankAccount(a1.getUserID(), 10_000, 10);
    	final BankAccount b2 = new StrictBankAccount(a2.getUserID(), 10_000, 10);
    	
    	try {
			b1.withdraw(a1.getUserID(), 1000);
		} catch (Exception e) {
			System.out.println(e);
		} 
    	Assert.assertEquals("Incorrect withdraw", 9000, b1.getBalance(), 0.001);
    	
    	try {
			b2.withdraw(a2.getUserID(), 15000);
		} catch (Exception e) {
			System.out.println(e);
		}
    	//Assert.fail("Not Enough Founds");
    	Assert.assertEquals("Incorrect withdraw", 10000, b2.getBalance(), 0.001);
    	
    	try {
			b2.withdraw(a1.getUserID(), 15000);
		} catch (Exception e) {
			System.out.println(e);
		}
    	//Assert.fail("Wrong Account");
    	Assert.assertEquals("Incorrect withdraw", 9000, b1.getBalance(), 0.001);
    	
    	
    	for (int i = 0 ; i < 15; i++) {
    		try {
    			b2.withdraw(a2.getUserID(), 100);
    		} catch (Exception e) {
    			System.out.println(e);
    		}
    	}
    	Assert.assertEquals("Incorrect withdraw", 8500, b2.getBalance(), 0.001);
    	
    	System.out.println("b1 balance: " + b1.getBalance()); //expected 9000
    	System.out.println("b2 balance: " + b2.getBalance()); //expected 8500
    	
    }
}
