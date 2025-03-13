package edu.ntnu.idi.idatt;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {

  private final List<PlayingCard> deck = new ArrayList<>();
  private final char[] suits = {'S', 'H', 'D', 'C'};

  public DeckOfCards() {
    for (char suit : suits) {
      for (int face = 1; face <= 13; face++) {
        deck.add(new PlayingCard(suit, face));
      }
    }
  }

  public List<PlayingCard> getDeck() {
    return deck;
  }
}
