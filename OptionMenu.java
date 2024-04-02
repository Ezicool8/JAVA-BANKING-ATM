import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class OptionMenu extends Account{
	
	Scanner menuInput = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'₦'###,##0.00");

	HashMap<Integer, Integer> AccountData = new HashMap<Integer, Integer>();

	/* Validate Login information customer account number and pin number */
	public void getLogin() throws IOException {
		int x = 1;

		do {
			try {
				// AccountData in an HashMap, where key = customer account number, value = pin number
				
				AccountData.put(10203040, 1234);
				AccountData.put(20304050, 0000);
				AccountData.put(30405060, 1111);

				System.out.println("Welcome to the EazyBank!");

				System.out.print("Enter Your Account Number: ");
				setCustomerAccountNumber(menuInput.nextInt());

				System.out.print("Enter Your Pin Number: ");
				setPinNumber(menuInput.nextInt());
			} catch (Exception e) {
				System.out.println("\n" + "Invalid character(s) Entered. Only numbers are allowed." + "\n");
				x = 2;
			}
			//using advance for loop to compare key and values
//			for (Entry<Integer, Integer> entry : AccountData.entrySet()) {
//				if (entry.getKey() == getCustomerAccountNumber() && entry.getValue() == getPinNumber()) {
//					getAccountType();
//				}
//				else System.out.println("\n" + "Wrong Customer Account Number or Pin Number." + "\n");
//
//			}
//			
			int acctNo = getCustomerAccountNumber();
			int pin = getPinNumber();
			if(AccountData.containsKey(acctNo) &&  AccountData.get(acctNo) == pin) {
				getAccountType(); 
			}
			else
			System.out.println("\n" + "Wrong Account Number or Pin Number Entered." + "\n");
			
			} while (x == 1);
		}

	public void getAccountType() {
		System.out.println("Kindly Select Your Account Type: ");
		System.out.println("Type 1 - Current Account");
		System.out.println("Type 2 - Savings Account");
		System.out.println("Type 3 - Exit");
		System.out.print("Choice: ");
		
		int selection = menuInput.nextInt();

		switch (selection) {
		case 1:
			getCurrent();
			break;

		case 2:
			getSaving();
			break;

		case 3:
			System.out.println("Thank You for using EazyBank, Good bye.");
			break;

		default:
			System.out.println("\n" + "Invalid Account Type Selected." + "\n");
			getAccountType();
		}
	}

	/* Display Current Account Menu with selections */
	public void getCurrent() {
		System.out.println("Current Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Choice: ");
	
		int selection = menuInput.nextInt();
	
		switch (selection) {
		case 1:
			System.out.println("Your Current Account Balance is : " + moneyFormat.format(getCurrentBalance()) + "\n");
			getCurrent();
			break;
	
		case 2:
			getCurrentWithdrawIput();  
			getCurrent();
			break;
	
		case 3:
			getCurrentDepositInput();
			getCurrent();
			break;
	
		case 4:
			System.out.println("Thank You for using EazyBank, bye.");
			break;
	
		default:
			System.out.println("\n" + "Invalid choice." + "\n");
			getCurrent();
		}
	}
	
	/* Display Saving Account Menu with selections */
	public void getSaving() {
		System.out.println("Savings Account: ");
		System.out.println("Type 1 - View Balance");
		System.out.println("Type 2 - Withdraw Funds");
		System.out.println("Type 3 - Deposit Funds");
		System.out.println("Type 4 - Exit");
		System.out.print("Choice: ");
	
		int selection = menuInput.nextInt();
	
		switch (selection) {
		case 1:
			System.out.println("Savings Account Balance: " + moneyFormat.format(getSavingsBalance()) + "\n");
			getSaving();
			break;
	
		case 2:
			getSavingsWithdrawInput(); 
			getSaving();
			break;
	
		case 3:
			getSavingsDepositInput();
			getSaving();
			break;
	
		case 4:
			System.out.println("Thank You for using EazyBank, bye.");
			break;
	
		default:
			System.out.println("\n" + "Invalid choice." + "\n");
			getSaving();
		}
	}
	
	}