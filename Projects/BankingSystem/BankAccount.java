package Projects.BankingSystem;

public abstract class BankAccount {
    private final long AccountNo;
    private double AccBalance;

    public BankAccount() {
        this.AccountNo = System.currentTimeMillis();
    }
    
    public void deposit(double Amo) {
        this.AccBalance += Amo;
    }

    public void withdraw(double Amo) {
        this.AccBalance -= Amo;
    }

    public double getBalance() {
        return AccBalance;
    }

    public long getAccountNo() {
        return AccountNo;
    }
}
 

