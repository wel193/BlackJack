/**
 * This class represents Card with Suit enum type and Name enum type. It implements comparable interface.
 */
public class Card implements Comparable<Card>{

    private final Suit suit;
    private final Name name;

    /**
     * Constructor of Card object, initializes with given Suit and Name
     * @param suit suit enum type
     * @param name name enum type
     */
    public Card(Suit suit, Name name){
        this.suit = suit;
        this.name = name;
    }

    /**
     * Method to getSuit of the Card object
     * @return the Suit type
     */
    public Suit getSuit(){
        return this.suit;
    }

    /**
     * Method to getName of the Card object
     * @return the Name type
     */
    public Name getName(){
        return this.name;
    }

    /**
     * Method to get the Card point
     * @return the card point for BlackJack game
     */
    public int getCardPoint(){
        return this.getName().point();
    }

    /**
     * toString method to print of the Card in certain format
     * @return the String format of Card
     */
    @Override
    public String toString(){
        return getSuit() + " " + getName();
    }

    /**
     * Method to compare the calling object with number of the Card's Name
     * @param card the other card object
     * @return the comparable value
     */
    @Override
    public int compareTo(Card card){
        return this.getName().number() - card.getName().number();
    }

}
