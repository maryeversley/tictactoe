import java.util.Scanner;

public class TicTacToe 
{
	public static void main(String[]args)
	{
		Scanner scan = new Scanner(System.in);
		char player1 = 'x';
		char player2 = 'o';
		int rows = 0;
		int cols = 0;
		char[][] TTT = new char[3][3];
		
		int playercount = 0;
		
		//Show board
		System.out.println("This is your board: ");
		PrintChart(TTT);
		
		System.out.println();
		System.out.println();
		
		//Tell players what they are. 
		System.out.println("Player1 will be " + player1);
		System.out.println("Player2 will be " + player2);
		
		//Ask for coordinates
		for (int count = 1; count <= 9; count ++)
		{	
			Reference();
			//Player 1 turn
			boolean player1checker = true;
			while(player1checker = true)
			{
				System.out.println("Player1 will go.");
				System.out.println("Row: ");
				rows = scan.nextInt();
				System.out.println("Column: ");
				cols = scan.nextInt();
				if (TTT[rows][cols]== 0)
				{
					player1checker = false;
					TTT[rows][cols] = player1;
					PrintChart(TTT);
					break;
				}
				else 
				{
					player1checker = true;
					System.out.println("Please retype, space is filled");
				}
			}
			
			Checker(TTT);
			if(Checker(TTT) == true)
			{
				System.out.println("Nice! You've won!! Player1 FANTASTIC JOB!");
				playercount = 1;
				break;
			}
			System.out.println();
			if(count == 9)
				break;
			
			Reference();
			
			//Player 2 turn
			boolean player2checker = true;
			while(player2checker = true)
			{
				System.out.println("Player2 will go.");
				System.out.println("Row: ");
				rows = scan.nextInt();
				System.out.println("Column: ");
				cols = scan.nextInt();
				if (TTT[rows][cols]== 0)
				{
					player2checker = false;
					TTT[rows][cols] = player2;
					PrintChart(TTT);
					break;
				}
				else 
				{
					player2checker = true;
					System.out.println("Please retype, space is filled");
				}
			}
			
			Checker(TTT);
			if(Checker(TTT) == true)
			{
				System.out.println("Nice! You've won!! PLAYER2- Fantastic Job!");
				playercount = 2;
				break;
			}
			System.out.println();
			
			count++;
		}
		
		Checker(TTT);
		if (Checker(TTT) == false)
		{
			System.out.println("Tie. Great. It didn't have to end in a tie. But you guys made this a tie.");
			System.out.println("\t  ______ ");
			System.out.println("\t /(    )\\");
			System.out.println("\t \\ \\  / / ");
			System.out.println("\t  \\/[]\\/ ");
			System.out.println("\t    /\\ ");
			System.out.println("\t   |  | ");
			System.out.println("\t   |  | ");
			System.out.println("\t   |  | ");
			System.out.println("\t   |  | ");
			System.out.println("\t   |  | ");
			System.out.println("\t   \\  / ");
			System.out.println("\t    \\/ ");
		}
		if (Checker(TTT) == true)
		{
			if(playercount == 1)
				System.out.println("Good player1. Now, this: ");
			if(playercount == 2)
				System.out.println("Good player2. Now, this: ");
			System.out.println("   .-=========-.");
			System.out.println("   \\'-=======-'/");
			System.out.println("   _|   .=.   |_");
			System.out.println("  ((|  {{1}}  |))");
			System.out.println("   \\|   /|\\   |/");
			System.out.println("    \\__     __/");
			System.out.println("      _`) (`_");
			System.out.println("    _/_______\\_");
			System.out.println("   /___________\\");
			
		}
	}
	
	public static void PrintChart(char[][] array)
	{
		System.out.println("\t      |     |     ");
		System.out.println("\t   " + array[0][0] + "  |  "+ array[0][1] + "  |  " + array[0][2]);
		System.out.println("\t ¯¯¯¯¯|¯¯¯¯¯|¯¯¯¯¯");
		System.out.println("\t   " + array[1][0] + "  |  "+ array[1][1] + "  |  " + array[1][2]);
		System.out.println("\t ¯¯¯¯¯|¯¯¯¯¯|¯¯¯¯¯");
		System.out.println("\t   " + array[2][0] + "  |  "+ array[2][1] + "  |  " + array[2][2]);
	}
	
	public static void Reference()
	{
		System.out.println("Type your coordinates. Refer for chart~ ");
		System.out.println("\t      |     |     ");
		System.out.println("\t  0,0 | 0,1 | 0,2 ");
		System.out.println("\t ¯¯¯¯¯|¯¯¯¯¯|¯¯¯¯¯");
		System.out.println("\t  1,0 | 1,1 | 1,2 ");
		System.out.println("\t ¯¯¯¯¯|¯¯¯¯¯|¯¯¯¯¯");
		System.out.println("\t  2,0 | 2,1 | 2,2 ");
	}
	
	public static boolean Checker(char[][] array)
	{
		boolean checker = false;
		
		//Check rows
		for(int i = 0; i < 3; i++)
		{
			if(((array[i][0] == 'x') || (array[i][0] == 'o')) && (array[i][0] == array[i][1]) && (array[i][1] == array[i][2]))
			{
				checker = true;
				break;
			}
		}
		
		//Check columns
		for(int i = 0; i < 3; i++)
		{
			if(((array[0][i] == 'x') || (array[0][i] == 'o')) && (array[0][i] == array[1][i]) && (array[1][i] == array[2][i]))
			{
				checker = true;
				break;
			}
		}
		
		//Check 0,0 diagonal
		if(((array[0][0] == 'x') || (array[0][0] == 'o')) && (array[0][0] == array[1][1]) && (array[1][1] == array[2][2]))
			checker = true;
		
		//Check 0,2 diagonal
		if(((array[0][2] == 'x') || (array[0][2] == 'o')) && (array[0][2] == array[1][1]) && (array[1][1] == array[2][0]))
			checker = true;
		
		return checker;
	}
}
