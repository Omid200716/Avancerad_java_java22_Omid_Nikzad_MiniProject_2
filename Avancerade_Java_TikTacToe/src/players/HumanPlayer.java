package players;

import java.util.Scanner;

public class HumanPlayer implements PlayerInterface{
	private char mark;
	private Scanner scanner;
	
	
	public HumanPlayer(char mark, Scanner scanner) {
		this.mark = mark;
		this.scanner = scanner;
		
	}
	

	@Override
	public char getMark() {
		return mark;
	}
	 
	
	@Override
	public int[] makeMove(char[][] grid) {
		int choice;
		while(true) {
			System.out.println("Enter your move (1-9:)");
			choice = scanner.nextInt();
			int[] position = {
					(choice -1)/3,
					(choice -1) %3
			};
			
			if(grid[position[0]][position[1]] == ' ') {
				return position;
			}else {
				System.out.println("Invalid move, try again! ");
			}
		}
	}
	
	

}
