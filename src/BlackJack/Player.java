package BlackJack;

import java.util.ArrayList;

public class Player {
	ArrayList<Card> cards = new ArrayList<Card>();
	int numberOfCards;
	int totalHand;

	public Player() {
		numberOfCards = 0;
		totalHand = 0;
	}
	
	public void addCard(Card card) {
		cards.add(card);
		totalHand += card.value;
		numberOfCards++;
	}
	
	public int getTotal() {
		return totalHand;
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
}
