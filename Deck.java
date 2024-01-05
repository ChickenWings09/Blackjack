import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Deck {
    private List<Card> deck;

    public Deck() {
        this.deck = new ArrayList<>();
        generateDeck();
        Collections.shuffle(deck);
    }

    private void generateDeck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
    }

    public Card dealCard() {
        if (deck.isEmpty()) {
            generateDeck();
        }
        return deck.remove(0);
    }
}