package com.chess.model;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

import static com.chess.model.ChessBoard.CELL_SIZE;

public  class Piece extends StackPane{

    private PieceType pieceType;
    private Text text;

    public Piece(PieceType pieceType, int x, int y){
        this.pieceType = pieceType;
        Image image = new Image(getClass().getResourceAsStream(pieceType.getPathToImage()));
        ImageView imageView = new ImageView(image);
        setTranslateX(x * CELL_SIZE);
        setTranslateY(y * CELL_SIZE);
        getChildren().addAll(imageView);
    }

    public Piece(String name){
        this.text = new Text(name);
        text.setFill(Color.BLUE);
    }

    public Pane createPiece(PieceType pieceType, int x, int y){
        text = createText(pieceType.toString());
        StackPane layout = new StackPane();
        layout.getChildren().addAll(text);
        layout.setPadding(new Insets(50));
        return layout;
    }

    private Text createText(String string) {
        System.out.println(string);
        Text text = new Text(string);
        text.setBoundsType(TextBoundsType.VISUAL);
        text.setFont(Font.font("Verdana",10));
        text.setTranslateX((CELL_SIZE - CELL_SIZE * 0.3125 *2)/2);
        text.setTranslateY((CELL_SIZE - CELL_SIZE * 0.26 *2)/2 + CELL_SIZE*0.07);
        if(string.endsWith("W")){
            text.setFill(Color.BLACK);
        }else{
            text.setFill(Color.WHITE);
        }
        return text;
    }


}