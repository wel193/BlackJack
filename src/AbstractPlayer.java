public abstract class AbstractPlayer {
    private int point;
    private Hand hand;
    private boolean hold;

    public AbstractPlayer(Deck deck) {
        point = 0;
        hand = new Hand();
        hold = false;

        try {
            this.pushInitialCard(deck);
        } catch (IllegalHandSignal e) {
            System.out.println(e.getMessage());
        }
    }

    public int getPoint() {
        return point;
    }

    public void resetPoint() {
        this.point = 0;
    }


    public void checkBlackJack() {
        if (getHand().isBlackJack()){
            hold();
            System.out.println("BLACKJACK!");
        }
    }

    public Hand getHand() {
        return this.hand;
    }

    public void pushInitialCard(Deck deck) throws IllegalHandSignal {
        if (this.hand.getDeckSize() > 2) {
            throw new IllegalHandSignal("You already got initial card.");
        }
        hit(deck);
        hit(deck);
    }

    public void hit(Deck deck) throws IllegalHandSignal {
        if (isHold()) {
            throw new IllegalHandSignal("You can't hit anymore.");
        }

        //add the first card of deck to the hand of card and update the point.
        Card card = deck.getFirstCard();
        this.hand.addCard(card);

        //update point
        this.point = this.getHand().handPoint();

    }

    public boolean isHold() {
        return hold;
    }

    public void hold() {
        hold = true;
    }

    public boolean isBust() {
        return this.getPoint() > 21;
    }

    /**
     * Turn movement
     * @param deck
     */
    public void turn(Deck deck){
        try {
            hit(deck);
            showStatus();
            if (isBust()) {
                this.resetPoint();
                this.hold();
                System.out.println("Bust!");
            }
        } catch (IllegalHandSignal e) {
            System.out.println(e.getMessage());
        }
    }



    public String showHand() {
        return this.hand.toString();
    }

    public void showStatus() {
        System.out.println("Hand cards: " + this.showHand());
        System.out.println("Total point now: " + this.getPoint());
    }
}
