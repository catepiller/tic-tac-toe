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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class TicTacToeClient extends Application{
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
    private static boolean temp;
    private static String temp2;
    private static PrintStream printer;
    private static Socket socket;

    @Override
    // Start the client socket and create the client GUI tic-tac-toe board
    // @param primaryStage: The stage to set client GUI tic-tac-toe board
    public void start(Stage primaryStage) throws Exception {
        temp2 = "0";
        temp = false;
        winner = false;
        VBox mainPane = new VBox();
        GridPane board = new GridPane();
        board.setGridLinesVisible(true);
        text = new Label();
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

        primaryStage.setTitle("Client Tic Tac Toe");
        Scene scene = new Scene(mainPane);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Connect the client application to the server
        socket = new Socket("localhost", 5678); //change host and port depending on where server is located
        InputStream input = socket.getInputStream();
        Scanner scanner = new Scanner(input);
        OutputStream output = socket.getOutputStream();
        printer = new PrintStream(output);

        // Run a frame of the application
        new AnimationTimer() {
            @Override public void handle(long currentNanoTime) {
                if (!winner) {
                    text.setText("Your Turn");
                    printer.println(button);
                    if (button1.getText().isEmpty()) {
                        button1.setOnMousePressed(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                button1.setText("O");
                                button = "1";
                                button1.setOnMousePressed(null);
                                temp = true;
                            }
                        });
                    }
                    if (button2.getText().isEmpty()) {
                        button2.setOnMousePressed(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                button2.setText("O");
                                button = "2";
                                button2.setOnMousePressed(null);
                                temp = true;
                            }
                        });
                    }
                    if (button3.getText().isEmpty()) {
                        button3.setOnMousePressed(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                button3.setText("O");
                                button = "3";
                                button3.setOnMousePressed(null);
                                temp = true;
                            }
                        });
                    }
                    if (button4.getText().isEmpty()) {
                        button4.setOnMousePressed(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                button4.setText("O");
                                button = "4";
                                button4.setOnMousePressed(null);
                                temp = true;
                            }
                        });
                    }
                    if (button5.getText().isEmpty()) {
                        button5.setOnMousePressed(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                button5.setText("O");
                                button = "5";
                                button5.setOnMousePressed(null);
                                temp = true;
                            }
                        });
                    }
                    if (button6.getText().isEmpty()) {
                        button6.setOnMousePressed(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                button6.setText("O");
                                button = "6";
                                button6.setOnMousePressed(null);
                                temp = true;
                            }
                        });
                    }
                    if (button7.getText().isEmpty()) {
                        button7.setOnMousePressed(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                button7.setText("O");
                                button = "7";
                                button7.setOnMousePressed(null);
                                temp = true;
                            }
                        });
                    }
                    if (button8.getText().isEmpty()) {
                        button8.setOnMousePressed(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                button8.setText("O");
                                button = "8";
                                button8.setOnMousePressed(null);
                                temp = true;
                            }
                        });
                    }
                    if (button9.getText().isEmpty()) {
                        button9.setOnMousePressed(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent event) {
                                button9.setText("O");
                                button = "9";
                                button9.setOnMousePressed(null);
                                temp = true;
                            }
                        });
                    }
                    if (temp){
                        button1.setOnMousePressed(null);
                        button2.setOnMousePressed(null);
                        button3.setOnMousePressed(null);
                        button4.setOnMousePressed(null);
                        button5.setOnMousePressed(null);
                        button6.setOnMousePressed(null);
                        button7.setOnMousePressed(null);
                        button8.setOnMousePressed(null);
                        button9.setOnMousePressed(null);
                        text.setText("Opponent's Turn");
                    }
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
                        printer.println("Exit");
                        try {
                            socket.shutdownOutput();
                            socket.shutdownInput();
                        } catch (IOException e) {
                        }
                    }
                    else if (line.equals("Player 1") || line.equals("Player 2") || line.equals("Tie")) {
                        if (line.equals("Player 1")) {
                            text.setText("You Won!");
                        }
                        else if (line.equals("Player 2")){
                            text.setText("You Lose.");
                        }
                        else if (line.equals("Tie")){
                            text.setText("Tie");
                        }
                        winner = true;
                        printer.println("close");
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
                            socket.shutdownOutput();
                            socket.shutdownInput();
                        } catch (IOException e) {
                        }
                    }
                    else if (!(temp2.equals(line))) {
                        if (line.equals("1")) {
                            button1.setText("X");
                            button1.setOnMousePressed(null);
                            temp = false;
                        } else if (line.equals("2")) {
                            button2.setText("X");
                            button2.setOnMousePressed(null);
                            temp = false;
                        } else if (line.equals("3")) {
                            button3.setText("X");
                            button3.setOnMousePressed(null);
                            temp = false;
                        } else if (line.equals("4")) {
                            button4.setText("X");
                            button4.setOnMousePressed(null);
                            temp = false;
                        } else if (line.equals("5")) {
                            button5.setText("X");
                            button5.setOnMousePressed(null);
                            temp = false;
                        } else if (line.equals("6")) {
                            button6.setText("X");
                            button6.setOnMousePressed(null);
                            temp = false;
                        } else if (line.equals("7")) {
                            button7.setText("X");
                            button7.setOnMousePressed(null);
                            temp = false;
                        } else if (line.equals("8")) {
                            button8.setText("X");
                            button8.setOnMousePressed(null);
                            temp = false;
                        } else if (line.equals("9")) {
                            button9.setText("X");
                            button9.setOnMousePressed(null);
                            temp = false;
                        }
                        temp2 = line;
                    }
                }
            }
        }.start();
    }

    @Override
    // Close the server application
    public void stop() throws Exception {
        printer.println("EXIT");
        try {
            socket.shutdownOutput();
            socket.shutdownInput();
        } catch (IOException e) {
        }
        System.exit(0);
    }

    // Launch the server application
    // prerequisite: Server application must be run first
    public static void main(String[] args) throws IOException {
        Application.launch(args);

    }
}
