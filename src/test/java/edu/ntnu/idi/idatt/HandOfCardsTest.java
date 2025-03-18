package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

class HandOfCardsTest {

  @Test
  void testSumOfFaces() {
    List<PlayingCard> cards = Arrays.asList(
        new PlayingCard('H', 1),
        new PlayingCard('H', 2),
        new PlayingCard('H', 3)
    );
    HandOfCards hand = new HandOfCards(cards);
    assertEquals(6, hand.getSumOfFaces());
  }

  @Test
  void testGetHeartsAsString() {
    List<PlayingCard> cards = Arrays.asList(
        new PlayingCard('H', 10),
        new PlayingCard('H', 12),
        new PlayingCard('S', 5)
    );
    HandOfCards hand = new HandOfCards(cards);
    assertEquals("H10 H12", hand.getHeartsAsString());
  }

  @Test
  void testNoHearts() {
    List<PlayingCard> cards = Arrays.asList(
        new PlayingCard('S', 5),
        new PlayingCard('D', 9)
    );
    HandOfCards hand = new HandOfCards(cards);
    assertEquals("No Hearts", hand.getHeartsAsString());
  }

  @Test
  void testHasQueenOfSpades() {
    List<PlayingCard> cards = Arrays.asList(
        new PlayingCard('S', 12),
        new PlayingCard('H', 3)
    );
    HandOfCards hand = new HandOfCards(cards);
    assertTrue(hand.hasQueenOfSpades());
  }

  @Test
  void testIsFlush() {
    // 5 hearts
    List<PlayingCard> cards = Arrays.asList(
        new PlayingCard('H', 5),
        new PlayingCard('H', 6),
        new PlayingCard('H', 7),
        new PlayingCard('H', 8),
        new PlayingCard('H', 9)
    );
    HandOfCards hand = new HandOfCards(cards);
    assertTrue(hand.isFlush());

    List<PlayingCard> cards2 = Arrays.asList(
        new PlayingCard('H', 5),
        new PlayingCard('H', 6),
        new PlayingCard('H', 7),
        new PlayingCard('H', 8),
        new PlayingCard('S', 9)
    );
    HandOfCards hand2 = new HandOfCards(cards2);
    assertFalse(hand2.isFlush());
  }
}
