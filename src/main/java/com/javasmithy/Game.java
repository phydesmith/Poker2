package com.javasmithy;

import java.util.List;

public class Game {

    public static boolean twoOfAKind(List<Card> hand) {
        hand.sort((a, b) -> a.getFace().compareTo(b.getFace()));
        int numberOfMatches = 0;
        for(int i=0;i < hand.size()-1; i++) {
            if (hand.get(i).getFace().equals(hand.get(i+1).getFace())) return true;
        }
        return false;
    }
}
