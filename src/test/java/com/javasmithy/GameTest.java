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
                new Card(Face.ACE, Suit.DIAMONDS, 14),
                new Card(Face.ACE, Suit.CLUBS, 14),
                new Card(Face.EIGHT, Suit.CLUBS, 8),
                new Card(Face.TWO, Suit.DIAMONDS, 2),
                new Card(Face.SEVEN, Suit.HEARTS, 7)
        );

        assertTrue(Game.onePair(hand), "hand should be one pair");
    }

    @Test
    void twoPair() {
        List<Card> hand = List.of(
                new Card(Face.ACE, Suit.DIAMONDS, 14),
                new Card(Face.ACE, Suit.CLUBS, 14),
                new Card(Face.EIGHT, Suit.CLUBS, 8),
                new Card(Face.EIGHT, Suit.DIAMONDS, 8),
                new Card(Face.SEVEN, Suit.HEARTS, 7)
        );

        assertTrue(Game.twoPair(hand), "hand should be two pair");
    }

    @Test
    void threeOfAKind() {
        List<Card> hand = List.of(
                new Card(Face.ACE, Suit.DIAMONDS, 14),
                new Card(Face.ACE, Suit.CLUBS, 14),
                new Card(Face.ACE, Suit.HEARTS, 14),
                new Card(Face.EIGHT, Suit.DIAMONDS, 8),
                new Card(Face.SEVEN, Suit.HEARTS, 7)
        );
        assertTrue(Game.threeOfAKind(hand), "hand should be three of a kind, three aces and an 8 and a seven");

        hand = List.of(
                new Card(Face.ACE, Suit.DIAMONDS, 14),
                new Card(Face.ACE, Suit.CLUBS, 14),
                new Card(Face.ACE, Suit.HEARTS, 14),
                new Card(Face.EIGHT, Suit.DIAMONDS, 8),
                new Card(Face.EIGHT, Suit.HEARTS, 8)
        );
        assertFalse(Game.threeOfAKind(hand), "hand should not be three of a kind, three aces and a pair is a full house");
    }

    @Test
    void straight() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Face.TWO, Suit.DIAMONDS, 2));
        hand.add(new Card(Face.THREE, Suit.SPADES, 3));
        hand.add(new Card(Face.FOUR, Suit.DIAMONDS, 4));
        hand.add(new Card(Face.FIVE, Suit.CLUBS, 5));
        hand.add(new Card(Face.SIX, Suit.DIAMONDS, 6));
        assertTrue(Game.straight(hand), "Hand should be a straight, consecutive numbers");

        hand = new ArrayList<>();
        hand.add(new Card(Face.TWO, Suit.DIAMONDS, 2));
        hand.add(new Card(Face.THREE, Suit.SPADES, 3));
        hand.add(new Card(Face.FOUR, Suit.DIAMONDS, 4));
        hand.add(new Card(Face.FIVE, Suit.CLUBS, 5));
        hand.add(new Card(Face.ACE, Suit.DIAMONDS, 14));
        assertTrue(Game.straight(hand), "Hand should be a straight, consecutive numbers, aces low");

        hand = new ArrayList<>();
        hand.add(new Card(Face.TEN, Suit.SPADES, 10));
        hand.add(new Card(Face.JACK, Suit.DIAMONDS, 11));
        hand.add(new Card(Face.QUEEN, Suit.DIAMONDS, 12));
        hand.add(new Card(Face.KING, Suit.CLUBS, 13));
        hand.add(new Card(Face.ACE, Suit.DIAMONDS, 14));
        assertTrue(Game.straight(hand), "Hand should be a straight, consecutive numbers, aces high");
    }

    @Test
    void flush() {
        List<Card> hand = List.of(
                new Card(Face.TWO, Suit.DIAMONDS, 2),
                new Card(Face.FIVE, Suit.DIAMONDS, 5),
                new Card(Face.SEVEN, Suit.DIAMONDS, 7),
                new Card(Face.EIGHT, Suit.DIAMONDS, 8),
                new Card(Face.TEN, Suit.DIAMONDS, 10)
        );
        assertTrue(Game.flush(hand), "Hand should be a flush, all same suit");

        hand = List.of(
                new Card(Face.TWO, Suit.DIAMONDS, 2),
                new Card(Face.FIVE, Suit.DIAMONDS, 5),
                new Card(Face.SEVEN, Suit.DIAMONDS, 7),
                new Card(Face.EIGHT, Suit.DIAMONDS, 8),
                new Card(Face.TEN, Suit.SPADES, 10)
        );
        assertFalse(Game.flush(hand), "Hand should be a flush, all same suit");
    }

    @Test
    void fullHouse() {
        List<Card> hand = List.of(
                new Card(Face.ACE, Suit.DIAMONDS, 14),
                new Card(Face.ACE, Suit.CLUBS, 14),
                new Card(Face.ACE, Suit.HEARTS, 14),
                new Card(Face.EIGHT, Suit.DIAMONDS, 8),
                new Card(Face.EIGHT, Suit.HEARTS, 8)
        );
        assertTrue(Game.fullHouse(hand), "Hand should be a full house from 3 of a kind and 2 of a kind");
    }

    @Test
    void fourOfAKind() {
        List<Card> hand = List.of(
                new Card(Face.ACE, Suit.DIAMONDS, 14),
                new Card(Face.ACE, Suit.CLUBS, 14),
                new Card(Face.ACE, Suit.HEARTS, 14),
                new Card(Face.ACE, Suit.SPADES, 14),
                new Card(Face.EIGHT, Suit.HEARTS, 8)
        );
        assertTrue(Game.fourOfAKind(hand), "Hand should be a four of a kind");
    }

    @Test
    void straightFlush() {
        List<Card> hand = new ArrayList<>(List.of(
                new Card(Face.TWO, Suit.DIAMONDS, 2),
                new Card(Face.THREE, Suit.DIAMONDS, 3),
                new Card(Face.FOUR, Suit.DIAMONDS, 4),
                new Card(Face.FIVE, Suit.DIAMONDS, 5),
                new Card(Face.SIX, Suit.DIAMONDS, 6)
        ));
        assertTrue(Game.straightFlush(hand), "Hand should be a straight, consecutive numbers and flush, same suit");

        hand = new ArrayList<>(List.of(
                new Card(Face.TEN, Suit.DIAMONDS, 10),
                new Card(Face.JACK, Suit.DIAMONDS, 11),
                new Card(Face.QUEEN, Suit.DIAMONDS, 12),
                new Card(Face.KING, Suit.DIAMONDS, 13),
                new Card(Face.ACE, Suit.DIAMONDS, 14)
        ));
        assertFalse(Game.straightFlush(hand), "Hand should be not be straightFlush as it's a royal flush");
    }

    @Test
    void royalFlush() {
        List<Card> hand = new ArrayList<>(List.of(
                new Card(Face.TEN, Suit.DIAMONDS, 10),
                new Card(Face.JACK, Suit.DIAMONDS, 11),
                new Card(Face.QUEEN, Suit.DIAMONDS, 12),
                new Card(Face.KING, Suit.DIAMONDS, 13),
                new Card(Face.ACE, Suit.DIAMONDS, 14)
        ));
        assertTrue(Game.royalFlush(hand), "Hand should be a straight, consecutive numbers and flush, same suit and consist of 10, J, Q, K , A");
    }
}