public class Card {
    public enum Suit {Hearts, Diamonds, Clubs, Spades}
    public enum Rank {Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten, Jack, Queen, King, Ace}

    private Suit suit;
    private Rank rank;

    public Card(Suit s, Rank r) {
        this.suit = s;
        this.rank = r;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public int getBlackjackValue(boolean aceHigh) {
        switch (rank) {
            case Two, Three, Four, Five, Six, Seven, Eight, Nine, Ten:
                return rank.ordinal()+2; 
            case Jack, Queen, King:
                return 10;
            case Ace:
                return aceHigh ? 11 : 1;
            default:
                throw new IllegalStateException("Unexpected value: " + rank);
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
