public class BankAccountTest {
	public static void main(String[] args) {
		BankAccount ayman=new BankAccount();
        System.out.println("ayman account's number is "+ ayman.getRandomNumber());       
        ayman.deposit("checking",1250);
        ayman.deposit("savings",1900);
        System.out.println("Until now we have "+BankAccount.numberOfAccounts+"accounts");
        BankAccount ahmad=new BankAccount();
        System.out.println("Until now we have "+BankAccount.numberOfAccounts+" accounts");
        System.out.println(ahmad.getCheckingBalance());
        ahmad.withdraw("checking",500);
        ahmad.deposit("checking",250);
        ahmad.withdraw("checking",35);
        System.out.println(ahmad.getCheckingBalance()); 
         
	}

}
