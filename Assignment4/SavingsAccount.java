/*
 * SavingsAcount.java
 * TCSS 143 Fall 2015
 * Assignment4 
 */
/**
 * This class represents a more specialized type of bank
 * account, a savings account. In addition to the properties
 * of a bank account, a savings account should record an
 * active/inactive status property (as a private field). A
 * savings account is considered active if the account
 * balance is at least $25, otherwise the account is
 * considered inactive. Withdrawals cannot be successfully
 * completed from an inactive account. The constructor
 * should initialize the owner and interest rate of the
 * SavingsAccount object to the specified values.
 * 
 * @author sahmad
 * @version Fall 2015
 */
public class SavingsAccount extends BankAccount {
	/**
	 * stores the myStatusIsActive true or false. 
	 */
	private boolean myStatusIsActive;
	
	/**
	 * Stores my active balance. 
	 */
	private final double MY_ACTIVE_BALANCE;

	/**
	 * Makes an appropriate call to SavingsAccount’s super
	 * class constructor and also initializes the
	 * myStatusIsActive field to an appropriate value.
	 * 
	 * @param theNameOfOwner
	 * @param theInterestRate
	 */
	public SavingsAccount(String theNameOfOwner,
			double theInterestRate) {
		// TODO Auto-generated constructor stub
		super(theNameOfOwner, theInterestRate);
		myStatusIsActive = false;
		MY_ACTIVE_BALANCE = 25;
	}

	/**
	 * Adds “theAmount” to the SavingsAccount object’s
	 * balance following the same rules as the deposit
	 * method of the BankAccount class. In addition, if the
	 * account balance after a successful deposit is at
	 * least $25 dollars, the account status should be
	 * active.
	 * 
	 * @param theAmount
	 * @return myStatusIsActive
	 */
	public boolean processDeposit(final double theAmount) {
		double balance = super.getBalance() + theAmount;
		super.processDeposit(balance);
		if (balance >= MY_ACTIVE_BALANCE) {
			myStatusIsActive = true;
		} else {
			myStatusIsActive = false;
		}
		return myStatusIsActive;

	}

	/**
	 * Subtracts “theAmount” from the SavingsAccount
	 * object’s balance, as with the processWithdrawal
	 * method of the BankAccount class. If the account is
	 * inactive, the withdrawal should fail. If the
	 * withdrawal succeeds and the resulting balance is less
	 * than $25, the account status should become inactive
	 * after the money is withdrawn. Finally, the 5th
	 * successful withdrawal and any subsequent successful
	 * withdrawals each incur a $1 service charge, to be
	 * deducted from the account at the end of the month by
	 * the performMonthlyProcess method as described next.
	 * 
	 * @param theAmount
	 * @return myStatusIsActive
	 */
	public boolean processWithdrawal(final double theAmount) {
		boolean statusOfWithdraw = false;
		// If the account is active, proceed.
		if (myStatusIsActive) {
			// If withdrawal was a success, proceed.
			if (statusOfWithdraw = super.processWithdrawal(theAmount)) {
				// Check to see how often withdrawals have
				// been made and
				// charge appropriately.
				if (myMonthlyWithdrawCount >= 5) {
					myMonthlyServiceCharges++;
				}
				// Toggle active/inactive based on remaining
				// balance.
				if (super.getBalance() < 25) {
					myStatusIsActive = false;
				} 
			}
		}
		return statusOfWithdraw;
	}

	/**
	 * This method performs the same monthly processing as
	 * is done in the super class but also, updates the
	 * myStatusIsActive value based on the balance, i.e. it
	 * is set to true if the balance is greater than or
	 * equal to $25.00 and false otherwise.
	 */
	public void performMonthlyProcess() {
		super.performMonthlyProcess();
		double balance = super.getBalance();
		if (balance >= MY_ACTIVE_BALANCE) {
			myStatusIsActive = true;
		} else {
			myStatusIsActive = false;
		}
	}

	/**
	 * returns a String which includes the name of the class
	 * and then a comma separated list of label/value pairs
	 * for each field of the class. This list is contained
	 * in square brackets.
	 * 
	 * @return toString
	 */
	public String toString() {
		return "SavingsAccount[owner: " + super.getAccountHolderName()
				+ ", balance: "
				+ String.format("%.2f", super.getBalance())
				+ ", interest rate: " + super.getRate()
				+ ", \n\tnumber of withdrawls this month: "
				+ super.myMonthlyWithdrawCount + ", "
				+ "service charges for this month: "
				+ String.format("%.2f", super.myMonthlyServiceCharges)
				+ "," + " myStatusisActive: " + this.myStatusIsActive
				+ "]";
	}
}
