
public class Main {

    public static void main(String[] args) {
        BankAccount a1 = new BankAccount("Bank 1", 10000);
        BankAccount a2 = new BankAccount("Bank 2", 20000);

        System.out.println(a1.getAccountId());
        System.out.println(a2.getAccountId());

        a1.deposit(500);
        a2.withdraw(200);

        a1.transferTo(a2, 300);

        a1.withdraw(1000000);
        System.out.println("a1 = " + a1.getAccountInfo());
        System.out.println("a2 = " + a2.getAccountInfo());

        System.out.println(BankAccount.getTotalAccounts());
        System.out.println(BankAccount.getNextID());

        BankAccount a3 = new BankAccount("Bank 3", 100000);
        System.out.println(a3.getAccountId());

        if(!a3.deposit(-100)) System.out.println("Didnt work as intended!");
        if(!a3.transferTo(a3, 1000)) System.out.println("Didnt work as intended!");

        Bank b = new Bank("Big bank", 10);
        b.setAccounts(a1, a2);

        System.out.println(b.getBankInfo());

    }
}


