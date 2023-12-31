import java.util.ArrayList;
import java.util.List;

public class Dealer {
    private List<Card> hand;
    private boolean aceHigh;

    public Dealer() {
        this.hand = new ArrayList<>();
        this.aceHigh = false;
    }

    public void reset() {
        hand.clear();
        aceHigh = false;
    }

    public void addCard(Card card) {
        hand.add(card);
        updateAceHigh();
    }

    private void updateAceHigh() {
        int handValue = calculateHandValue();
        if (handValue + 11 <= 21) {
            aceHigh = true;
        } else {
            aceHigh = false;
        }
    }

    public boolean shouldDrawCard() {
        return calculateHandValue() < 17;
    }

    public List<Card> getHand() {
        return new ArrayList<>(hand);
    }

    public int calculateHandValue() {
        int value = 0;
        for (Card card : hand) {
            value += card.getBlackjackValue(aceHigh);
        }
        return value;
    }

    public boolean hasBlackjack() {
        return hand.size() == 2 && calculateHandValue() == 21;
    }

    public boolean isBust() {
        return calculateHandValue() > 21;
    }
}
