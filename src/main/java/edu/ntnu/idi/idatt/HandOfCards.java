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

  public String getHeartsAsString() {
    var hearts = cards.stream()
        .filter(c -> c.getSuit() == 'H')
        .toList();

    if (hearts.isEmpty()) {
      return "No Hearts";
    }
    return hearts.stream()
        .map(PlayingCard::getAsString)
        .reduce((a, b) -> a + " " + b)
        .orElse("No Hearts");
  }

  public boolean hasQueenOfSpades() {
    return cards.stream()
        .anyMatch(c -> c.getSuit() == 'S' && c.getFace() == 12);
  }

  public boolean isFlush() {
    if (cards.size() < 5) {
      return false;
    }
    char suit = cards.get(0).getSuit();
    return cards.stream().allMatch(c -> c.getSuit() == suit);
  }
}
