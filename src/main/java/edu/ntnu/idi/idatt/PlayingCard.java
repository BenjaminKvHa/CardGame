package edu.ntnu.idi.idatt;

/**
 * Represents a playing card. A playing card has a number (face) between
 * 1 and 13, where 1 is called an Ace, 11 = Knight, 12 = Queen and 13 = King.
 * The card can also be one of 4 suits: Spade, Heart, Diamonds and Clubs.
 */
public class PlayingCard {

  private final char suit; // 'S'=spade, 'H'=heart, 'D'=diamonds, 'C'=clubs
  private final int face;  // a number between 1 and 13

  public PlayingCard(char suit, int face) {
    if (suit != 'H' && suit != 'D' && suit != 'C' && suit != 'S') {
      throw new IllegalArgumentException("Parameter suit must be one of H, D, C or S");
    }
    if (face < 1 || face > 13) {
      throw new IllegalArgumentException("Parameter face must be between 1 and 13");
    }
    this.suit = suit;
    this.face = face;
  }

  public String getAsString() {
    return String.format("%s%d", suit, face);
  }

  public char getSuit() {
    return suit;
  }

  public int getFace() {
    return face;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    PlayingCard that = (PlayingCard) o;
    return suit == that.suit && face == that.face;
  }

  @Override
  public int hashCode() {
    int result = Character.hashCode(suit);
    result = 31 * result + face;
    return result;
  }
}
