public class Game {
    private final Player player;
    private final Dealer dealer;
    private final Deck deck;


    public Game() {
        deck = new Deck();
        deck.shuffle();

        player = new Player(deck);
        dealer = new Dealer(deck);
    }

    public void play() {
        System.out.println("Game start!");
        System.out.println("Your initial card: " + player.showHand());
        System.out.println("Dealer's initial card: " + dealer.showFirstHand());
        System.out.println();

        System.out.println("=========== Your turn ============");
        player.turn(deck);
        System.out.println();

        System.out.println("Dealer's card: " + dealer.showHand());
        System.out.println("=========== Dealer's turn ============");
        dealer.turn(deck);
        System.out.println();

        if (player.getPoint() == dealer.getPoint()) {
            System.out.println("Draw!");
        } else {
            String winner = (player.getPoint() > dealer.getPoint()) ? "You" : "Dealer";
            System.out.println(winner + " win!");
        }

        deck.sortCard();
        System.out.println("Deck: " + deck);

    }

    public static void main(String[] arg){
        Game game = new Game();
        game.play();
    }


}
