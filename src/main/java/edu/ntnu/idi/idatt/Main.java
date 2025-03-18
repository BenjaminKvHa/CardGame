package edu.ntnu.idi.idatt;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

  private TextArea textAreaHand;
  private Button buttonDeal;
  private Button buttonCheck;
  private TextField textFieldSum;
  private TextField textFieldHearts;
  private TextField textFieldQueen;
  private TextField textFieldFlush;

  @Override
  public void start(Stage primaryStage) {
    textAreaHand = new TextArea("Display the hand of cards here");
    textAreaHand.setEditable(false);

    buttonDeal = new Button("Deal hand");
    buttonCheck = new Button("Check hand");

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

  public static void main(String[] args) {
    launch(args);
  }
}
