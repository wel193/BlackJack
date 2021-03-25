/**
 * This class represents Dealer extends Player
 */
public class Dealer extends Player{

    /**
     * Default constructor of Dealer with empty hand card.
     */
    public Dealer(){
        super();
    }

    /**
     * Constructor of Dealer. Initializes it with Hand object with size 2, the default name, and initial points.
     */
    public Dealer(Deck sourceDeck) {
        super(sourceDeck);
    }


    /**
     * Override turn method from Player class. The turn terminate while Dealer hit 17 points or bust.
     * @param deck the deck object to get the card from
     */
    @Override
    public void turn(Deck deck) {
        if (this.blackJack()){
            System.out.println("BLACKJACK!");
            return;
        }

        while (this.getScore() < 17){
            this.hit(deck);
            System.out.print("Dealer hits ===> ");
            this.showStatus();
            if (this.isBust()){
                System.out.println("Dealer Busts!");
                this.resetScore();
                return;
            }
        }
    }

    public String showInitialCard(){
        return " | " + getHand().getCard(0) + " | * HIDDEN CARD * | ";
    }

}
