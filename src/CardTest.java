import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    private Card card;

    @Before
    public void setUp(){
        card = new Card(Suit.CLUB, Name.EIGHT);
    }

    @Test
    public void testGetSuit(){
        assertEquals(Suit.CLUB, card.getSuit());
    }

    @Test
    public void testGetName(){
        assertEquals(Name.EIGHT, card.getName());
    }

    @Test
    public void testGetCardPoint(){
        assertEquals(8, card.getCardPoint());
    }

    @Test
    public void testToString(){
        assertEquals("\u2663 EIGHT", card.toString());
    }

    @Test
    public void testCompareTo(){
        Card card1 = new Card(Suit.DIAMOND, Name.FIVE );
        Card card2 = new Card(Suit.CLUB, Name.EIGHT);
        Card card3 = new Card(Suit.HEART, Name.JACK);
        assertEquals(3, card.compareTo(card1));
        assertEquals(0, card.compareTo(card2));
        assertEquals(-3, card.compareTo(card3));
    }

    @Test
    public void testEquals(){
        Card card1 = new Card(Suit.CLUB, Name.EIGHT);
        assertTrue(card.equals(card1));
    }

}
