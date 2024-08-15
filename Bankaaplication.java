import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}

class ATM {
    private BankAccount account;

    public ATM(BankAccount bankAccount) {
        account = bankAccount;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Mini Statement");
        System.out.println("5. Exit");
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        double withdrawAmount = 0; // Initialize withdrawAmount outside the switch

        while (true) {
            displayMenu();
            System.out.print("Select a choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance: Rs." + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("Deposit successfully. Your current balance: Rs." + account.getBalance());
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successfully. Your current balance: Rs." + account.getBalance());
                    } else {
                        System.out.println("Insufficient balance.");
                    }
                    break;
                case 4:
                    // Mini statement logic here
                    System.out.println("Mini Statement:");
                    System.out.println("Transaction: Withdrawal, Amount: Rs." + withdrawAmount + ", New Balance: Rs." + account.getBalance());
                    break;
                case 5:
                    System.out.println("Thank you for using the ATM!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid choice.");
            }
        }
    }
}

public class BankApplication {
    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(2000);
        ATM atm = new ATM(userAccount);
        atm.run();
    }
}
