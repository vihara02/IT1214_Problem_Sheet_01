class BankAccount{
    private int accountNumber;
    private String accountHolder;
    private double balance;

    BankAccount(int accountNumber, String accountHolder, double balance){
        this.accountNumber=accountNumber;
        this.accountHolder=accountHolder;
        this.balance=balance;
    }

    public void setAccountNumber(int accountNumber){
        this.accountNumber=accountNumber;
    }
    public void setAccountHolder(String accountHolder){
        this.accountHolder=accountHolder;
    }
    public void setBalance(double balance){
        this.balance=balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }
    public String getAccountHolder(){
        return accountHolder;
    }
    public double getBalance(){
        return balance;
    }

    public void withdraw(double amount) throws IllegalArgumentException{
        if(amount < balance){
            balance -= amount;
        } 
		else{
            throw new IllegalArgumentException("Insufficiant balance");
        }
    }
}

class Bank{
    int accountIndex=0;
    BankAccount[] bankAccountArray=new BankAccount[5];

    public void addAccount(BankAccount bankAccount){
        if(accountIndex < bankAccountArray.length){
            bankAccountArray[accountIndex++] = bankAccount;
        } 
		else{
            System.out.println("Max reached");
        }
    }

    public void withdrawMoney(int accountNumber, double amount){
        for(BankAccount bankAccount:bankAccountArray){
            if(bankAccount!=null){
                if(bankAccount.getAccountNumber()==accountNumber){
                    try{
                        bankAccount.withdraw(amount);
                    } 
					catch(IllegalArgumentException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                }
            }
        }
    }

    public void displayDetails(){
        for(BankAccount bankAccount:bankAccountArray){
            if(bankAccount!=null){
                System.out.println("Account Number : "+bankAccount.getAccountNumber()+" Account Holder : "+bankAccount.getAccountHolder()+" Balance : "+bankAccount.getBalance());
            }
        }
    }
}

class Main{

    public static void main(String[] args){

        Bank bank=new Bank();

        bank.addAccount(new BankAccount(1001, "Alice", 5000.0));
        bank.addAccount(new BankAccount(1002, "Bob", 3000.0));

        bank.withdrawMoney(1001, 6000.0);
        bank.withdrawMoney(1002, 1000.0);

        bank.displayDetails();
    }
}