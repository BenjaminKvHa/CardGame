package edu.ntnu.idi.idatt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class DeckOfCardsTest {

  @Test
  void deckShouldContain52Cards() {
    DeckOfCards deck = new DeckOfCards();
    assertEquals(52, deck.getDeck().size());
  }

  @Test
  void dealHandShouldReturnCorrectNumberOfCards() {
    DeckOfCards deck = new DeckOfCards();
    List<PlayingCard> hand = deck.dealHand(5);
    assertEquals(5, hand.size());
    assertEquals(47, deck.getDeck().size());
  }

  @Test
  void dealingTooManyCardsThrowsException() {
    DeckOfCards deck = new DeckOfCards();
    assertThrows(IllegalArgumentException.class, () -> deck.dealHand(53));
  }
}
