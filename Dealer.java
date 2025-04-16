import java.util.*;

public class Dealer extends Player {
    private boolean isFinalTurn = false;
    public Dealer(ArrayList<Card> hand) {
        super(hand);
        super.setDealer();
    }
    public void setIsFinalTurn () {
        this.isFinalTurn = true;
    }
    public void showHand() {
        if (this.isFinalTurn) {
            super.showHand();
        }
        else {
            ArrayList<Card> hand = super.getHand();
            System.out.print(hand.get(0).toString());
        }
        System.out.println();
    }
}