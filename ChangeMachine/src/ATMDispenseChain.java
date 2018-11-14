import java.util.Scanner;

public class ATMDispenseChain {

    private DispenseChain c1;

    private ATMDispenseChain() {
        // initialize the chain
        this.c1 = new Dollar50Dispenser();
        DispenseChain c2 = new Dollar20Dispenser();
        DispenseChain c3 = new Dollar10Dispenser();
        DispenseChain c4 = new Dollar5Dispenser();
        DispenseChain c5 = new Dollar2Dispenser();
        DispenseChain c6 = new Dollar1Dispenser();

        // set the chain of responsibility
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
        c4.setNextChain(c5);
        c5.setNextChain(c6);
    }

    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        do {
            int amount;
            System.out.println("Enter amount to dispense");
            Scanner input = new Scanner(System.in);
            amount = input.nextInt();
            atmDispenser.c1.dispense(new Currency(amount));
            System.out.println("Dispensing " + ConsoleColors.GREEN_BOLD + "finished" + "\n");
        } while (newDispensing());

    }

    private static boolean newDispensing() {
        System.out.println(ConsoleColors.RESET + "Would you like to enter another amount to dispense? (Y/N)");
        Scanner input2 = new Scanner(System.in);
        String decision = input2.nextLine();

        return decision.equalsIgnoreCase("y");
    }

}