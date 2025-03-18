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
}
