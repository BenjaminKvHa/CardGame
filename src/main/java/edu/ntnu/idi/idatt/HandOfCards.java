package edu.ntnu.idi.idatt;

import java.util.List;

public class HandOfCards {

  private final List<PlayingCard> cards;

  public HandOfCards(List<PlayingCard> cards) {
    this.cards = cards;
  }

  public List<PlayingCard> getCards() {
    return cards;
  }

  public int getSumOfFaces() {
    int sum = 0;
    for (PlayingCard card : cards) {
      sum += card.getFace();
    }
    return sum;
  }
}
