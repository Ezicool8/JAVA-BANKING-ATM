import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	private int customerAccountNumber;
	private int pinNumber;
	private double currentBalance = 0;
	private double savingsBalance = 0;
	
	Scanner input = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'₦'###,##0.00");
	
	
	public int getCustomerAccountNumber() {
		return customerAccountNumber;
	}
	public void setCustomerAccountNumber(int customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}
	
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	
	public double getCurrentBalance() {
		return currentBalance;
	}
	public double getSavingsBalance() {
		return savingsBalance;
	}
	
	
	public double currentWithdraw(double amount) {
		this.currentBalance = currentBalance - amount;
		return currentBalance;
	}
	
	public double savingsWithdraw(double amount) {
		this.savingsBalance = savingsBalance - amount;
		return savingsBalance;
	}
	
	public double currentDeposit(double amount) {
		this.currentBalance = currentBalance + amount;
		return currentBalance;
	}
	public double savingsDeposit(double amount) {
		this.savingsBalance = savingsBalance + amount;
		return savingsBalance;
	}
	
	/* Customer Current Account Withdraw input */
	public void getCurrentWithdrawIput() {
		System.out.println("Your Current Account Balance is : " + moneyFormat.format(currentBalance));
		System.out.print("Please enter the amount you want to withdraw from your Current Account: ");
		double amount = input.nextDouble();

		if ((currentBalance - amount) >= 0) {
			currentWithdraw(amount);
			System.out.println("Kindly Take Your Cash From The Shutter" + "\n");
			System.out.println("New Current Account balance: " + moneyFormat.format(currentBalance) + "\n");
		} 
		else if (amount > currentBalance ){
			System.out.println("Sorry, you cannot withdraw more than you balance : " + moneyFormat.format(currentBalance) + "\n");
		}
		else {
			System.out.println("Balance cannot be negative. You can only withdraw " + moneyFormat.format(currentBalance) + "\n");
		}
	} //ends  getCurrentWithdrawIput
	
	/* Customer Savings Account Withdraw input */
	public void getSavingsWithdrawInput() {
		System.out.println("Your Savings Account Balance is : " + moneyFormat.format(savingsBalance));
		System.out.print("Please enter the amount you want to withdraw from your Savings Account: ");
		double amount = input.nextDouble();

		if ((savingsBalance - amount) >= 0) {
			savingsWithdraw(amount);
			System.out.println("Kindly Take Your Cash From The Shutter" + "\n");
			System.out.println("New Saving Account balance: " + savingsBalance + "\n");
		} else if (amount > savingsBalance ){
			System.out.println("Sorry, you cannot withdraw more than you balance : " + moneyFormat.format(savingsBalance) + "\n");
		}
		else {			
			System.out.println("Balance cannot be negative. You can only withdraw " + moneyFormat.format(savingsBalance) + "\n");
		}
		
	}
	
	/* Customer Current Account Deposit input */
	public void getCurrentDepositInput() {
		System.out.println("Your Current Account Balance is : " + moneyFormat.format(currentBalance));
		System.out.print("Kindly enter the amount you want to deposit into your Current Account (₦) :");
		double amount = input.nextDouble();

		if ((currentBalance + amount) >= 0) {
			currentDeposit(amount);
			System.out.println("SUCCESS!" + "\n");
			System.out.println("New Current Account balance: " + moneyFormat.format(currentBalance) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}
	
	/* Customer Savings Account Deposit input */
	public void getSavingsDepositInput() {
		System.out.println("Saving Account Balance: " + moneyFormat.format(savingsBalance));
		System.out.print("Kindly enter the amount you want to deposit into your Savings Account (₦): ");
		double amount = input.nextDouble();

		if ((savingsBalance + amount) >= 0) {
			savingsDeposit(amount);
			System.out.println("SUCCESS!" + "\n");
			System.out.println("New Saving Account balance: " + moneyFormat.format(savingsBalance) + "\n");
		} else {
			System.out.println("Balance cannot be negative." + "\n");
		}
	}
	


}
