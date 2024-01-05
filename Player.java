import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private List<Card> hand;
    private Scanner scanner;

    public Player() {
        this.hand = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public List<Card> getHand() {
        return new ArrayList<>(hand);
    }

    public int calculateHandValue() {
        int value = 0;
        for (Card card : hand) {
            value += card.getBlackjackValue(true);
        }
        return value;
    }

    public boolean wantsToHit() {
        System.out.print("Do you want to hit or stand? ");
        String choice;
        do {
            choice = scanner.next().toLowerCase();
        } while (!choice.equals("hit") && !choice.equals("stand"));

        return choice.equals("hit");
    }

    public int chooseAceValue() {
        System.out.print("Choose the value for Ace (1 or 11): ");
        int choice;
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter 1 or 11.");
                System.out.print("Enter your choice: ");
                scanner.next();
            }
            choice = scanner.nextInt();
            if (choice != 1 && choice != 11) {
                System.out.println("Invalid choice. Please enter 1 or 11.");
            }
        } while (choice != 1 && choice != 11);
        return choice;
    }
    
    public boolean hasBlackjack() {
        return hand.size() == 2 && calculateHandValue() == 21;
    }

    public boolean isBust() {
        return calculateHandValue() > 21;
    }
}
