package TicTacToe;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TicTacToeServer extends Application{
    private static String button;
    private static Label text;
    private static Button button1;
    private static Button button2;
    private static Button button3;
    private static Button button4;
    private static Button button5;
    private static Button button6;
    private static Button button7;
    private static Button button8;
    private static Button button9;
    private static boolean winner;
    private static String whoWon;
    private static String temp;
    private static PrintStream printer;

    @Override
    // Start the server socket and create the server GUI tic-tac-toe board
    // @param primaryStage: The stage to set server GUI tic-tac-toe board
    public void start(Stage primaryStage) throws Exception {
        temp = "0";
        winner = false;
        VBox mainPane = new VBox();
        GridPane board = new GridPane();
        board.setGridLinesVisible(true);
        text = new Label("Opponent's Turn");
        text.setFont(new Font("Times New Roman", 25));
        text.setMinWidth(250);
        mainPane.getChildren().add(board);
        mainPane.getChildren().add(text);
        button1 = new Button();
        button1.setMinSize(100,100 );
        board.add(button1, 0, 0);
        button2 = new Button();
        button2.setMinSize(100,100 );
        board.add(button2, 0, 1);
        button3 = new Button();
        button3.setMinSize(100,100 );
        board.add(button3, 0, 2);
        button4 = new Button();
        button4.setMinSize(100,100 );
        board.add(button4, 1, 0);
        button5 = new Button();
        button5.setMinSize(100,100 );
        board.add(button5, 1, 1);
        button6 = new Button();
        button6.setMinSize(100,100 );
        board.add(button6, 1, 2);
        button7 = new Button();
        button7.setMinSize(100,100 );
        board.add(button7, 2, 0);
        button8 = new Button();
        button8.setMinSize(100,100 );
        board.add(button8, 2, 1);
        button9 = new Button();
        button9.setMinSize(100,100 );
        board.add(button9, 2, 2);

        primaryStage.setTitle("Server Tic Tac Toe");
        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Create server for client socket to connect to
        ServerSocket server = new ServerSocket(5678);
        Socket client = server.accept();
        InputStream input = client.getInputStream();
        OutputStream output = client.getOutputStream();
        Scanner scanner = new Scanner(input);
        printer = new PrintStream(output);

        // Run a frame of the application
        new AnimationTimer() {
            @Override public void handle(long currentNanoTime){
                if (!winner) {
                    String line = scanner.nextLine();
                    if (line.equals("EXIT")){
                        winner = true;
                        text.setText("Opponent Exited Game");
                        button1.setOnMousePressed(null);
                        button2.setOnMousePressed(null);
                        button3.setOnMousePressed(null);
                        button4.setOnMousePressed(null);
                        button5.setOnMousePressed(null);
                        button6.setOnMousePressed(null);
                        button7.setOnMousePressed(null);
                        button8.setOnMousePressed(null);
                        button9.setOnMousePressed(null);
                        try {
                            client.shutdownInput();
                            client.shutdownOutput();
                            server.close();
                        } catch (IOException e) {
                        }
                    }
                    else if (line.equals("Exit")){
                        try {
                            client.shutdownInput();
                            client.shutdownOutput();
                            server.close();
                        } catch (IOException e) {
                        }
                        System.exit(0);
                    }
                    else if (line.equals("close")){
                        try {
                            client.shutdownInput();
                            client.shutdownOutput();
                            server.close();
                        } catch (IOException e) {
                        }
                    }
                    else if (!(line.equals(temp)) && !(line.equals("null"))) {
                        text.setText("Your Turn");
                        if (line.equals("1")) {
                            button1.setText("O");
                            button1.setOnMousePressed(null);
                        } else if (line.equals("2")) {
                            button2.setText("O");
                            button2.setOnMousePressed(null);
                        } else if (line.equals("3")) {
                            button3.setText("O");
                            button3.setOnMousePressed(null);
                        } else if (line.equals("4")) {
                            button4.setText("O");
                            button4.setOnMousePressed(null);
                        } else if (line.equals("5")) {
                            button5.setText("O");
                            button5.setOnMousePressed(null);
                        } else if (line.equals("6")) {
                            button6.setText("O");
                            button6.setOnMousePressed(null);
                        } else if (line.equals("7")) {
                            button7.setText("O");
                            button7.setOnMousePressed(null);
                        } else if (line.equals("8")) {
                            button8.setText("O");
                            button8.setOnMousePressed(null);
                        } else if (line.equals("9")) {
                            button9.setText("O");
                            button9.setOnMousePressed(null);
                        }
                        if (button1.getText().isEmpty()) {
                            button1.setOnMousePressed(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    button1.setText("X");
                                    button = "1";
                                    text.setText("Opponent's Turn");
                                    button1.setOnMousePressed(null);
                                    button2.setOnMousePressed(null);
                                    button3.setOnMousePressed(null);
                                    button4.setOnMousePressed(null);
                                    button5.setOnMousePressed(null);
                                    button6.setOnMousePressed(null);
                                    button7.setOnMousePressed(null);
                                    button8.setOnMousePressed(null);
                                    button9.setOnMousePressed(null);
                                }
                            });
                        }
                        if (button2.getText().isEmpty()) {
                            button2.setOnMousePressed(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    button2.setText("X");
                                    button = "2";
                                    text.setText("Opponent's Turn");
                                    button1.setOnMousePressed(null);
                                    button2.setOnMousePressed(null);
                                    button3.setOnMousePressed(null);
                                    button4.setOnMousePressed(null);
                                    button5.setOnMousePressed(null);
                                    button6.setOnMousePressed(null);
                                    button7.setOnMousePressed(null);
                                    button8.setOnMousePressed(null);
                                    button9.setOnMousePressed(null);
                                }
                            });
                        }
                        if (button3.getText().isEmpty()) {
                            button3.setOnMousePressed(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    button3.setText("X");
                                    button = "3";
                                    text.setText("Opponent's Turn");
                                    button1.setOnMousePressed(null);
                                    button2.setOnMousePressed(null);
                                    button3.setOnMousePressed(null);
                                    button4.setOnMousePressed(null);
                                    button5.setOnMousePressed(null);
                                    button6.setOnMousePressed(null);
                                    button7.setOnMousePressed(null);
                                    button8.setOnMousePressed(null);
                                    button9.setOnMousePressed(null);
                                }
                            });
                        }
                        if (button4.getText().isEmpty()) {
                            button4.setOnMousePressed(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    button4.setText("X");
                                    button = "4";
                                    text.setText("Opponent's Turn");
                                    button1.setOnMousePressed(null);
                                    button2.setOnMousePressed(null);
                                    button3.setOnMousePressed(null);
                                    button4.setOnMousePressed(null);
                                    button5.setOnMousePressed(null);
                                    button6.setOnMousePressed(null);
                                    button7.setOnMousePressed(null);
                                    button8.setOnMousePressed(null);
                                    button9.setOnMousePressed(null);
                                }
                            });
                        }
                        if (button5.getText().isEmpty()) {
                            button5.setOnMousePressed(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    button5.setText("X");
                                    text.setText("Opponent's Turn");
                                    button = "5";
                                    button1.setOnMousePressed(null);
                                    button2.setOnMousePressed(null);
                                    button3.setOnMousePressed(null);
                                    button4.setOnMousePressed(null);
                                    button5.setOnMousePressed(null);
                                    button6.setOnMousePressed(null);
                                    button7.setOnMousePressed(null);
                                    button8.setOnMousePressed(null);
                                    button9.setOnMousePressed(null);
                                }
                            });
                        }
                        if (button6.getText().isEmpty()) {
                            button6.setOnMousePressed(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    button6.setText("X");
                                    button = "6";
                                    text.setText("Opponent's Turn");
                                    button1.setOnMousePressed(null);
                                    button2.setOnMousePressed(null);
                                    button3.setOnMousePressed(null);
                                    button4.setOnMousePressed(null);
                                    button5.setOnMousePressed(null);
                                    button6.setOnMousePressed(null);
                                    button7.setOnMousePressed(null);
                                    button8.setOnMousePressed(null);
                                    button9.setOnMousePressed(null);
                                }
                            });
                        }
                        if (button7.getText().isEmpty()) {
                            button7.setOnMousePressed(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    button7.setText("X");
                                    button = "7";
                                    text.setText("Opponent's Turn");
                                    button1.setOnMousePressed(null);
                                    button2.setOnMousePressed(null);
                                    button3.setOnMousePressed(null);
                                    button4.setOnMousePressed(null);
                                    button5.setOnMousePressed(null);
                                    button6.setOnMousePressed(null);
                                    button7.setOnMousePressed(null);
                                    button8.setOnMousePressed(null);
                                    button9.setOnMousePressed(null);
                                }
                            });
                        }
                        if (button8.getText().isEmpty()) {
                            button8.setOnMousePressed(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    button8.setText("X");
                                    button = "8";
                                    text.setText("Opponent's Turn");
                                    button1.setOnMousePressed(null);
                                    button2.setOnMousePressed(null);
                                    button3.setOnMousePressed(null);
                                    button4.setOnMousePressed(null);
                                    button5.setOnMousePressed(null);
                                    button6.setOnMousePressed(null);
                                    button7.setOnMousePressed(null);
                                    button8.setOnMousePressed(null);
                                    button9.setOnMousePressed(null);
                                }
                            });
                        }
                        if (button9.getText().isEmpty()) {
                            button9.setOnMousePressed(new EventHandler<MouseEvent>() {
                                @Override
                                public void handle(MouseEvent event) {
                                    button9.setText("X");
                                    button = "9";
                                    text.setText("Opponent's Turn");
                                    button1.setOnMousePressed(null);
                                    button2.setOnMousePressed(null);
                                    button3.setOnMousePressed(null);
                                    button4.setOnMousePressed(null);
                                    button5.setOnMousePressed(null);
                                    button6.setOnMousePressed(null);
                                    button7.setOnMousePressed(null);
                                    button8.setOnMousePressed(null);
                                    button9.setOnMousePressed(null);
                                }
                            });
                        }
                        temp = line;
                    }
                    printer.println(button);
                    checkWinner(line);
                    if (winner) {
                        printer.println(whoWon);
                    }
                }
            }
        }.start();
    }

    // Check if the current move results in a win
    // @param lines: String representing the current space to check win from
    private static void checkWinner(String line){
        if (line.equals("1") || button == "1"){
            if (button1.getText().equals("X") && button2.getText().equals("X") && button3.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button1.getText().equals("X") && button4.getText().equals("X") && button7.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button1.getText().equals("X") && button5.getText().equals("X") && button9.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button1.getText().equals("O") && button2.getText().equals("O") && button3.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");

            }
            else if (button1.getText().equals("O") && button4.getText().equals("O") && button7.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button1.getText().equals("O") && button5.getText().equals("O") && button9.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
        }
        if (line.equals("2") || button == "2"){
            if (button1.getText().equals("X") && button2.getText().equals("X") && button3.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button2.getText().equals("X") && button5.getText().equals("X") && button8.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button1.getText().equals("O") && button2.getText().equals("O") && button3.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button2.getText().equals("O") && button5.getText().equals("O") && button8.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
        }
        if (line.equals("3") || button == "3"){
            if (button1.getText().equals("X") && button2.getText().equals("X") && button3.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button3.getText().equals("X") && button6.getText().equals("X") && button9.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button3.getText().equals("X") && button5.getText().equals("X") && button7.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button1.getText().equals("O") && button2.getText().equals("O") && button3.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button3.getText().equals("O") && button6.getText().equals("O") && button9.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button3.getText().equals("O") && button5.getText().equals("O") && button7.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
        }
        if (line.equals("4") || button == "4"){
            if (button1.getText().equals("X") && button4.getText().equals("X") && button7.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button4.getText().equals("X") && button5.getText().equals("X") && button6.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button1.getText().equals("O") && button4.getText().equals("O") && button7.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button4.getText().equals("O") && button5.getText().equals("O") && button6.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
        }
        if (line.equals("5") || button == "5"){
            if (button2.getText().equals("X") && button5.getText().equals("X") && button8.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button4.getText().equals("X") && button5.getText().equals("X") && button6.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button3.getText().equals("X") && button5.getText().equals("X") && button7.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button1.getText().equals("X") && button5.getText().equals("X") && button9.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button2.getText().equals("O") && button5.getText().equals("O") && button8.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button4.getText().equals("O") && button5.getText().equals("O") && button6.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button3.getText().equals("O") && button5.getText().equals("O") && button7.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button1.getText().equals("O") && button5.getText().equals("O") && button9.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
        }
        if (line.equals("6") || button == "6"){
            if (button3.getText().equals("X") && button6.getText().equals("X") && button9.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button4.getText().equals("X") && button5.getText().equals("X") && button6.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button3.getText().equals("O") && button6.getText().equals("O") && button9.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button4.getText().equals("O") && button5.getText().equals("O") && button6.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
        }
        if (line.equals("7") || button == "7"){
            if (button1.getText().equals("X") && button4.getText().equals("X") && button7.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button7.getText().equals("X") && button8.getText().equals("X") && button9.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button3.getText().equals("X") && button5.getText().equals("X") && button7.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button1.getText().equals("O") && button4.getText().equals("O") && button7.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button7.getText().equals("O") && button8.getText().equals("O") && button9.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button3.getText().equals("O") && button5.getText().equals("O") && button7.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
        }
        if (line.equals("8") || button == "8"){
            if (button2.getText().equals("X") && button5.getText().equals("X") && button8.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button7.getText().equals("X") && button8.getText().equals("X") && button9.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button2.getText().equals("O") && button5.getText().equals("O") && button8.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button7.getText().equals("O") && button8.getText().equals("O") && button9.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
        }
        if (line.equals("9") || button == "9"){
            if (button3.getText().equals("X") && button6.getText().equals("X") && button9.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button7.getText().equals("X") && button8.getText().equals("X") && button9.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button1.getText().equals("X") && button5.getText().equals("X") && button9.getText().equals("X")){
                winner = true;
                whoWon = "Player 2";
                text.setText("You Won!");
            }
            else if (button3.getText().equals("O") && button6.getText().equals("O") && button9.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button7.getText().equals("O") && button8.getText().equals("O") && button9.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
            else if (button1.getText().equals("O") && button5.getText().equals("O") && button9.getText().equals("O")){
                winner = true;
                whoWon = "Player 1";
                text.setText("You Lose.");
            }
        }
        if (!winner && !button1.getText().isEmpty() && !button2.getText().isEmpty() && !button3.getText().isEmpty()
                && !button4.getText().isEmpty() && !button5.getText().isEmpty() && !button6.getText().isEmpty()
                && !button7.getText().isEmpty() && !button8.getText().isEmpty() && !button9.getText().isEmpty()) {
            winner = true;
            whoWon = "Tie";
            text.setText("Tie");
        }
        if (winner){
            button1.setOnMousePressed(null);
            button2.setOnMousePressed(null);
            button3.setOnMousePressed(null);
            button4.setOnMousePressed(null);
            button5.setOnMousePressed(null);
            button6.setOnMousePressed(null);
            button7.setOnMousePressed(null);
            button8.setOnMousePressed(null);
            button9.setOnMousePressed(null);
        }
    }

    @Override
    // Close the server application
    public void stop() throws Exception {
        printer.println("EXIT");
    }

    // Launch the server application
    public static void main(String[] args) throws IOException {
        Application.launch(args);

    }
}