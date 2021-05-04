package BlackJack;

import java.util.HashMap;
import java.util.Map;

public class Card {
	String card;
	int value;
	
	public Card() {
		super();
	}
	
	public Card(String card, int value) {
		this.card = card;
		this.value = value;
	}
	
	public Map<Integer, Card> getDeck() {
		Map<Integer, Card> deck = new HashMap<>();
		
		Card AceOfHearts = new Card("Ace of Hearts", 1);
		Card TwoOfHearts = new Card("2 of Hearts", 2);
		Card ThreeOfHearts = new Card("3 of Hearts", 3);
		Card FourOfHearts = new Card("4 of Hearts", 4);
		Card FiveOfHearts = new Card("5 of Hearts", 5);
		Card SixOfHearts = new Card("6 of Hearts", 6);
		Card SevenOfHearts = new Card("7 of Hearts", 7);
		Card EightOfHearts = new Card("8 of Hearts", 8);
		Card NineOfHearts = new Card("9 of Hearts", 9);
		Card TenOfHearts = new Card("10 of Hearts", 10);
		Card JackOfHearts = new Card("Jack of Hearts", 10);
		Card QueenOfHearts = new Card("Queen of Hearts", 10);
		Card KingOfHearts = new Card("King of Hearts", 10);
		
		Card AceOfDiamonds = new Card("Ace of Diamonds", 1);
		Card TwoOfDiamonds = new Card("2 of Diamonds", 2);
		Card ThreeOfDiamonds = new Card("3 of Diamonds", 3);
		Card FourOfDiamonds = new Card("4 of Diamonds", 4);
		Card FiveOfDiamonds = new Card("5 of Diamonds", 5);
		Card SixOfDiamonds = new Card("6 of Diamonds", 6);
		Card SevenOfDiamonds = new Card("7 of Diamonds", 7);
		Card EightOfDiamonds = new Card("8 of Diamonds", 8);
		Card NineOfDiamonds = new Card("9 of Diamonds", 9);
		Card TenOfDiamonds = new Card("10 of Diamonds", 10);
		Card JackOfDiamonds = new Card("Jack of Diamonds", 10);
		Card QueenOfDiamonds = new Card("Queen of Diamonds", 10);
		Card KingOfDiamonds = new Card("King of Diamonds", 10);

		Card AceOfClubs = new Card("Ace of Clubs", 1);
		Card TwoOfClubs = new Card("2 of Clubs", 2);
		Card ThreeOfClubs = new Card("3 of Clubs", 3);
		Card FourOfClubs = new Card("4 of Clubs", 4);
		Card FiveOfClubs = new Card("5 of Clubs", 5);
		Card SixOfClubs = new Card("6 of Clubs", 6);
		Card SevenOfClubs = new Card("7 of Clubs", 7);
		Card EightOfClubs = new Card("8 of Clubs", 8);
		Card NineOfClubs = new Card("9 of Clubs", 9);
		Card TenOfClubs = new Card("10 of Clubs", 10);
		Card JackOfClubs = new Card("Jack of Clubs", 10);
		Card QueenOfClubs = new Card("Queen of Clubs", 10);
		Card KingOfClubs = new Card("King of Clubs", 10);
		
		Card AceOfSpades = new Card("Ace of Spades", 1);
		Card TwoOfSpades = new Card("2 of Spades", 2);
		Card ThreeOfSpades = new Card("3 of Spades", 3);
		Card FourOfSpades = new Card("4 of Spades", 4);
		Card FiveOfSpades = new Card("5 of Spades", 5);
		Card SixOfSpades = new Card("6 of Spades", 6);
		Card SevenOfSpades = new Card("7 of Spades", 7);
		Card EightOfSpades = new Card("8 of Spades", 8);
		Card NineOfSpades = new Card("9 of Spades", 9);
		Card TenOfSpades = new Card("10 of Spades", 10);
		Card JackOfSpades = new Card("Jack of Spades", 10);
		Card QueenOfSpades = new Card("Queen of Spades", 10);
		Card KingOfSpades = new Card("King of Spades", 10);
		
		deck.put(0, AceOfHearts);
		deck.put(1, TwoOfHearts);
		deck.put(2, ThreeOfHearts);
		deck.put(3, FourOfHearts);
		deck.put(4, FiveOfHearts);
		deck.put(5, SixOfHearts);
		deck.put(6, SevenOfHearts);
		deck.put(7, EightOfHearts);
		deck.put(8, NineOfHearts);
		deck.put(9, TenOfHearts);
		deck.put(10, JackOfHearts);
		deck.put(11, QueenOfHearts);
		deck.put(12, KingOfHearts);
		
		deck.put(13, AceOfDiamonds);
		deck.put(14, TwoOfDiamonds);
		deck.put(15, ThreeOfDiamonds);
		deck.put(16, FourOfDiamonds);
		deck.put(17, FiveOfDiamonds);
		deck.put(18, SixOfDiamonds);
		deck.put(19, SevenOfDiamonds);
		deck.put(20, EightOfDiamonds);
		deck.put(21, NineOfDiamonds);
		deck.put(22, TenOfDiamonds);
		deck.put(23, JackOfDiamonds);
		deck.put(24, QueenOfDiamonds);
		deck.put(25, KingOfDiamonds);
		
		deck.put(26, AceOfClubs);
		deck.put(27, TwoOfClubs);
		deck.put(28, ThreeOfClubs);
		deck.put(29, FourOfClubs);
		deck.put(30, FiveOfClubs);
		deck.put(31, SixOfClubs);
		deck.put(32, SevenOfClubs);
		deck.put(33, EightOfClubs);
		deck.put(34, NineOfClubs);
		deck.put(35, TenOfClubs);
		deck.put(36, JackOfClubs);
		deck.put(37, QueenOfClubs);
		deck.put(38, KingOfClubs);
		
		deck.put(39, AceOfSpades);
		deck.put(40, TwoOfSpades);
		deck.put(41, ThreeOfSpades);
		deck.put(42, FourOfSpades);
		deck.put(43, FiveOfSpades);
		deck.put(44, SixOfSpades);
		deck.put(45, SevenOfSpades);
		deck.put(46, EightOfSpades);
		deck.put(47, NineOfSpades);
		deck.put(48, TenOfSpades);
		deck.put(49, JackOfSpades);
		deck.put(50, QueenOfSpades);
		deck.put(51, KingOfSpades);
		
		return deck;
	}
}
