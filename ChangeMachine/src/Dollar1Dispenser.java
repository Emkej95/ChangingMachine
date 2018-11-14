public class Dollar1Dispenser implements DispenseChain {
    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 1) {
            int num = cur.getAmount();
            System.out.println("Dispensing " + num + "x " + ConsoleColors.CYAN_BOLD_BRIGHT +"1$" + ConsoleColors.RESET + " note");
        } else {
            this.chain.dispense(cur);
        }
    }

}