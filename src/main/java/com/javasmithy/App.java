package com.javasmithy;

import java.util.ArrayList;
import java.util.List;

public class App {
    private List<Card> cards;

    public App(Card card1, Card card2, Card card3, Card card4, Card card5){
        this.cards = new ArrayList<>();
    }

    public static void main(String[] args){
        App app = new App(
                parseArgToCard(args[0]),
                parseArgToCard(args[1]),
                parseArgToCard(args[2]),
                parseArgToCard(args[3]),
                parseArgToCard(args[4])

        );

    }

    public static Card parseArgToCard(String arg){
        String[] params = arg.split(",");
        return new Card(Face.valueOf(params[0]), Suit.valueOf(params[1]), Integer.parseInt(params[2]));
    }

    public List<Card> getCards(){
        return this.cards;
    }


}
