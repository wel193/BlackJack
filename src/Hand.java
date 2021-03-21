import java.util.ArrayList;

public class Hand extends Deck{


    public Hand(){
        deck = new ArrayList<>();
    }

    public boolean isBlackJack(){
        return (this.getDeckSize() == 2 && this.handPoint() == 21);
    }

    public int handPoint(){
        int point = 0;
        boolean hasAce = false;
        for (Card c: this.deck){
            point += c.getCardPoint();
            if (c.getName() == Name.ACE){
                hasAce = true;
            }
        }
        if (hasAce && point + 10 <= 21){
            point += 10;
        }
        return point;
    }

    public static void main(String[] arg){
        Deck deck = new Deck();
        Hand hand1 = new Hand();
        Hand hand2 = new Hand();

        deck.shuffle();
        for (int i = 0; i < 5; i ++){
            hand1.addCard(deck.getFirstCard());
            hand2.addCard(deck.getFirstCard());
        }

        hand1.sortCard();
        hand2.sortCard();
        System.out.println("Hand 1: " + hand1);
        System.out.println("Hand 2: " + hand2);
        System.out.println("Deck: " + deck);
        System.out.println(deck.getDeckSize());

    }

}
