import java.util.Scanner;

public class BlackjackGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Deck deck = new Deck();
        Dealer dealer = new Dealer();
        Player player = new Player();

        dealer.addCard(deck.dealCard());
        dealer.addCard(deck.dealCard());
        player.addCard(deck.dealCard());
        player.addCard(deck.dealCard());

        while (true) {
            System.out.println("Dealer's Up Card: " + dealer.getHand().get(0));
            System.out.println("Your Hand: " + player.getHand());
            System.out.println("Your Hand Value: " + player.calculateHandValue());

            if (player.hasBlackjack()) {
                System.out.println("Blackjack! You win!");
                break;
            } else if (player.isBust()) {
                System.out.println("Bust! You lose.");
                break;
            }

            if (player.wantsToHit()) {
                player.addCard(deck.dealCard());
            } else {
                break;
            }
        }

        while (dealer.shouldDrawCard()) {
            dealer.addCard(deck.dealCard());
        }

        System.out.println("Final Game State:");
        System.out.println("Dealer's Hand: " + dealer.getHand());
        System.out.println("Dealer's Hand Value: " + dealer.calculateHandValue());
        System.out.println("Your Hand: " + player.getHand());
        System.out.println("Your Hand Value: " + player.calculateHandValue());
   
        if (dealer.isBust() || ((player.calculateHandValue() > dealer.calculateHandValue()) && !player.isBust())) {
            System.out.println("You win!");
        } else if (dealer.calculateHandValue() > player.calculateHandValue() || player.isBust()) {
            System.out.println("Dealer wins!");
        } else {
            System.out.println("It's a tie!");
        }

        scanner.close();

    }
}
