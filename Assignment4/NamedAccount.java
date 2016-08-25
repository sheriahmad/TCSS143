/*
 * NamedAccount.java
 * 
 * TCSS 143 Fall 2015
 * Assignment4 
 */

/**
 * Interface NamedAccount. 
 * @author sahmad
 *@version Fall 2015
 */
public interface NamedAccount {
	
	/**
	 * @return my customer name. 
	 */
	String getAccountHolderName();
	
	/**
	 * 
	 * @param theNewName
	 */
	void setAccountHolderName(final String theNewName);

}
