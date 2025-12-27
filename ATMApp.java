import java.util.HashMap;
import java.util.Scanner;

// ---------------- ACCOUNT ----------------
class Account {
    private int accountNumber;
    private String userName;
    private int pin;
    private int balance;

    public Account(int accountNumber, String userName, int pin) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.pin = pin;
        this.balance = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getUserName() {
        return userName;
    }

    public boolean validatePin(int inputPin) {
        return this.pin == inputPin;
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if (amount <= 0) {
            throw new RuntimeException("Invalid deposit amount");
        }
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= 0) {
            throw new RuntimeException("Invalid withdraw amount");
        }
        if (amount > balance) {
            throw new RuntimeException("Insufficient balance");
        }
        balance -= amount;
    }

    public void changePin(int oldPin, int newPin) {
        if (this.pin != oldPin) {
            throw new RuntimeException("Old PIN is incorrect");
        }
        this.pin = newPin;
    }
}

// ---------------- BANK ----------------
class Bank {
    private HashMap<Integer, Account> accounts = new HashMap<>();

    public void createAccount(int accNo, String name, int pin) {
        if (accounts.containsKey(accNo)) {
            throw new RuntimeException("Account already exists");
        }
        accounts.put(accNo, new Account(accNo, name, pin));
    }

    public Account login(int accNo, int pin) {
        Account acc = accounts.get(accNo);
        if (acc == null) {
            throw new RuntimeException("Account not found");
        }
        if (!acc.validatePin(pin)) {
            throw new RuntimeException("Invalid PIN");
        }
        return acc;
    }
}

// ---------------- ATM ----------------
class ATM {
    private Bank bank;
    private Scanner sc;

    public ATM(Bank bank) {
        this.bank = bank;
        this.sc = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=================================");
        System.out.println("   HELLO! WELCOME TO ATM SYSTEM  ");
        System.out.println("=================================");

        while (true) {
            System.out.println("\n1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> createAccount();
                    case 2 -> login();
                    case 3 -> {
                        System.out.println("Thank you for using ATM. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter User Name: ");
        String name = sc.next();

        System.out.print("Set PIN: ");
        int pin = sc.nextInt();

        bank.createAccount(accNo, name, pin);
        System.out.println("Account created successfully!");
    }

    private void login() {
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter PIN: ");
        int pin = sc.nextInt();

        Account account = bank.login(accNo, pin);
        System.out.println("\nWelcome " + account.getUserName() + "!");
        userMenu(account);
    }

    private void userMenu(Account account) {
        while (true) {
            System.out.println("\n1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Change PIN");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1 -> System.out.println("Balance: " + account.getBalance());
                    case 2 -> {
                        System.out.print("Enter amount: ");
                        account.deposit(sc.nextInt());
                        System.out.println("Deposit successful");
                    }
                    case 3 -> {
                        System.out.print("Enter amount: ");
                        account.withdraw(sc.nextInt());
                        System.out.println("Withdraw successful");
                    }
                    case 4 -> {
                        System.out.print("Enter old PIN: ");
                        int oldPin = sc.nextInt();
                        System.out.print("Enter new PIN: ");
                        int newPin = sc.nextInt();
                        account.changePin(oldPin, newPin);
                        System.out.println("PIN changed successfully");
                    }
                    case 5 -> {
                        System.out.println("Logged out");
                        return;
                    }
                    default -> System.out.println("Invalid option");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

// ---------------- MAIN ----------------
public class ATMApp {
    public static void main(String[] args) {
        Bank bank = new Bank();
        ATM atm = new ATM(bank);
        atm.start();
    }
}
