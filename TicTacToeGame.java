// (Game: play a tic-tac-toe game)

import java.util.Scanner;

public class TicTacToeGame {

    public static char[][] board = new char [3][3];
    public static Scanner input = new Scanner(System.in);
    public static char playerTurn = 'x';
    public static boolean winner = true;
    public static byte player_X, player_O = 0;
    public static boolean draw = false;
    public static byte counter = 0;


    public static void main(String[] args) {

        printBoard();

        while(winnerCheck()) {
            playerTurn(playerTurn);
        }
        
        if(player_X == 1) {
            System.out.println("Player X wins!");
        } else if (counter == 9) {
            System.out.println("It's a draw!");
        } else {
            System.out.println("Player O wins!");
        }
    }

    public static void printBoard() {
        System.out.println(" ---------- ");
        System.out.println(" | "+ board[0][0] +" | "+ board[0][1] +" | "+ board[0][2] +" |");
        System.out.println(" ---------- ");
        System.out.println(" | "+ board[1][0] +" | "+ board[1][1] +" | "+ board[1][2] +" |");
        System.out.println(" ---------- ");
        System.out.println(" | "+ board[2][0] +" | "+ board[2][1] +" | "+ board[2][2] +" |");
        System.out.println(" ---------- ");
    }

    public static void playerTurn(char player) {
        byte row, col = 0;

        while(true) {
            System.out.print("Enter a row (0, 1, or 2) for player " + player + " : ");
            row = input.nextByte();

            if(row >= 0 && row <= 2) {
                break;
            } else {
                System.out.println("Invalid pick! Try again...");
            }
            if(Character.valueOf(board[row][col]) == (char)0) {
                board[row][col] = player;
                break;
            } else {
                System.out.println("\nThe selected cell is already occupied! Try again.\n");
                printBoard();
            }
        }

        printBoard();
    
            if (player == 'X') {
                playerTurn = 'O';
            } else {
                playerTurn = 'X';
            }

    }

    public static boolean winnerCheck() {

        for (int i = 0; i < 8; i++) {
			String line = null;
			switch (i) {
			case 0:
				line = Character.toString(board[0][0]) + Character.toString(board[0][1]) + Character.toString(board[0][2]); //first row
				break;
			case 1:
				line = Character.toString(board[1][0]) + Character.toString(board[1][1]) + Character.toString(board[1][2]); //second row
				break;
			case 2:
                line = Character.toString(board[2][0]) + Character.toString(board[2][1]) + Character.toString(board[2][2]); //third row
				break;
			case 3:
                line = Character.toString(board[0][0]) + Character.toString(board[1][1]) + Character.toString(board[2][2]); //diagonal from top-left
				break;
			case 4:
                line = Character.toString(board[0][0]) + Character.toString(board[1][0]) + Character.toString(board[2][0]); //first column
				break;
			case 5:
                line = Character.toString(board[0][1]) + Character.toString(board[1][1]) + Character.toString(board[2][1]); //second column
				break;
			case 6:
                line = Character.toString(board[0][2]) + Character.toString(board[1][2]) + Character.toString(board[2][2]); //third column
				break;
			case 7:
                line = Character.toString(board[0][2]) + Character.toString(board[1][1]) + Character.toString(board[2][0]); //diagonal from top-right
				break;
            }
        
			if (line.equals("XXX")) {
				player_X = 1;
			} else if (line.equals("OOO")) {
				player_O = 1;
            }


        }

        counter = 0;

        for(char[] array_1D: board) {
            for(char i: array_1D) {
                if(i != (char)0) {
                    counter++;
                }
            }
        }

        if(counter == 9) {
            return false;
        } else if(player_O <= 0 && player_X <= 0) {
            return true;
        } else {
            return false;
        }
    }




}