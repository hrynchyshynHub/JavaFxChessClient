package com.chess.model;


import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import static com.chess.model.ChessBoard.CELL_SIZE;

public class Cell extends Rectangle{
    private Piece piece;

    public Cell(boolean light, int x, int y ){
        setWidth(x * CELL_SIZE);
        setHeight(y * CELL_SIZE);
        relocate(x * CELL_SIZE, y * CELL_SIZE);
        setFill(light ? Color.valueOf("#feb") : Color.valueOf("582"));

    }
    public boolean hasPiece(){
        return piece != null;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

}