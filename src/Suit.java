/**
 * Enum type of suits
 */
public enum Suit {CLUB("\u2663"), DIAMOND("\u2666"), HEART("\u2665"), SPADE("\u2660");

    private String symbol;

    /**
     * constructor of Suit enum with symbol
     * @param symbol the symbol of the suit
     */
    Suit(String symbol){
        this.symbol = symbol;
    }

    /**
     * Override toString method to print out the symbol of the Suit
     * @return string format
     */
    @Override
    public String toString(){
        return this.symbol;
    }

}
