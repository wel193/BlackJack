public class Card implements Comparable<Card>{

    private Suit suit;
    private Name name;

    public Card(Suit suit, Name name){
        this.suit = suit;
        this.name = name;
    }

    public Suit getSuit(){
        return this.suit;
    }

    public Name getName(){
        return this.name;
    }

    public int getCardPoint(){
        return this.getName().point();
    }

    @Override
    public String toString(){
        return getSuit() + " " + getName();
    }

    @Override
    public int compareTo(Card card){
        return this.getName().number() - card.getName().number();
    }

}
