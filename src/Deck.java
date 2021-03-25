import java.util.*;

/**
 * This class represents a Deck object with an empty arraylist
 */
public class Deck {
    private ArrayList<Card> deck;

    /**
     * Constructor of Deck. Initializes it with certain arraylist size and certain Cards.
     */
    public Deck(){
        this.deck = new ArrayList<>(52);
        initDeck();
    }

    /**
     * Constructor of Deck with certain size value and add the card from source deck.
     * @param size input size of the deck
     * @param sourceDeck Source deck to get the card from
     */
    public Deck(int size, Deck sourceDeck){
        this.deck = new ArrayList<>();
        for (int i = 0; i < size; i ++){
            this.addCard(sourceDeck.getFirstCard());
        }
    }

    /**
     * Initializes the deck with certain Card objects.
     */
    private void initDeck(){
        for (Suit suit : Suit.values()) {
            for (Name name : Name.values()) {
                this.deck.add(new Card(suit, name));
            }
        }
    }

    /**
     * Method to get the card at certain index
     * @param i index value
     * @return the Card object at certain index in the Deck
     * @throws IndexOutOfBoundsException if the index is out of bounds
     */
    public Card getCard(int i) throws IndexOutOfBoundsException{
        if (i < 0 || i >= this.getSize()){
            throw new IndexOutOfBoundsException("The index is not valid for this Deck");
        }
        return this.deck.get(i);
    }

    /**
     * Method to shuffle the Deck
     */
    public void shuffle(){
        Collections.shuffle(this.deck);
    }

    /**
     * Method to get the firstCard of the deck, and remove it
     * @return the firstCard of the deck
     * @throws IllegalStateException if the deck is empty
     */
    public Card getFirstCard() throws IllegalStateException{
        if (this.getSize() <= 0){
            throw new IllegalStateException("Empty deck. There has no card to get");
        }
        Card first = this.deck.get(0);
        this.deck.remove(0);
        return first;
    }

    /**
     * Method to get the size of the deck
     * @return the size of deck
     */
    public int getSize(){
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
        if (this.getSize() == 0 ){
            return "";
        }

        String str = " | ";
        for (Card card: this.deck){
            str += card.toString() + " | ";
        }
        return str;
    }

    /**
     * Method to check if the calling object is equal to another Deck object
     * @param other other Object
     * @return boolean
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (other == null || getClass() != other.getClass()) return false;
        Deck deck = (Deck) other;
        if(getSize() == deck.getSize()){
            return true;
        }
        return false;
    }

}
