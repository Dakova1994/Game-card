package com.company;

import java.util.*;

public class WarGame {
    public static void main(String[] args)
    {
        CardDeck Decks = new CardDeck();
        List<Card> cardDeck = Decks.getCardDeck();
        Collections.shuffle(cardDeck, new Random());

        LinkedList<Card> deckForPlayer1 = new LinkedList<Card>(cardDeck.subList(0, 25));
        LinkedList<Card> deckForPlayer2 = new LinkedList<Card>(cardDeck.subList(26, cardDeck.size()));

        System.out.println("Player 1 cards:" + deckForPlayer1 );
        System.out.println("Player 2 cards:" + deckForPlayer2 );
        System.out.println(deckForPlayer1.size());
        System.out.println(deckForPlayer2.size());
        while(true){
            Card playerOneCard = deckForPlayer1.pop();
            Card playerTwoCard = deckForPlayer2.pop();

            System.out.println("Player 1 plays card is " + playerOneCard.toString());
            System.out.println("Player 2 plays card is " + playerTwoCard.toString());


            if(playerOneCard.getCard() > playerTwoCard.getCard()){
                deckForPlayer1.addLast(playerOneCard);
                deckForPlayer1.addLast(playerTwoCard);
                System.out.println("PLayer 1 wins the round");
            }

            else if(playerOneCard.getCard() < playerTwoCard.getCard()){
                deckForPlayer2.addLast(playerOneCard);
                deckForPlayer2.addLast(playerTwoCard);
                System.out.println("PLayer 2 wins the round");
            }

            else {
                List<Card> deckOfWarForPlayer1 = new ArrayList<Card>();
                List<Card> deckOfWarForPlayer2 = new ArrayList<Card>();
                deckOfWarForPlayer1.add(playerOneCard);
                deckOfWarForPlayer2.add(playerTwoCard);
                for(int i=0; i<2; i++){
                    if (deckForPlayer1.size() == 0 || deckForPlayer2.size() == 0) {
                            break;
                        }
                    deckOfWarForPlayer1.add(deckForPlayer1.pop());
                    deckOfWarForPlayer2.add(deckForPlayer2.pop());
                    }


                if(deckOfWarForPlayer1.size() == 3 && deckOfWarForPlayer2.size() == 3 ){
                    System.out.println("----------War-----------");
                    System.out.println("War card for player1 is hidden\nWar card for player2 is hidden");
                    System.out.println("War card for player1 is " + deckOfWarForPlayer1.get(1).toString());
                    System.out.println("War card for player2 is " + deckOfWarForPlayer2.get(1).toString());


                    if(deckOfWarForPlayer1.get(2).getCard() > deckOfWarForPlayer2.get(2).getCard()){
                        deckForPlayer1.addAll(deckOfWarForPlayer1);
                        deckForPlayer1.addAll(deckOfWarForPlayer2);
                        System.out.println("Player 1 wins the war");
                    }

                    else{
                        deckForPlayer2.addAll(deckOfWarForPlayer1);
                        deckForPlayer2.addAll(deckOfWarForPlayer2);
                        System.out.println("Player 2 wins the war");
                    }
                }

            }


            if(deckForPlayer1.size() == 0 ){
                System.out.println("game over\nPlayer 2 wins the game");
                break;
            }
            else if(deckForPlayer2.size() == 0){
                System.out.println("game over\nPlayer 1 wins the game");
                break;
            }

        }//end while
        System.out.println("Player 1 cards:" + deckForPlayer1 );
        System.out.println("Player 2 cards:" + deckForPlayer2 );
    }//end main
}

