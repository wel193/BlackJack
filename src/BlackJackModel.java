public class BlackJackModel {
    private Player player;
    private Dealer dealer;
    private Deck deck;
    private boolean playerStand;
    private boolean dealerStand;

    public BlackJackModel(){
        deck = new Deck();
        deck.shuffle();
        player = new Player();
        dealer = new Dealer();
        playerStand = false;
        dealerStand = false;
    }

    public Card getPlayerHitCard(){
        player.hit(deck);
        int size = player.getHand().getSize();
        return player.getHand().getCard(size-1);
    }

    public Card getDealerHitCard(){
        dealer.hit(deck);
        int size = dealer.getHand().getSize();
        return dealer.getHand().getCard(size-1);
    }


    public boolean dealerCanHit(){
        return dealer.getScore() < 17;
    }


    public boolean playerBust(){
        return player.isBust();
    }

    public boolean dealerBust(){
        return dealer.isBust();
    }

    public boolean playerBJ(){
        return player.blackJack();
    }

    public boolean dealerBJ(){
        return dealer.blackJack();
    }


    public boolean isGameOver(){
        return dealerStand && playerStand;
    }

    public void setPlayerStand(){
        playerStand = true;
    }

    public void setDealerStand(){
        dealerStand = true;
    }

    public boolean tieGame(){
        return ((dealerBust() && playerBust()) || (dealerBJ() && playerBJ()) || (player.getScore() == dealer.getScore()));
    }

    public String getWinner() throws IllegalStateException {
        if (tieGame()){
            throw new IllegalStateException("There has no winner for this round.");
        }

        // otherwise, the player with a better hand wins
        if (player.getScore() > dealer.getScore()) {
            return "You";
        } else {
            return "Dealer";
        }
    }
}

