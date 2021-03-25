/**
 * This class represents Hand extends Deck class
 */
public class Hand extends Deck{

    /**
     * Default constructor of the hand class with no card
     *
     */
    public Hand(){
        super(0, null);
    }

    /**
     * Constructor of hand class with certain size of card from given sourceDeck
     * @param size size of the hand
     * @param sourceDeck source deck to get the card from
     */
    public Hand(int size, Deck sourceDeck){
        super(size, sourceDeck);
    }


    /**
     * Method to calculate total point in the Hand
     * @return point
     */
    public int handPoint(){
        int point = 0;
        boolean hasAce = false;
        for (int i = 0; i < this.getSize(); i++){
            Card card = this.getCard(i);
            point += card.getCardPoint();
            if (card.getName() == Name.ACE){
                hasAce = true;
            }
        }
        if (hasAce && point + 10 <= 21){
            point += 10;
        }
        return point;
    }

    /**
     * Main function to execute the program
     * @param arg entry point
     */
    public static void main(String[] arg){
        Deck deck = new Deck();
        deck.shuffle();

        Hand hand1 = new Hand(5, deck);
        Hand hand2 = new Hand(5, deck);

        hand1.sortCard();
        hand2.sortCard();
        System.out.println("Hand 1: " + hand1);
        System.out.println("Hand 2: " + hand2);

        //add card back to deck
        for (int i = 0; i < 5; i ++){
            deck.addCard(hand1.getFirstCard());
            deck.addCard(hand2.getFirstCard());
        }

        deck.sortCard();
        System.out.println("Deck: " + deck);
    }

}
