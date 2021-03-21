public class Dealer extends AbstractPlayer{

    public Dealer(Deck deck){
        super(deck);
    }


    @Override
    public void turn(Deck deck) {
        checkBlackJack();
        while (!this.isHold()){
            super.turn(deck);
            if (this.getPoint() >= 17){
                this.hold();
                break;
            }
        }
    }

    public String showFirstHand(){
        return " | " + getHand().showFirstCard() + " | XXXXX | ";
    }

}
