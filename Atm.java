import java.util.Scanner;

public class ATM {
    // User details:
    private static int pin = 4567;
    private static int balance = 5000;
    private static int pinAttempts = 0;

    private static final String customerName = "John Doe";
    private static final String accountNumber = "XXXXXXXXXX1234";

    public static int withdraw(int amount) {
        balance -= amount;
        return balance;
    }

    public static int deposit(int amount) {
        balance += amount;
        return balance;
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void printReceipt(String transactionType, int amount) {
        System.out.println("\n----------------ATM TRANSACTION----------------");
        System.out.printf("| CARD NUMBER    : %s%n", accountNumber);
        System.out.printf("| CUSTOMER NAME  : %s%n", customerName);
        System.out.printf("| TRANSACTION    : %s%n", transactionType);
        System.out.printf("| AMOUNT         : %d%n", amount);
        System.out.printf("| AVAILABLE BAL  : %d%n", balance);
        System.out.println("----------------------------------------------");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n------ Welcome To IOB ------");
            System.out.println("1. Insert card");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            if (choice == 2) {
                System.out.println("Thank you for using IOB ATM. Have a nice day!");
                break;
            }

            if (choice == 1) {
                System.out.print("Enter PIN: ");
                int enteredPin = scanner.nextInt();

                if (enteredPin == pin) {
                    System.out.println("\n-------- Select Your Transaction --------");
                    System.out.println("1. Withdraw Cash");
                    System.out.println("2. Deposit Cash");
                    System.out.println("3. Balance Enquiry");
                    System.out.println("4. Change PIN");
                    System.out.println("5. Exit");
                    System.out.print("Enter your choice: ");
                    int transaction = scanner.nextInt();

                    switch (transaction) {
                        case 1:
                            System.out.print("Enter withdrawal amount: ");
                            int withdrawAmount = scanner.nextInt();
                            if (withdrawAmount <= balance) {
                                System.out.println("Processing your transaction...");
                                System.out.println("Please collect your cash.");
                                withdraw(withdrawAmount);

                                System.out.print("Do you want a receipt? (yes/no): ");
                                scanner.nextLine(); // Clear buffer
                                String receipt = scanner.nextLine();
                                if (receipt.equalsIgnoreCase("yes")) {
                                    printReceipt("Withdrawal", withdrawAmount);
                                }
                            } else {
                                System.out.println("Insufficient balance!");
                            }
                            break;

                        case 2:
                            System.out.print("Enter deposit amount: ");
                            int depositAmount = scanner.nextInt();
                            deposit(depositAmount);
                            System.out.println("Cash deposited successfully.");

                            System.out.print("Do you want a receipt? (yes/no): ");
                            scanner.nextLine(); // Clear buffer
                            String depositReceipt = scanner.nextLine();
                            if (depositReceipt.equalsIgnoreCase("yes")) {
                                printReceipt("Deposit", depositAmount);
                            }
                            break;

                        case 3:
                            printReceipt("Balance Enquiry", 0);
                            break;

                        case 4:
                            System.out.print("Enter old PIN: ");
                            int oldPin = scanner.nextInt();
                            if (oldPin == pin) {
                                System.out.print("Enter new PIN: ");
                                int newPin1 = scanner.nextInt();
                                System.out.print("Confirm new PIN: ");
                                int newPin2 = scanner.nextInt();
                                if (newPin1 == newPin2) {
                                    pin = newPin2;
                                    System.out.println("Your PIN has been changed successfully!");
                                } else {
                                    System.out.println("PIN mismatch. Try again.");
                                }
                            } else {
                                System.out.println("Incorrect old PIN!");
                            }
                            break;

                        case 5:
                            System.out.println("Thank you for using IOB ATM.");
                            return;

                        default:
                            System.out.println("Invalid transaction choice.");
                    }
                } else {
                    pinAttempts++;
                    System.out.println("Invalid PIN! Please try again.");

                    if (pinAttempts >= 3) {
                        System.out.println("Account locked due to multiple incorrect PIN attempts. Please contact your bank.");
                        break;
                    }

                    System.out.println("Press 1 to cancel and return to the main menu.");
                    int cancel = scanner.nextInt();
                    if (cancel == 1) {
                        clearScreen();
                    }
                }
            }
        }

        scanner.close();
    }
}

