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
        int sum = 0;
        int aceCount = 0;
    
        for (Card card : hand) {
            int value = card.getValue();
            if (value == 11) {  // If Ace (assuming you return 11 for Ace)
                aceCount++;
            }
            sum += value;
        }
    
        // Adjust Ace value from 11 to 1 if sum is over 21
        while (sum > 21 && aceCount > 0) {
            sum -= 10;  // Count one Ace as 1 instead of 11
            aceCount--;
        }
    
        return sum;
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
