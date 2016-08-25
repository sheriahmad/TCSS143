/*
 * SafeDepositBoxAccount.java
 * TCSS 143 Fall 2015
 * Assignment4 
 */
/**
 * This class represents the rental of a bank's safe deposit box to a customer. 
 * Because banks do not know what is stored in the safe deposit box, the only 
 * information that the class will keep track of is the name of the person who 
 * owns the safe deposit box account (as a private field).
 * 
 * @author sahmad
 * @version Fall 2015
 */
public class SafeDepositBoxAccount implements NamedAccount {
	
	/**
	 * Stores myCustomerName. 
	 */
	private String myCustomerName;
	
	/**
	 * @param theNameOfHolder
	 */
	public SafeDepositBoxAccount(final String theNameOfHolder) {
		myCustomerName = theNameOfHolder;
	}
	
	
	/**
	 * @return myCustomerName
	 */
	public String getAccountHolderName() {
		return myCustomerName;
	}
	
	
	/**
	 * @param theNameOfHolder
	 */
	public void setAccountHolderName(final String theNameOfHolder) {
		myCustomerName = theNameOfHolder;
	}
	
	
	/**
	 * returns a String which includes the name of the class and then a comma 
	 * separated list of label/value pairs for each field of the class. 
	 * This list is contained in square brackets.
	 * @return toString 
	 */
	public String toString() {
		return "SafeDepositBoxAccount [owner:" + myCustomerName + "]";
	}
}
