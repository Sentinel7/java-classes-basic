import acm.io.*;
import acm.program.*;
import acm.util.*;
import java.util.*;

public class Yahtzee extends GraphicsProgram implements YahtzeeConstants {
	
	private int nPlayers;
	private String[] playerNames;
	
	private int[] diceRoll = new int[N_DICE];
	private int[][] scorecard;
	
	private YahtzeeDisplay display;
	private RandomGenerator rgen = new RandomGenerator();
	
	
	public static void main(String[] args) 
	{
		new Yahtzee().start(args);
	}
	
	public void run() 
	{
		IODialog dialog = getDialog();
		nPlayers = dialog.readInt("Enter number of players");
		playerNames = new String[nPlayers];
		
		for (int i = 1; i <= nPlayers; i++) 
		{
			playerNames[i - 1] = dialog.readLine("Enter name for player " + i);
		}
		
		display = new YahtzeeDisplay(getGCanvas(), playerNames);
		playGame();
	}

	
	private void playGame() 
	{
		scorecard = new int[N_CATEGORIES][nPlayers];
		
		for (int turns=0; turns < N_SCORING_CATEGORIES; turns++)
		{
			for (int player = 1; player <= nPlayers; player++)
			{
				startFirstRoll(player);
				secondAndThirdRoll();
				
				selectCategory(player);
			}
		}
		//totalUpResults();
		//calculateWinner();
	}
	

	private void startFirstRoll(int player) 
	{
		display.printMessage(playerNames[player - 1] + "'s turn! Click the \"Roll Dice\" buttun to roll the dice.");
		display.waitForPlayerToClickRoll(player);
		
		for (int i=0; i < N_DICE; i++)
		{
			diceRoll[i] = rgen.nextInt(1, 6);
		}
		
		display.displayDice(diceRoll);
	}
	
	private void secondAndThirdRoll() 
	{
		for (int turn = 0; turn < 2; turn++)
		{
			display.printMessage("Select the dice you wish to re-roll, and click \"Roll Again\".");
			display.waitForPlayerToSelectDice();
			
			for (int i=0; i < N_DICE; i++)
			{
				if (display.isDieSelected(i))
				{
					diceRoll[i] = rgen.nextInt(1, 6);
				}
			}
			display.displayDice(diceRoll);
		}
	}
	
	private void selectCategory(int player) 
	{
		display.printMessage("Select a category for this roll.");
		
		while (true)
		{
			int category = display.waitForPlayerToSelectCategory();
			
			if (checkCategory(player, category) == true)
			{
				calculateCategoryScore(player, category);
				
				break;
			}
		}
	}

	private boolean checkCategory(int player, int category) 
	{
		if (scorecard[category - 1][player - 1] == 0 && category != UPPER_SCORE && category != UPPER_BONUS && category != LOWER_SCORE && category != TOTAL)
		{	
			return true;
		}
		
		return false;
	}
	
	private void calculateCategoryScore(int player, int category) 
	{
		int score = 0;
		
		if (category >= ONES && category <= SIXES)
		{
			for (int i=0; i < N_DICE; i++)
			{
				if (diceRoll[i] == category)
					score += category;
			}
		} 
		else if (category == THREE_OF_A_KIND || category == FOUR_OF_A_KIND)
		{
			if (checkSpecialCategory(category) == true)
			{
				for (int i=0; i < N_DICE; i++)
				{
					score += diceRoll[i];
				}
			}
			else 
			{
				score = 0;
			}
		} 
		else if (category == FULL_HOUSE)
		{
			if (checkSpecialCategory(category) == true)
			{
				score = 25;
			}
			else 
			{
				score = 0;
			}
		}
		else if (category == SMALL_STRAIGHT)
		{
			if (checkSpecialCategory(category) == true)
			{
				score = 30;
			}
			else
			{
				score = 0;
			}
		}
		else if (category == LARGE_STRAIGHT)
		{
			if (checkSpecialCategory(category) == true)
			{
				score = 40;
			}
			else
			{
				score = 0;
			}
		}
		else if (category == YAHTZEE)
		{
			if (checkSpecialCategory(category) == true)
			{
				score = 50;
			}
			else
			{
				score = 0;
			}
		}
		else if (category == CHANCE)
		{
			for (int i=0; i < N_DICE; i++)
			{
				score += diceRoll[i];
			}
		}
		
		display.updateScorecard(category, player, score);
		scorecard[category - 1][player - 1] = score;
	}

	private boolean checkSpecialCategory(int category) 
	{
		ArrayList<Integer> one = new ArrayList<Integer>();
		ArrayList<Integer> two = new ArrayList<Integer>();
		ArrayList<Integer> three = new ArrayList<Integer>();
		ArrayList<Integer> four = new ArrayList<Integer>();
		ArrayList<Integer> five = new ArrayList<Integer>();
		ArrayList<Integer> six = new ArrayList<Integer>();
		
		for (int i=0; i < N_DICE; i++)
		{
			if (diceRoll[i] == 1)
			{
				one.add(1);
			} 
			else if (diceRoll[i] == 2)
			{
				two.add(1);
			}
			else if (diceRoll[i] == 3)
			{
				three.add(1);
			}
			else if (diceRoll[i] == 4)
			{
				four.add(1);
			}
			else if (diceRoll[i] == 5)
			{
				five.add(1);
			}
			else if (diceRoll[i] == 6)
			{
				six.add(1);
			}
		}
	}

}
