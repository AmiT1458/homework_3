import java.util.Objects;

class BankAccount {
    private int accountId;
    private String ownerName;
    private double balance;
    private boolean isActive = true;
    private static int nextID = 1000;
    public static int totalAccounts = 0;


    public BankAccount(String ownerName) {
        this.ownerName = ownerName;
        balance = 0;
        nextID++;
        totalAccounts++;
    }

    public BankAccount(String ownerName, double initialBalance) {
        this.ownerName = ownerName;
        balance = initialBalance >= 0 ? initialBalance : 0;
        nextID++;
        totalAccounts++;
    }

    public boolean deposit(double amount) {
        if (isValidAmount(amount)) return false;
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if (isValidAmount(amount) || amount > balance) return false;

        balance -= amount;
        return true;
    }

    public boolean transferTo(BankAccount destination, double amount) {
        if (destination == null || destination == this) return false;
        if (amount > balance) return false;

        destination.addBalance(amount);
        return true;
    }

    public boolean closeAccount() {
        if (balance != 0) return false;

        // close account
        isActive = false;
        return true;
    }

    public static boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public String getAccountInfo() {
        return "Id: " + (nextID - 1) + ownerName + " balance: " + balance + " account online: " + isActive;
    }

    public static int getNextID() {
        return nextID - 1;
    }

    public boolean isActive() {
        return isActive;
    }

    public double getBalance() {
        return balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public int getAccountId() {
        return accountId;
    }

    public static void setNextID(int nextID) {
        BankAccount.nextID = nextID;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setOwnerName(String ownerName) {
        if (!Objects.equals(ownerName, "")) this.ownerName = ownerName;
    }

    public void setBalance(double balance) {
        if(isValidAmount(balance)) this.balance = balance;
    }

    public void addBalance(double amount) {
        if(isValidAmount(amount)) this.balance += amount;
    }

    public static int getTotalAccounts() {
        return totalAccounts;
    }

}
