/*
 * BankAccount.java
 * TCSS 143 Fall 2015
 * Assignment4 
 */
/**
 * Represents a basic bank account.
 * 
 * @author sahmad
 * @version Fall
 */
public class BankAccount implements NamedAccount {
	
	/**
	 * Stores account holder's name. 
	 */
	private String myCustomerName; 
	
	/**
	 * Stores the account balance. 
	 */
	private double myAccountBalance; 
	
	/**
	 * Stores the interest rate. 
	 */
	private double myInterestRate;
	
	/**
	 * stores monthly withdraw count. 
	 */
	protected int myMonthlyWithdrawCount; 
	
	/**
	 * Stores monthly service charge. 
	 */
	protected double myMonthlyServiceCharges; 

	/**
	 * The constructor initializes the name and interest rate to the values of
	 * the passed parameters (taking care that the interest rate is a legitimate
	 * value) and sets the remaining fields to 0.
	 * 
	 * @param theNameOfOwner
	 * @param theInterestRate
	 */
	public BankAccount(final String theNameOfOwner,
			final double theInterestRate) {
		myCustomerName = theNameOfOwner;
		if (theInterestRate > 0.0) {
			myInterestRate = theInterestRate;
		} else {
			myInterestRate = 0.0;
		}

		myAccountBalance = 0.0;
		myMonthlyWithdrawCount = 0;
		myMonthlyServiceCharges = 0.0;
	}

	/**
	 * 
	 * @return myAccountBalance
	 */
	public double getBalance() {
		return myAccountBalance;
	}

	/**
	 * 
	 * @return interest rate
	 */
	public double getRate() {
		return myInterestRate;
	}

	/**
	 * Adds the specified amount of money to the calling BankAccount object.
	 * However, if the “theAmount” of money is zero or negative, the deposit
	 * fails (it's not possible to withdraw money by depositing a negative
	 * amount), the account balance is unchanged, and the method should return
	 * false. Otherwise, if the amount of money is positive, the deposit
	 * succeeds and the method should return true.
	 * 
	 * @param theAmount
	 * @return true if deposited amount is positive.
	 */
	public boolean processDeposit(final double theAmount) {
		boolean deposite = false;
		if (theAmount > 0) {
			myAccountBalance += theAmount;
			deposite = true;
		} else {
			deposite = false;
		}
		return deposite;
	}

	/**
	 * Subtracts the specified amount of money from the calling BankAccount
	 * object. However, if the amount of money is not a positive value or is
	 * more than the current balance of the account, the withdraw fails, the
	 * account balance is unchanged, and the method should return false.
	 * Otherwise, the withdrawal succeeds, the record of successful withdrawals
	 * made in the current month is incremented, and the method should return
	 * true.
	 * 
	 * @param theAmount
	 * @return true if withdraw is successful.
	 */
	public boolean processWithdrawal(final double theAmount) {

		boolean withdraw = false;
		if (theAmount > 0 && theAmount <= myAccountBalance) {
			myAccountBalance -= theAmount;
			withdraw = true;
			myMonthlyWithdrawCount += 1;
		} else {
			withdraw = false;
		}
		return withdraw;
	}

	/**
	 * Subtracts all monthly service charges from the balance, adds the monthly
	 * interest accrued to the balance through a call to calculateInterest(),
	 * and resets the withdrawal count and service charge amount to 0. Finally,
	 * the balance should not be set to anything less than 0.
	 */
	public void performMonthlyProcess() {
		if (myAccountBalance - myMonthlyServiceCharges >= 0) {
			myAccountBalance -= myMonthlyServiceCharges;
		}
		myAccountBalance += calculateInterest();
		myMonthlyWithdrawCount = 0;
		myMonthlyServiceCharges = 0.0;
	}

	/**
	 * Returns the monthly interest based on the APR (Annual Percentage Rate).
	 * 
	 * @return calculated interest.
	 */
	public double calculateInterest() {
		return myAccountBalance * ((double) myInterestRate / 12.0);
	}

	/**
	 * 
	 * @param theNewName
	 */
	public void setAccountHolderName(final String theNewName) {
		myCustomerName = theNewName;
	}

	/**
	 * 
	 * @return myCustomerName
	 */
	public String getAccountHolderName() {
		return myCustomerName;
	}

	// Extra methods.
	/**
	 * A getter for the monthly withdraw count. Set to protected to prevent
	 * direct client access while keeping accessibility to child classes.
	 * 
	 * @return the monthly withdraw count.
	 */
	protected int getMonthlyWithdrawCount() {
		return myMonthlyWithdrawCount;
	}

	/**
	 * A getter for the monthly service charges. Set to protected to prevent
	 * direct client access while keeping accessibility to child classes.
	 * 
	 * @return monthly service charges amount.
	 */
	protected double getMonthlyServiceCharges() {
		return myMonthlyServiceCharges;
	}

	/**
	 * A getter for the monthly service charges. Set to protected to prevent
	 * direct client access while keeping accessibility to child classes.
	 * 
	 * @return the interest rate for the account.
	 */
	protected double getInterestRate() {
		return myInterestRate;
	}

	// String.format("%.2f", myMonthlyServiceCharges);
	/**
	 * returns a String which includes the name of the class and then a comma
	 * separated list of label/value pairs for each field of the class. This
	 * list is contained in square brackets.
	 * 
	 * @return string
	 */
	public String toString() {
		return "BankAccount[owner: " + myCustomerName + ", balance: "
				+ String.format("%.2f", myAccountBalance) + ""
				+ ", interest rate: "
				+ String.format("%.2f", myInterestRate)
				+ ", \n\tnumber of withdrawals this month: "
				+ myMonthlyWithdrawCount
				+ ", service charges for this month: "
				+ String.format("%.2f", myMonthlyServiceCharges) + "]";
	}
}
