package com.chess.model;


import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

public  class Piece extends StackPane{

    private PieceType pieceType;

    public Piece(PieceType pieceType, int x, int y){
        Image image = new Image("../images/Chess_b.png");
        this.pieceType = pieceType;
    }

}