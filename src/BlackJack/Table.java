// Imports
package BlackJack;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

// Table Class
public class Table {
	
	// Global Variables
	static int position;
	static int balance;
	static int bet;
	static boolean playerBust;
	static boolean dealerBust;
	
	// Driver Method
	public static void main(String[] args) {
		
		// Runs game
		run();
	}
	
	static void run() {
		
		// Instance Variables
		Map<Integer, Card> deck = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		Card cards = new Card();
		int round;
		int[] order = new int[52];
		
		// Initializing Instance Variables
		round = 1;
		balance = 1000;
		
		for(int i = 0; i < 52; i++)
			order[i] = i;
		
		// Creating Deck of Cards
		deck = cards.getDeck();
		
		// Loop for Rounds
		while(true) {
			
			// Instance Variables
			Player player = new Player();
			Player dealer = new Player();
			
			// Setting Variables
			bet = 0;
			position = 0;
			
			// Shuffling Order of Deck
			shuffle(order);
			
			// Starting Round
			for(int i = 0; i < 50; i++)
				System.out.println();
			
			System.out.println("--------Starting Round " + round + " --------\n");
			System.out.println("Current Balance : $" + balance);
			
			// Inputting Bet Amount
			while(bet <= 0) {
				System.out.print("Enter your Bet : ");
				
				bet = scan.nextInt();
			}
			
			// Dealing Cards to Players
			deal(player, dealer, deck, order);
			
			// Starting Players Turn
			playerTurn(player, dealer, deck, order);
			pause(1000);
			
			if(!playerBust) {
				dealerTurn(player, dealer, deck, order);
				pause(2000);
			}
			
			// Print Results
			result(player, dealer);
			pause(5000);
			
			// Ending Round and Incrementing Round Number
			System.out.println("-------- End of Round " + round + " --------\n\n\n\n\n");
			round++;
		}
	}
	
	static void result(Player player, Player dealer) {
		
		if(playerBust) {
			balance -= bet;
			
			System.out.println("You bust, dealer wins.");
			System.out.println("- $" + bet);
			
			return;
		}
		
		else if(dealerBust) {
			balance += bet;
			
			System.out.println("Dealer bust, you win!");
			System.out.println("+ $" + bet);
			
			return;
		}
		
		System.out.println("Dealer Total : " + dealer.getTotal());
		System.out.println("Your Total : " + player.getTotal() + "\n");
		
		if(player.getTotal() > dealer.getTotal()) {
			balance += bet;
			
			System.out.println("You win!");
			System.out.println("+ $" + bet);
			
		}
		
		else if (player.getTotal() < dealer.getTotal()) {
			balance -= bet;
			
			System.out.println("Dealer wins.");
			System.out.println("- $" + bet);
		}
		
		else {
			System.out.println("You and the dealer pushed.");
			System.out.println("+ $0");
		}
	}
	
	static void pause(int ms) {
		
		// Pause for 1 second before Dealers Turn
		try
		{
			Thread.sleep(ms);
		}
					
			catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}
	
	// Method to Print Players Hand
	static void printPlayerHand(Player player) {
		
		// Instance Variables
		ArrayList<Card> cards = new ArrayList<Card>();
		int numberOfAces;
		
		// Getting Players Current Hand of Cards
		cards = player.getCards();
		numberOfAces = 0;
		
		// Printing Hand Information
		System.out.println("\nYour Cards : ");
		
		for(int i = 0; i < player.numberOfCards; i++) {
			if(i < 2)
				System.out.println("   [" + cards.get(i).card + "]");
			else
				System.out.println("   + [" + cards.get(i).card + "]");
		}
		
		if((numberOfAces = checkForAce(player)) > 0 && ((player.getTotal() + (10 * numberOfAces)) < 22))
			System.out.println("\nTotal Hand : " + player.getTotal() + " or " + (player.getTotal() + (10 * numberOfAces)) + "\n\n");
		
		else
			System.out.println("\nTotal Hand : " + player.getTotal() + "\n\n");
	}
	
	// Method to Print Dealers Hand
	static void printDealerHand(Player dealer, int hide) {
		
		// Instance Variables
		ArrayList<Card> cards = new ArrayList<Card>();
		
		// Getting Dealers Current Hand of Cards
		cards = dealer.getCards();
		
		// Printing Hand Information
		System.out.println("\nDealer Card(s) : ");
		
		for(int i = 0; i < dealer.numberOfCards; i++) {
			
			// If it is the players turn, hide second card
			if(hide == 1)
				if(i > 0)
					System.out.println("   [X]");
				
				else
					System.out.println("   [" + cards.get(i).card + "]");
			
			// Print all cards
			else
				if(i < 2)
					System.out.println("   [" + cards.get(i).card + "]");
			
				else
					System.out.println("   + [" + cards.get(i).card + "]");
		}
		
		// If it is players turn, only print value of dealers first card
		if(hide == 1)
			System.out.println("\nDealer Showing : " + (dealer.getTotal() - cards.get(1).value));
		
		// Print dealers total
		else
			System.out.println("\nDealer Showing : " + dealer.getTotal());
	}
	
	// Method to Start Players Turn
		static void dealerTurn(Player player, Player dealer, Map<Integer, Card> deck, int[] order) {
			
			// Loop for Players Input
			while(true) {
				dealerBust = false;
				
				// Pause for 1.5 seconds between choices
				pause(1500);
				
				// Print the Table
				for(int i = 0; i < 50; i++)
					System.out.println();
				
				printDealerHand(dealer, 0);
				System.out.println("\n\n");
				printPlayerHand(player);
				
				// If dealer has more than 21, break
				if(dealer.getTotal() > 21) {
					dealerBust = true;
					
					break;
				}
				
				// If dealer has 21, break
				else if(player.getTotal() == 21) {
					break;
				}
				
				// If dealer has less than 17, hit
				if(dealer.getTotal() < 17) {
					dealer.addCard(deck.get(order[position]));
					position++;
				}
				
				// If dealer has more than 16 and less than 22, stand
				else if(dealer.getTotal() > 16 && dealer.getTotal() < 22)
					break;
			}
		}
	
	// Method to Start Players Turn
	static void playerTurn(Player player, Player dealer, Map<Integer, Card> deck, int[] order) {
		
		// Instance Variables
		Scanner scan = new Scanner(System.in);
		int choice;
		int numberOfAces;
		
		// Loop for Players Input
		while(true) {
			playerBust = false;
			
			// Pause for .5 seconds between choices
			pause(1000);
			
			// Print the Table
			for(int i = 0; i < 50; i++)
				System.out.println();
			
			printDealerHand(dealer, 1);
			System.out.println("\n\n");
			printPlayerHand(player);
			
			// If Player has more than 21, break
			if(player.getTotal() > 21) {
				playerBust = true;
				
				break;
			}
			
			// If Player has 21, break
			else if(player.getTotal() == 21 || (player.getTotal() + (10 * checkForAce(player))) == 21) {
				break;
			}
			
			// If player has only 2 cards, print normal options with double down
			if(player.numberOfCards == 2)
				System.out.println("1. Hit        2. Stand        3. Double Down");
			
			// If player has more than 2 cards, print normal options
			else
				System.out.println("1. Hit        2. Stand");
			
			// Get user input
			choice = scan.nextInt();
			
			// Hit, add card to players hand and continue
			if(choice == 1) {
				player.addCard(deck.get(order[position]));
				position++;
			}
			
			// Stand, break
			else if(choice == 2) {
				if((numberOfAces = checkForAce(player)) > 0 && ((player.getTotal() + (10 * numberOfAces)) < 22))
					player.totalHand += 10 * numberOfAces;
				
				break;
			}
				
			// Double down, double players bet, add card to players deck, and break
			else if(choice == 3 && player.numberOfCards == 2) {
				bet *= 2;
				player.addCard(deck.get(order[position]));
				position++;
				
				if((numberOfAces = checkForAce(player)) > 0 && ((player.getTotal() + (10 * numberOfAces)) < 22))
					player.totalHand += 10 * numberOfAces;
				
				// Print the Table
				
				for(int i = 0; i < 50; i++)
					System.out.println();
				
				printDealerHand(dealer, 1);
				System.out.println("\n\n");
				printPlayerHand(player);
				
				break;
			}
			
			// Invalid choice
			else
				System.out.println("Invalid choice. Please try again.\n");
		}
	}
	
	// Method to deal initial cards to player and dealer
	static void deal(Player player, Player dealer, Map<Integer, Card> deck, int[] order) {
		
		// While the dealer has less than 2 cards, deal cards to players
		while(dealer.numberOfCards < 2) {
			player.addCard(deck.get(order[position]));
			position++;
			
			dealer.addCard(deck.get(order[position]));
			position++;
		}
	}
	
	// Method to shuffle the order array
	static void shuffle(int[] order) {
		
		// Instance Variables
		Random random = ThreadLocalRandom.current();
		
		// Randomize array order
		for(int i = order.length - 1; i > 0; i--) {
			int index = random.nextInt(i + 1);
			
			int a = order[index];
			order[index] = order[i];
			order[i] = a;
		}
	}
	
	static int checkForAce(Player player) {
		ArrayList<Card> cards = new ArrayList<Card>();
		int count;
		
		count = 0;
		cards = player.getCards();
		
		for(int i = 0; i < cards.size(); i++) {
			if(cards.get(i).card.contains("Ace")) {
				count++;
			}
		}
		
		return count;
	}
}
