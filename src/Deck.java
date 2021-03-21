import java.util.*;

public class Deck {
    protected ArrayList<Card> deck;

    /**
     * Constructor of Deck
     */
    public Deck(){
        this.deck = new ArrayList<>(52);
        for (Suit suit : Suit.values()) {
            for (Name name : Name.values()) {
                this.deck.add(new Card(suit, name));
            }
        }
    }

    public void swap(int i, int j){
        Card temp = this.deck.get(i);
        this.deck.set(i, this.deck.get(j));
        this.deck.set(j, temp);
    }

    public void shuffle(){
        Random rand = new Random();
        for (int j = 0; j < 5; j ++) {
            for (int i = 0; i < this.getDeckSize(); i++) {
                swap(i, rand.nextInt(52));
            }
        }
    }

    public Card getFirstCard(){
        Card first = this.deck.get(0);
        this.deck.remove(0);
        return first;
    }

    public String showFirstCard(){
        return this.deck.get(0).toString();
    }

    public int getDeckSize(){
        return this.deck.size();
    }

    /**
     * Add a new Card in the Deck
     * @param card Card object
     */
    public void addCard(Card card){
        this.deck.add(card);
    }

    /**
     * Sort the Card object in the Deck ordered by name
     */
    public void sortCard(){
        Collections.sort(this.deck);
    }

    /**
     * Print every card in the deck
     * @return string format of the Card in the Deck object
     */
    public String toString(){
        String str = " | ";
        for (Card card: this.deck){
            str += card.toString() + " | ";
        }
        return str;
    }

}
