import java.util.Scanner;

/**
 * This class represents Player, with Hand object, name string, and point value.
 */
public class Player {
    private Hand hand;
    private int point;

    /**
     * Default constructor of Player with empty hand card.
     */
    public Player(){
        this.hand = new Hand();
        this.point = 0;
    }
    /**
     * Constructor of Player. Initializes it with Hand object with size 2, the default name, and initial points.
     */
    public Player(Deck sourceDeck) {
        this.hand = new Hand(2, sourceDeck);
        this.point = this.getHand().handPoint();
    }


    /**
     * Method to get point of Player
     * @return point
     */
    public int getPoint() {
        return point;
    }

    /**
     * Method to reset point to 0
     */
    public void resetPoint() {
        this.point = 0;
    }

    /**
     * Method to check if the hand has blackJack
     * @return boolean
     */
    public boolean blackJack(){
        return (this.getHand().getSize() == 2 && this.getHand().handPoint() == 21);
    }


    /**
     * Method to get Hand object
     * @return Hand
     */
    public Hand getHand(){
        return this.hand;
    }

    /**
     * Method to hit, add the card to Hand object from the first card of Deck.
     * @param deck the Deck to get the card from
     */
    public void hit(Deck deck){
        this.hand.addCard(deck.getFirstCard());
        this.point = this.hand.handPoint();

    }

    /**
     * Method to check if the point is bust.
     * @return boolean
     */
    public boolean isBust() {
        return this.getPoint() > 21;
    }


    /**
     * Turn movement of Player
     * @param deck the deck object to get the card from
     */
    public void turn(Deck deck){
        //check if blackjack
        if (this.blackJack()){
            System.out.println("BLACKJACK!");
            return;
        }

        Scanner scan = new Scanner(System.in);
        int input;

        while (true) {
            System.out.println("Press 1 for HIT (add one more card), 2 for STAND (hold the value and end your turn):");
            input = scan.nextInt();
            switch (input){
                case 1:
                    this.hit(deck);
                    showStatus();
                    if (isBust()) {
                        System.out.println("You Bust!");
                        this.resetPoint();
                        return;
                    }
                    break;
                case 2:
                    return;
                default:
                    System.out.println("Invalid input. Press again!");
            }
        }
    }

    /**
     * Method to show the hand of card
     * @return String format of Card in Hand
     */
    public String showHand() {
        return this.hand.toString();
    }

    /**
     * Method to show the Hand and point status of the player
     */
    public void showStatus() {
        System.out.println("Hand cards: " + this.showHand());
        System.out.println("Total point now: " + this.getPoint());
    }

}
