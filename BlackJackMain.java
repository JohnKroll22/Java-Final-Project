import java.util.*;

public class BlackJackMain {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Welcome to Blackjack!");
        System.out.println("How many players (excluding dealer)? ");
        int numPlayers = console.nextInt();
        ArrayList<Player> players = new ArrayList<>();
        Deck deck = new Deck();
        deck.shuffle();
        for (int i = 0; i < numPlayers; i++) {
            ArrayList<Card> hand = deck.dealHand(2);
            players.add(new Player(hand));
            System.out.println("Player " + (i+1) + " hand: ");
            players.get(i).showHand();
            System.out.println("Sum: " + players.get(i).getSum());
        }
        ArrayList<Card> hand = deck.dealHand(2);
        Dealer dealer = new Dealer(hand);
        System.out.println("Dealer's hand: ");
        dealer.showHand();
        System.out.println();

        String next;
        console.nextLine();
        for (int i = 0; i < numPlayers; i++) {
            Player current = players.get(i);
            do {
                System.out.println("Player " + (i+1) + ", would you like to hit or stand? ");
                next = console.nextLine();
                next = next.toLowerCase();
                if (next.equals("hit")) {
                    current.addCard(deck.drawCard());
                    current.showHand();
                    System.out.println("Sum: " + current.getSum());
                }
                if (current.getSum() > 21) {
                    System.out.print("Bust!");
                    break;
                }
            } while(next.equals("hit"));
            current.finishTurn();
        }
        while (dealer.getSum() < 17) {
            dealer.addCard(deck.drawCard());
        }
        dealer.setIsFinalTurn();
        for (int i = 0; i < numPlayers; i++) {
            System.out.print("Player " + (i+1) + " sum: ");
            System.out.println(players.get(i).getSum());
        }
        System.out.println("Dealer's hand: ");
        dealer.showHand();
        System.out.print("Dealer's sum: ");
        System.out.println(dealer.getSum());
        for (int i = 0; i < numPlayers; i++) {
            Player player = players.get(i);
            int playerSum = player.getSum();
            int dealerSum = dealer.getSum();

            System.out.print("Result for Player " + (i + 1) + ": ");

            if (playerSum > 21) {
                System.out.println("Bust! Dealer wins.");
            } else if (dealerSum > 21) {
                System.out.println("Dealer busts! Player wins.");
            } else if (playerSum > dealerSum) {
                System.out.println("Player wins.");
            } else if (playerSum < dealerSum) {
                System.out.println("Dealer wins.");
            } else {
                System.out.println("Push (tie).");
            }  
        }
    }
}