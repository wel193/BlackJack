/**
 * Enum type of card's name
 */
public enum Name {
    ACE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
    NINE(9), TEN(10), JACK(11, 10), QUEEN(12,10), KING(13,10);

    private final int num;
    private final int point;

    /**
     * Constructor of the Name enum with number
     * @param num the number of the Card's name
     */
    Name(int num){
        this.num = num;
        this.point = num;
    }

    /**
     * Constructor of the Name enum with number and point
     * @param num the number of the Card's name
     * @param point the point value of the Card's point in BlackJack game
     */
    Name(int num, int point){
        this.num = num;
        this.point = point;
    }

    /**
     * Accessor method to the number
     * @return number
     */
    public int number(){
        return this.num;
    }

    /**
     * Accessor method to the point
     * @return point
     */
    public int point(){
        return this.point;
    }
}
