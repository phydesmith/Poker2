package com.javasmithy;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void onePair() {
        List<Card> hand = List.of(
                new Card(Face.ACE, Suit.DIAMONDS, 13),
                new Card(Face.ACE, Suit.CLUBS, 13),
                new Card(Face.EIGHT, Suit.CLUBS, 8),
                new Card(Face.TWO, Suit.DIAMONDS, 2),
                new Card(Face.SEVEN, Suit.HEARTS, 7)
        );

        assertTrue(Game.onePair(hand), "hand should be one pair");
    }

    @Test
    void twoPair() {
    }

    @Test
    void threeOfAKind() {
    }

    @Test
    void straight() {
    }

    @Test
    void flush() {
    }

    @Test
    void fullHouse() {
    }

    @Test
    void fourOfACKind() {
    }

    @Test
    void straightFlush() {
    }

    @Test
    void royalFlush() {
    }
}