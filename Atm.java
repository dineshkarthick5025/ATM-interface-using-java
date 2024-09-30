import java.util.Scanner;

public class atm {
    // User details:
    static int pin = 4567;
    static int amount = 5000;
    static int cancel;
    static int pinAttempts = 0;

    static String customername = "John Doe";
    static String accountNumber = "XXXXXXXXXX1234";
    static String choice1="yes";
    static String choice2="no";

    public static int withdraw(int user_amount) {
        amount -= user_amount;
        return amount;

    }

    public static int deposit(int user_dep) {
        amount += user_dep;
        return amount;
    }

    public static void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner dinesh = new Scanner(System.in);

        while (true) {
            System.out.println("------Welcome To IOB------");
            System.out.print("Click 1 to insert card:|");
            int n = dinesh.nextInt();

            if (n == 1) {
                System.out.print("Enter PIN: ");
                int pinnum = dinesh.nextInt();
                if (pinnum == pin) {
                    System.out.println("--------Select your transactions----------");
                    System.out.println("1. Withdraw cash");
                    System.out.println("2. Deposit cash");
                    System.out.println("3. Balance Enquiry");
                    System.out.println("4. Change PIN");
                    int transactions = dinesh.nextInt();

                    switch (transactions) {
                        case 1:
                            System.out.print("Enter amount: ");
                            int user_amount = dinesh.nextInt();
                            if (user_amount <= amount) {
                                System.out.println("Your transaction is being processed...");
                                System.out.println("Collect your cash");
                                dinesh.nextLine(); // Clear buffer after reading int
                                System.out.print("Do you want a receipt? (yes/no): ");
                                String receipt = dinesh.nextLine();
                                if(receipt.equals(choice1)) {
                                    withdraw(user_amount);
                                    System.out.println("----------------ATM TRANSACTION-------");
                                    System.out.println(". CARD NUMBER    XXXXXXXXXX          .");
                                    System.out.println(". CUSTOMER NAME  ##########          .");
                                    System.out.println(". TRANSACTION    Deposit             .");
                                    System.out.printf(". AVAIL BALANCE  %d                .\n", amount);
                                    System.out.println("------------------------------------");
                                }
                            } else {
                                System.out.println("insufficient balance!");
                            }
                            break;


                        case 2:
                            System.out.print("Enter deposit amount: ");
                            int user_dep = dinesh.nextInt();
                            System.out.println("Cash deposited successfully.");
                            deposit(user_dep);
                            System.out.println("----------------ATM TRANSACTION-------");
                            System.out.println(". CARD NUMBER    XXXXXXXXXX          .");
                            System.out.println(". CUSTOMER NAME  ##########          .");
                            System.out.println(". TRANSACTION    Deposit             .");
                            System.out.printf(". AVAIL BALANCE  %d                .\n", amount);
                            System.out.println("------------------------------------");
                            break;

                        case 3:
                            System.out.println("----------------ATM TRANSACTION-------");
                            System.out.println(". CARD NUMBER    XXXXXXXXXX          .");
                            System.out.println(". CUSTOMER NAME  ##########          .");
                            System.out.println(". TRANSACTION    Balance Enquiry     .");
                            System.out.printf(". AVAIL BALANCE  %d                .\n", amount);
                            System.out.println("------------------------------------");
                            break;

                        case 4:
                            System.out.println("Enter old PIN:");
                            int old_pin = dinesh.nextInt();
                            if (old_pin == pin) {
                                System.out.println("Enter new PIN:");
                                int new_pin1 = dinesh.nextInt();
                                System.out.println("Confirm new PIN:");
                                int new_pin2 = dinesh.nextInt();
                                if (new_pin1 == new_pin2) {
                                    pin = new_pin2;
                                    System.out.println("Your PIN has been changed!");
                                } else {
                                    System.out.println("PIN mismatch. Try again.");
                                }
                            } else {
                                System.out.println("Incorrect old PIN!");
                            }
                            break;

                        default:
                            System.out.println("Invalid transaction choice.");
                            break;
                    }
                } else {
                    pinAttempts++;
                    System.out.println("Invalid PIN! Please try again.");
                    if (pinAttempts >= 3) {
                        System.out.println("Account locked! due to multiple incorrect PIN attempts. Please contact your bank.");
                        break;
                    }


                    System.out.println("Click 1 to cancel and return to the main menu.");
                    cancel = dinesh.nextInt();
                    if (cancel == 1) {
                        clearScreen();
                    }
                }
            }
        }
    }
}
