class Bank {
    private String bankName;
    private int bankCode;
    private BankAccount account1, account2;

    public Bank(String bankName, int bankCode) {
        this.bankName = bankName;
        this.bankCode = bankCode;
    }

    public void setAccounts(BankAccount a, BankAccount b) {
        account1 = a;
        account2 = b;
    }

    public double getTotalBalance() {
        return account1.getBalance() + account2.getBalance();
    }

    public String getBankInfo() {
        return bankName + " code: " + bankCode + account1.getAccountInfo() + account2.getAccountInfo();
    }

    public String getBankName() {
        return bankName;
    }
}
