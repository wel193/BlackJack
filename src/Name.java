/**
 * Enum type of card's name
 */
public enum Name {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
    NINE(9), TEN(10), JACK(11, 10), QUEEN(12,10), KING(13,10);

    private final int num;
    private final int point;

    Name(int num){
        this.num = num;
        this.point = num;
    }

    Name(int num, int point){
        this.num = num;
        this.point = point;
    }

    public int number(){
        return this.num;
    }

    public int point(){
        return this.point;
    }
}
