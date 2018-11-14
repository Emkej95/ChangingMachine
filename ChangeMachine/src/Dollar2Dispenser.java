public class Dollar2Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 2) {
            int num = cur.getAmount() / 2;
            int remainder = cur.getAmount() % 2;
            System.out.println("Dispensing " + num + "x " + ConsoleColors.CYAN_BOLD_BRIGHT +"2$" + ConsoleColors.RESET + " note");
            if (remainder != 0) this.chain.dispense(new Currency(remainder));
        } else {
            this.chain.dispense(cur);
        }
    }

}