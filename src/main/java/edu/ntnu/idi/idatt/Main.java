package edu.ntnu.idi.idatt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class Main extends Application {

  private DeckOfCards deckOfCards;
  private List<PlayingCard> currentHand;

  private TextArea textAreaHand;
  private Button buttonDeal;
  private Button buttonCheck;
  private TextField textFieldSum;
  private TextField textFieldHearts;
  private TextField textFieldQueen;
  private TextField textFieldFlush;

  @Override
  public void start(Stage primaryStage) {
    deckOfCards = new DeckOfCards();

    textAreaHand = new TextArea("Display the hand of cards here");
    textAreaHand.setEditable(false);

    buttonDeal = new Button("Deal hand");
    buttonDeal.setOnAction(e -> dealHand());

    buttonCheck = new Button("Check hand");
    buttonCheck.setOnAction(e -> checkHand());

    textFieldSum = new TextField();
    textFieldSum.setEditable(false);

    textFieldHearts = new TextField();
    textFieldHearts.setEditable(false);

    textFieldQueen = new TextField();
    textFieldQueen.setEditable(false);

    textFieldFlush = new TextField();
    textFieldFlush.setEditable(false);

    Label labelSum = new Label("Sum of the faces:");
    Label labelHearts = new Label("Cards of hearts:");
    Label labelQueen = new Label("Queen of spades:");
    Label labelFlush = new Label("Flush:");

    VBox layout = new VBox(10);
    layout.setPadding(new Insets(15));
    layout.getChildren().addAll(
        textAreaHand,
        buttonDeal,
        buttonCheck,
        labelSum, textFieldSum,
        labelHearts, textFieldHearts,
        labelQueen, textFieldQueen,
        labelFlush, textFieldFlush
    );

    Scene scene = new Scene(layout, 400, 400);
    primaryStage.setScene(scene);
    primaryStage.setTitle("Card Game");
    primaryStage.show();
  }

  private void dealHand() {
    if (deckOfCards.getDeck().size() < 5) {
      deckOfCards = new DeckOfCards();
    }
    currentHand = deckOfCards.dealHand(5);

    StringBuilder sb = new StringBuilder();
    for (PlayingCard card : currentHand) {
      sb.append(card.getAsString()).append(" ");
    }
    textAreaHand.setText(sb.toString().trim());

    textFieldSum.clear();
    textFieldHearts.clear();
    textFieldQueen.clear();
    textFieldFlush.clear();
  }

  private void checkHand() {
    if (currentHand == null || currentHand.isEmpty()) {
      textFieldSum.setText("No hand dealt");
      return;
    }
    HandOfCards handOfCards = new HandOfCards(currentHand);

    textFieldSum.setText(String.valueOf(handOfCards.getSumOfFaces()));

    textFieldHearts.setText(handOfCards.getHeartsAsString());

    boolean hasQueen = handOfCards.hasQueenOfSpades();
    textFieldQueen.setText(hasQueen ? "Yes" : "No");

    boolean flush = handOfCards.isFlush();
    textFieldFlush.setText(flush ? "Yes" : "No");
  }

  public static void main(String[] args) {
    launch(args);
  }
}
