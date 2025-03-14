package edu.ntnu.idi.idatt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DeckOfCards {

  private final List<PlayingCard> deck = new ArrayList<>();
  private final char[] suits = {'S', 'H', 'D', 'C'};
  private final Random random = new Random();

  public DeckOfCards() {
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        deck.add(new PlayingCard(suit, face));
      }
    }
  }

  /**
   * Picks n random cards from the deck (and removes them from the deck).
   * @param n number of cards to pick
   * @return a List of n randomly picked PlayingCards
   */
  public List<PlayingCard> dealHand(int n) {
    if (n < 1 || n > deck.size()) {
      throw new IllegalArgumentException("Cannot deal " + n + " cards. Deck has " + deck.size());
    }
    List<PlayingCard> hand = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      int index = random.nextInt(deck.size());
      hand.add(deck.remove(index));
    }
    return hand;
  }

  public List<PlayingCard> getDeck() {
    return deck;
  }
}
