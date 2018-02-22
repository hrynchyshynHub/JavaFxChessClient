package com.chess.model;


import com.chess.config.ApplicationProperties;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

public class ChessBoard{

    public static final int BOARD_SIZE = 8;
    public static final int CELL_SIZE = 100;

    private Group cellGroup = new Group();
    private Group pieceGruop = new Group();


    public Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(ApplicationProperties.getWidth(), ApplicationProperties.getHeight());

        root.getChildren().addAll(cellGroup, pieceGruop);

        for(int y = 0; y < BOARD_SIZE; y++){
            for(int x = 0 ; x < BOARD_SIZE; x++){
                Cell cell = new Cell((x + y)%2 ==0, x,y);
                cellGroup.getChildren().add(cell);
            }
        }
        return root;
    }

}