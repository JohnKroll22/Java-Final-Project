import java.util.*;

public class Player {
    private boolean isDealer = false;
    private ArrayList<Card> hand;
    private boolean moreThan21 = false;
    private int sum;
    private boolean endOfTurn = false;
    private int balance;
    private int bet;
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
    public void setBet(int bet) {
        this.balance -= bet;
        this.bet = bet;
    }
    public int getBet() {
        return this.bet;
    }
    public void setBalance(int balance) {
        this.balance = balance;
    }
    public int getBalance() {
        return this.balance;
    }
    public void addToBalance(int num) {
        this.balance += num;
    }
    public void showHand() {
        for (Card card: hand) {
            System.out.print(card.toString() + " ");
        }
        System.out.println();
    }
    public void setDealer() {
        this.isDealer = true;
    }
    public void finishTurn() {
        this.endOfTurn = true;
        this.bet = 0;
    }

}
