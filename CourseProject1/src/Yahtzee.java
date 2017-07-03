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
		display.printMessage(playerNames[player - 1] + "'s turn! Click the \"Roll Dice\" button to roll the dice.");
		display.waitForPlayerToClickRoll(player);
		
		for (int i=0; i < N_DICE; i++)
		{
			diceRoll[i] = rgen.nextInt(1, 6);
		}
		
		display.displayDice(diceRoll);
	}
	
	private void secondAndThirdRoll() 
	{
		for (int i = 0; i < 2; i++)
		{
			display.printMessage("Select the dice you wish to re-roll, and click \"Roll Again\".");
			display.waitForPlayerToSelectDice();
			
			for (int j=0; j < N_DICE; j++)
			{
				if (display.isDieSelected(j))
				{
					diceRoll[j] = rgen.nextInt(1, 6);
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
			if (diceRoll[i] == 1) {
				one.add(1);
			} 
			else if (diceRoll[i] == 2) {
				two.add(1);
			}
			else if (diceRoll[i] == 3) {
				three.add(1);
			}
			else if (diceRoll[i] == 4) {
				four.add(1);
			}
			else if (diceRoll[i] == 5) {
				five.add(1);
			}
			else if (diceRoll[i] == 6) {
				six.add(1);
			}
		}
		
		
		if (category == THREE_OF_A_KIND)
		{
			if (one.size() >= 3 || two.size() >= 3 || three.size() >= 3 || four.size() >= 3 || five.size() >= 3 || six.size() >= 3)
				return true;
		} 
		else if (category == FOUR_OF_A_KIND)
		{
			if (one.size() >= 4 || two.size() >= 4 || three.size() >= 4 || four.size() >= 4 || five.size() >= 4 || six.size() >= 4)
				return true;
		}
		else if (category == YAHTZEE)
		{
			if (one.size() == 5 || two.size() == 5 || three.size() == 5 || four.size() == 5 || five.size() == 5 || six.size() == 5)
				return true;
		}
		else if (category == FULL_HOUSE)
		{
			if (one.size() == 3 || two.size() == 3 || three.size() == 3 || four.size() == 3 || five.size() == 3 || six.size() == 3)
			{
				if (one.size() == 2 || two.size() == 2 || three.size() == 2 || four.size() == 2 || five.size() == 2 || six.size() == 2)
					return true;
			}
		}
		else if (category == SMALL_STRAIGHT)
		{
			if (one.size() == 1 && two.size() == 1 && three.size() == 1 && four.size() == 1)
				return true;
			else if (two.size() == 1 && three.size() == 1 && four.size() == 1 && five.size() == 1)
				return true;
			else if (three.size() == 1 && four.size() == 1 && five.size() == 1 && six.size() == 1)
				return true;
		}
		else if (category == LARGE_STRAIGHT)
		{
			if (one.size() == 1 && two.size() == 1 && three.size() == 1 && four.size() == 1 && five.size() == 1)
				return true;
			else if (two.size() == 1 && three.size() == 1 && four.size() == 1 && five.size() == 1 && six.size() == 1)
				return true;
		}
		else if (category == CHANCE)
		{
			return true;
		}
		
		return false;
	}
	
	private void totalResults()
	{
		int result = 0;
		
		for (int player = 0; player < nPlayers; player++)
		{
			// Upper Score Total
			
			for (int category = 0; category < SIXES; category++)
			{
				result += scorecard[category][player];
			}
			
			scorecard[UPPER_SCORE - 1][player] = result;
			display.updateScorecard(UPPER_SCORE, player + 1, result);
			
			// Upper Bonus
			
			if (scorecard[UPPER_SCORE - 1][player] > 63)
			{
				scorecard[UPPER_BONUS - 1][player] = 35;
				display.updateScorecard(UPPER_BONUS, player + 1, 35);
			} 
			else
			{
				scorecard[UPPER_BONUS - 1][player] = 0;
				display.updateScorecard(UPPER_BONUS, player + 1, 0);
			}
			
			// Lower Score Total
			
			result = 0;
			
			for (int category = 8; category < CHANCE; category++)
			{
				result += scorecard[category][player];
			}
			
			scorecard[LOWER_SCORE - 1][player] = result;
			display.updateScorecard(LOWER_SCORE, player + 1, result);
			
			
			// Final Total
			scorecard[TOTAL - 1][player] = scorecard[UPPER_SCORE - 1][player] 
					                     + scorecard[UPPER_BONUS - 1][player] 
										 + scorecard[LOWER_SCORE - 1][player];
			display.updateScorecard(TOTAL, player + 1, result);
			
			result = 0;
		}
	}
	
	private void calulateWinner()
	{
		int winner = 0;
		int score = 0;
		
		for (int player = 0; player < nPlayers; player++)
		{
			if (scorecard[TOTAL - 1][player] > score)
			{
				score = scorecard[TOTAL - 1][player];
				winner = player;
			}
		}
		
		display.printMessage("Congratualtions, " + playerNames[winner] + ", you're the winner with a total score of " + score + "!");
	}

}
