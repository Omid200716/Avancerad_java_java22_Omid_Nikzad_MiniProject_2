package game;

import players.HumanPlayer;
import players.PlayerInterface;
import players.AIPlayer; 

import java.util.Scanner;

import board.Board;

public class TicTacToeGame   {
    
    private Board board;
    private PlayerInterface player1;
    private PlayerInterface player2;

    public TicTacToeGame() {
        board = new Board();
        player1 = new HumanPlayer('X', new Scanner(System.in));
        player2 = new AIPlayer('O', board); 
    }
    
    public void start() {
    	board.displayGrid();
        while (!board.isGameOver()) {
            playTurn(player1);
            if (board.isGameOver()) {
                break;
            }
            
            playTurn(player2);
        }
        
        if (board.checkWin(player1.getMark())) {
            System.out.println("player wins!");
        } else if (board.checkWin(player2.getMark())) {
            System.out.println("computer wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }

    private void playTurn(PlayerInterface player) {
        int[] move = player.makeMove(board.getGrid());
        board.placeMark(move[0], move[1], player.getMark());
        board.displayGrid();
    }
}
