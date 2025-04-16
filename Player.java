import java.util.*;

public class Player {
    private boolean isDealer = false;
    private ArrayList<Card> hand;
    private boolean moreThan21 = false;
    private int sum;
    private boolean endOfTurn = false;
    public Player(ArrayList<Card> hand) {
        this.hand = hand;
        this.sum = Deck.calculateHandValue(hand);
    }
    public void addCard(Card e) {
        this.hand.add(e);
        this.sum += e.getValue();
    }
    public int getSum() {
        return this.sum;
    }
    public ArrayList<Card> getHand() {
        return this.hand;
    }
    public void showHand() {
        for (Card card: hand) {
            System.out.print(card.toString());
        }
        System.out.println();
    }
    public void setDealer() {
        this.isDealer = true;
    }
    public void finishTurn() {
        this.endOfTurn = true;
    }
}
