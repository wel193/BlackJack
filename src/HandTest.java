import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandTest {
    private Deck deck;
    private Deck deck1;

    @Before
    public void setUp(){
        deck1 = new Deck();
        deck = new Deck(0, deck1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOutOfIndexGetCard(){
        deck.getCard(1);
    }

    @Test(expected = IllegalStateException.class)
    public void testGetFirstCardFromEmptyDeck(){
        deck.getFirstCard();
    }

    @Test
    public void testGetSize(){
        assertEquals(0, deck.getSize());
    }

    @Test
    public void testAddCard(){
        Card card = new Card(Suit.HEART, Name.SIX);
        deck.addCard(card);
        assertEquals(card, deck.getCard(0));
    }

    @Test
    public void testToString(){
        assertEquals("", deck.toString());
    }



}

