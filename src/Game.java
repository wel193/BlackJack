/**
 * This class represents Game class with Player, Dealer and Deck.
 */
public class Game {
    private final Player player;
    private final Dealer dealer;
    private final Deck deck;

    /**
     * Constructor of Game. Initialize it with new object for Player, Dealer, and Deck.
     * The player and dealer has there initial two cards from the shuffled deck.
     */
    public Game() {
        deck = new Deck();

        deck.shuffle();
        player = new Player(deck);
        dealer = new Dealer(deck);
    }

    /**
     * Method toe initiate the game
     */
    public void play() {
        System.out.println("Game start!");

        System.out.println("Your initial card: " + player.showHand());
        System.out.println("Dealer's initial card: " + dealer.showInitialCard());
        System.out.println();

        System.out.println("=========== Your turn ============\n");
        player.turn(deck);
        System.out.println();

        System.out.println("=========== Dealer's turn ============");
        System.out.println("Dealer show second card......");
        System.out.println("Dealer's card: " + dealer.showHand());
        dealer.turn(deck);
        System.out.println();

        if (player.getPoint() == dealer.getPoint()) {
            System.out.println("Push!");
        } else {
            String winner = (player.getPoint() > dealer.getPoint()) ? "You" : "Dealer";
            System.out.println(winner + " win!");
        }
    }

    /**
     * Main function to execute the Game
     * @param arg entry point
     */
    public static void main(String[] arg){
        Game game = new Game();
        game.play();
    }


}
