package com.chess.model;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;

import static com.chess.model.ChessBoard.CELL_SIZE;

public  class Piece extends StackPane{

    private PieceType pieceType;
    private ImagePattern imagePattern;
    private Ellipse ellipse;
    private Text text;

    public Piece(PieceType pieceType, int x, int y){
//        Image image = new Image(getClass().getResourceAsStream("Chess_b.png"));
        this.pieceType = pieceType;
        getChildren().add(createPiece(pieceType , x, y));

    }

    public ImagePattern getImagePattern() {
        return imagePattern;
    }

    public void setImagePattern(ImagePattern imagePattern) {
        this.imagePattern = imagePattern;
    }

    public Pane createPiece(PieceType pieceType, int x, int y){
//        imagePattern = new ImagePattern(new Image(getClass().getResourceAsStream(pieceType.getPathToImage())));
        ellipse = new Ellipse(CELL_SIZE * 0.3126, CELL_SIZE * 0.26);
        ellipse.setTranslateX((CELL_SIZE - CELL_SIZE * 0.3125 *2)/2);
        ellipse.setTranslateY((CELL_SIZE - CELL_SIZE * 0.26 *2)/2 + CELL_SIZE*0.07);
        relocate(x * CELL_SIZE, (y-97) * CELL_SIZE);
        if(pieceType.toString().endsWith("B")) ellipse.setFill(Color.BLACK);
        else                                   ellipse.setFill(Color.WHITE);

        text = createText(pieceType.toString());
        StackPane layout = new StackPane();
        layout.getChildren().addAll(ellipse, text);
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