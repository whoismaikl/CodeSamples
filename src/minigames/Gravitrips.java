package minigames;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by mihails_nikitins on 02.08.2016.
 */
public class Gravitrips {

    private static final int COLUMNS = 7;
    private static final int ROWS = 6;
    private static final int WIN = 4;
    private static final String DOT = " . ";
    private String[][] board = new String[COLUMNS][ROWS];
    private int moveCounter;
    private String playerInput;
    private Scanner scanner = new Scanner(System.in);
    private boolean isWon;
    private Random random = new Random();


    public static void main(String[] args) {
        Gravitrips newGame = new Gravitrips();
        newGame.run();
    }

    private void run() {

        initialiseBoard();

        do {
            isWon = makeMove();
        } while (!isWon);

        System.out.println("#####################");
        System.out.println("Player" + playerInput + "has won the game");
        System.out.println("#####################");
        reprintBoard();
    }

    private void initialiseBoard() {
        for (int x = 0; x < COLUMNS; x++) {
            for (int y = 0; y < ROWS; y++) {
                board[x][y] = DOT;
            }
        }
    }

    private boolean makeMove() {
        boolean win;
        reprintBoard();
        int move=-1;

        if (moveCounter % 2 == 0){
            move = doMove();
			 playerInput = " X ";
        } else {
            move = botMove();
			playerInput = " O ";
        }
        win = checkForWin(move);


        return win;
    }

    private boolean checkForWin(int move) {

        if (checkColumnsForWin(move) || checkRowsForWin() || checkDiagonals()){
            return true;
        }
        return false;
    }

    private boolean checkDiagonals() {
        boolean win=false;
        int startingCoordinate = WIN-1;

        while (!win && startingCoordinate < ROWS) {
            win = checkRightDiagonal(startingCoordinate);
            startingCoordinate++;
        }

        if (!win){
            startingCoordinate = ROWS - WIN;
            while (!win && startingCoordinate >=0) {

                win = checkRightDiagonalReverse(startingCoordinate);
                startingCoordinate--;
            }
        }

        if (!win){
            startingCoordinate = ROWS - WIN;
            while (!win && startingCoordinate >=0) {

                win = checkLeftDiagonal(startingCoordinate);
                startingCoordinate--;
            }
        }

        if (!win){
            startingCoordinate = ROWS - 1;
            while (!win && startingCoordinate >= WIN-1) {

                win = checkLeftDiagonalReverse(startingCoordinate);
                startingCoordinate--;
            }
        }

        return win;
    }

    private boolean checkLeftDiagonal(int startingCoordinate) {
        int count=0;

        for (int x = 0, y = startingCoordinate; y < ROWS ; x++, y++){
            if (board[x][y] == playerInput){

                count++;
                if (count == WIN){
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkLeftDiagonalReverse(int startingCoordinate) {
        int count=0;

        for (int x = COLUMNS-1, y = ROWS-1; y >=0 ; x--, y--){
            if (board[x][y] == playerInput){
                count++;
                if (count == WIN){
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkRightDiagonal(int startingCoordinate) {
        int count=0;

        for (int x = 0, y = startingCoordinate; y >=0 ; x++, y--){
            if (board[x][y] == playerInput){
                count ++;
                if (count == WIN){
                    return true;
                }
            }else{
                count = 0;
            }
        }
        return false;
    }

    private boolean checkRightDiagonalReverse(int startingCoordinate) {
        int count=0;

        for (int x = COLUMNS-1, y = startingCoordinate; y < ROWS ; x--, y++){
            if (board[x][y] == playerInput){

                count++;
                if (count == WIN){
                    return true;
                }
            } else {
                count = 0;
            }
        }
        return false;
    }

    private boolean checkRowsForWin() {
        int count=0;

        for (int y = ROWS-1; y >=0; y--) {
            for (int x = COLUMNS-1; x >=0; x--) {
                if (board[x][y] == playerInput){
                    count ++;
                    if (count == WIN){
                        return true;
                    }
                }else {
                    count = 0;
                }
            }

        }
        return false;
    }

    private boolean checkColumnsForWin(int move) {
        int count=0;
        int y =0;
        for (y = ROWS-1; y>=0;  y--) {
            if (board[move][y] == playerInput){
                count ++;
                if (count == WIN){
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }

    private int doMove() {
        int move = 0;
        boolean moveCompleted = false;

        do {
            try {
                System.out.println("Do Move. Fast!");
                move = Integer.parseInt(scanner.nextLine());
            }
            catch (Exception e){
                System.out.println(e.getMessage() + "Invalid move! Try again." );
            }

            if (move < COLUMNS){
                for (int y = ROWS-1; y >= 0; y--) {
                    if (board[move][y] == DOT){
                        board[move][y] = playerInput;
                        moveCounter++;
                        moveCompleted = true;
                        break;

                    }
                }
            }
        } while (!moveCompleted);

        return move;
    }

    private void reprintBoard() { // must call after insertMove
        System.out.print(" ");
        for (int x = 0; x < COLUMNS; x++) {
            System.out.print(x + "  ");//  X koords
        }

        System.out.println();
        for (int y = 0; y < ROWS; y++) {
            for (int x = 0; x < COLUMNS; x++) {
                System.out.print(board[x][y]);
            }
            System.out.println(y); // Y koords
        }
    }

    private int botMove() {
        int move =-1;
        boolean moveCompleted = false;
        do {
            move = random.nextInt(COLUMNS);

            for (int y = ROWS - 1; y >= 0; y--) {
                if (board[move][y] == DOT) {
                    board[move][y] = playerInput;
                    moveCounter++;
                    moveCompleted = true;
                    break;

                }
            }
        } while(!moveCompleted);
        return move;
    }

}

