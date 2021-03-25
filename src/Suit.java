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
     * Method to get the symbol of the suit
     * @return string format
     */
    public String symbol(){
        return this.symbol;
    }

}
