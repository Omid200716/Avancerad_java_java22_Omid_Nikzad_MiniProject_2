package players;
import algorithm.MinMax;
import board.Board;
import algorithm.MinMax;

public class AIPlayer implements PlayerInterface{ 
	
 private char mark;
 private Board board;


 

 
 public AIPlayer(char mark, Board board) {
	 this.mark = mark;
	 this.board = board;
 }
 
 @Override
 public char getMark() {
	 return mark;
 }
 
 @Override
 public int[] makeMove(char[][] grid) {
	 int[] move = MinMax.bestMove(board, mark);
	// System.out.println("AI's move: " + move[0] + ", " + move[1]);
	 return move;
 }
 
}
