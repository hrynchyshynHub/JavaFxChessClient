package com.chess;

import com.chess.config.MainConfig;
import com.chess.model.ChessBoard;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * Created by ivan.hrynchyshyn on 23.11.2017.
 */
public class MenuControlller {
    @FXML
    private Button btnNewGame;
    @FXML
    private Button btnLoadGame;
    @FXML
    private Button btnExit;
    @FXML
    private Label welcomelabel = new Label("Welcome user : " + MainConfig.getUser().getUsername());
    @FXML
    private AnchorPane pane;


    public void newGame(ActionEvent event){
        Stage stage;
        Parent root;
        stage = (Stage)btnNewGame.getScene().getWindow();

        ChessBoard chessBoard = new ChessBoard();
        Scene scene = new Scene(chessBoard.createContent(), 480, 480);

        stage.setScene(scene);
        stage.show();
    }
    public void loadGame(ActionEvent event){

    }
    public void exit(ActionEvent event){
        System.exit(0);
    }

    @FXML
    public void initialize(){
        welcomelabel.setLabelFor(btnNewGame);
        welcomelabel.setFont(new Font(25));
        pane.getChildren().add(welcomelabel);
    }
}
