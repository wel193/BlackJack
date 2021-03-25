import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class DeckTest {
    private Deck deck1;
    private Deck deck2;

    @Before
    public void setUp(){
        deck1 = new Deck();
        deck2 = new Deck(5, deck1);
    }

    @Test
    public void testGetCard(){
        Card card = new Card(Suit.CLUB, Name.SIX);
        assertEquals(card, deck1.getCard(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOutOfIndexGetCard(){
        deck1.getCard(60);
        deck2.getCard(-4);
    }

    @Test
    public void testGetFirstCard(){
        Card card = new Card(Suit.CLUB, Name.SIX);
        assertEquals(card, deck1.getFirstCard());
    }

    @Test(expected = IllegalStateException.class)
    public void testGetFirstCardFromEmptyDeck(){
        Deck deck3 = new Deck(0, deck1);
        deck3.getFirstCard();
    }

    @Test
    public void testGetSize(){
        assertEquals(47, deck1.getSize());
        assertEquals(5, deck2.getSize());
    }

    @Test
    public void testAddCard(){
        Card card = new Card(Suit.HEART, Name.SIX);
        deck2.addCard(card);
        assertEquals(card, deck2.getCard(5));
    }

    @Test
    public void testToString(){
        assertEquals(" | \u2663 ACE | \u2663 TWO | \u2663 THREE | \u2663 FOUR | \u2663 FIVE | ", deck2.toString());
    }
}

