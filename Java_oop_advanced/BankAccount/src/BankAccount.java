import java.util.Random;
public class BankAccount {
	private String accountNumber=0; 
    private double checkingBalance=0; 
    private double savingsBalance=0; 
    protected static int numberOfAccounts=0;
    private static double totalAmountInAccount=0;
    
	public BankAccount() {
		this.accountNumber=getRandomNumber();
        numberOfAccounts++;
	}
	public String getRandomNumber() {
		String num="1234567899";
		String accountNumber="";
		Random rand=new Random();
		for (int i=0;i<10;i++) {
			accountNumber+=num.charAt(rand.nextInt(10));
			return accountNumber;
		}
	}
	public String getAccountNumber(){
	    return accountNumber;
	}
	public double getCheckingBalance(){
        return this.checkingBalance;
    }
	public double getSavingBalance() {
		return this.savingsBalance;
	}
	public void deposit(String transactionType, double amount){
        if(transactionType=="checking"){
            this.checkingBalance+=amount;
            BankAccount.totalAmountInAccount+=amount;
        }else if(transactionType=="savings"){
            this.savingsBalance+=amount;
            BankAccount.totalAmountInAccount+=amount;
        }
    }
	public void withdraw(String transactionType, double amount){
        if(transactionType=="checking"){
            if(this.checkingBalance-amount>=0){
            this.checkingBalance-=amount;
            BankAccount.totalAmountInAccount-=amount;
            }else{
                System.out.println("You don't have enough money!");
            }
        }else if(transactionType=="savings"){
            if (this.savingsBalance-amount>=0){
            this.savingsBalance-=amount;
            BankAccount.totalAmountInAccount-=amount;
            }else{
                System.out.println("You don't have enough money!");
            }
        }
    }
    
}
