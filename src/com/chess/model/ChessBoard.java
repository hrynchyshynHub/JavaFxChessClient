package com.chess.model;


import com.chess.config.ApplicationProperties;
import javafx.scene.Parent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.StrokeType;


public class ChessBoard{

    public static final int BOARD_SIZE = 8;
    public static final int CELL_SIZE = 60;

    private Cell [][]board = new Cell[BOARD_SIZE][BOARD_SIZE];

    private Cell selectedCell = null;

    public Parent createContent(){
        GridPane root = new GridPane();
        root.setPrefSize(ApplicationProperties.getWidth(), ApplicationProperties.getHeight());

        boolean isWhite = true;
        Color color = Color.WHITE;
        for (int i = 7; i >= 0; i--) {
            for (int j = 0; j < 8; j++) {
                isWhite = !isWhite;
                if( j == 7){
                    isWhite = !isWhite;
                }
                color = (isWhite) ?  Color.BLACK :  Color.WHITE;
                board[i][j] = new Cell(color, i, (char) (j + 97), this);

                GridPane.setRowIndex(board[i][j], j);
                GridPane.setColumnIndex(board[i][j], i);
                root.getChildren().add(board[i][j]);

                System.out.print('[' + board[i][j].getCellId() + ']');
            }
            System.out.println();
        }
        return root;
    }

    private Piece createPiece(PieceType type, int x, int y){
        Piece piece = new Piece(type, x, y);
        return piece;
    }

    private Cell getCellById(String id){
        Cell foundCell = null;
        for(int i = 0; i < 8; i++){
            for(int j =0 ; j < 8; j++){
                if(board[i][j].getId().equalsIgnoreCase(id)) foundCell = board[i][j];
            }
        }
        return foundCell;
    }

    public Cell getSelectedCell() {
        return selectedCell;
    }

    public void setSelectedCell(Cell selectedCell) {
        if(this.selectedCell != null){
            this.selectedCell.setStrokeType(StrokeType.INSIDE);
            this.selectedCell.setStrokeWidth(0);
        }
        this.selectedCell = selectedCell;
        this.selectedCell.setStrokeType(StrokeType.INSIDE);
        this.selectedCell.setStroke(Color.RED);
        this.selectedCell.setStrokeWidth(3);
        System.out.println(selectedCell.getCellId());
    }
}