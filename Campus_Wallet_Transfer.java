/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package campus_wallet_.transfer;

/**
 *
 * @author ALMEDA_CPE113
 */
public class Campus_Wallet_Transfer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CampusWallet aly = new CampusWallet("Aly", 100);
        CampusWallet ben = new CampusWallet("Ben");

        System.out.println("Aly: " + aly.getBalance() + " credits");
        System.out.println("Ben: " + ben.getBalance() + " credits");

        System.out.println("Transferred 35 credits: "
                + aly.transferTo(ben, 35));

        System.out.println("Aly: " + aly.getBalance() + " credits");
        System.out.println("Ben: " + ben.getBalance() + " credits");

        System.out.println("Transferred 70 credits: "
                + aly.transferTo(ben, 70));

        System.out.println("Aly: " + aly.getBalance() + " credits");
        System.out.println("Ben: " + ben.getBalance() + " credits");

        System.out.println("Transferred 10 credits to own wallet: "
                + aly.transferTo(aly, 10));

        System.out.println("Aly: " + aly.getBalance() + " credits");
        System.out.println("Ben: " + ben.getBalance() + " credits");

        System.out.println("Ben deposited 15 credits: "
                + ben.deposit(15));

        System.out.println("Aly: " + aly.getBalance() + " credits");
        System.out.println("Ben: " + ben.getBalance() + " credits");

        System.out.println("Transferred 65 credits: "
                + aly.transferTo(ben, 65));

        System.out.println("Aly: " + aly.getBalance() + " credits");
        System.out.println("Ben: " + ben.getBalance() + " credits");

        System.out.println("Transferred 0 credits: "
                + aly.transferTo(ben, 0));

        System.out.println("Aly: " + aly.getBalance() + " credits");
        System.out.println("Ben: " + ben.getBalance() + " credits");

        System.out.println("Transferred to null: "
                + aly.transferTo(null, 10));

        System.out.println("Aly: " + aly.getBalance() + " credits");
        System.out.println("Ben: " + ben.getBalance() + " credits");
    }
}
    class CampusWallet {

    private String owner;
    private int balance;

    public CampusWallet(String owner, int balance) {
        this.owner = owner;

        if (balance < 0) {
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public CampusWallet(String owner) {
        this(owner, 0);
    }

    public boolean deposit(int amount) {

        if (amount <= 0) {
            return false;
        }

        this.balance += amount;
        return true;
    }

    public boolean transferTo(CampusWallet recipient, int amount) {

        if (recipient == null || recipient == this || amount <= 0
                || this.balance < amount) {
            return false;
        }

        this.balance -= amount;
        recipient.balance += amount;

        return true;
    }

    public int getBalance() {
        return this.balance;
    }
}
