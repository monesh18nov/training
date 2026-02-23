public class BankAccount {

    private double accountBalance;

    public BankAccount(double openingBalance) {
        if (openingBalance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.accountBalance = openingBalance;
    }

    public void deposit(double depositAmount) {
        if (depositAmount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        accountBalance += depositAmount;
    }

    public void withdraw(double withdrawAmount) {
        if (withdrawAmount <= 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }

        if (withdrawAmount > accountBalance) {
            throw new IllegalArgumentException("Insufficient balance");
        }

        accountBalance -= withdrawAmount;
    }

    public double getBalance() {
        return accountBalance;
    }
}
