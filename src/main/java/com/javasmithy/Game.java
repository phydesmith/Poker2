package com.javasmithy;

import java.util.*;


/**
 * Algorithms for evaluating poker hands taken from http://nsayer.blogspot.com/2007/07/algorithm-for-evaluating-poker-hands.html
 * implementation in Java by Peter Hyde-Smith
 */
public class Game {


    /**
     * Returns an array of integers that act as a 'histogram' for counting how many cards of each rank there are
     *
     * @param hand a list of cards to convert into a histogram
     * @return an array of integers
     */
    private static int[] createHistogramFromHand(List<Card> hand) {
        int[] histogram = new int[15];
        for (Card c :
                hand) {
            histogram[c.getValue()]++;
        }
        System.out.println(Arrays.toString(histogram));
        return histogram;
    }

    /**
     * Checks for a singular pair of cards based on face value
     * @param hand a list of cards
     * @return a boolean based on whether hand meets conditions
     */
    public static boolean onePair(List<Card> hand) {
        int[] histogram = createHistogramFromHand(hand);
        int numOfUniqueRanks = 0;
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] > 0) numOfUniqueRanks++;
        }
        return (numOfUniqueRanks == 4);
    }

    /**
     * Checks for two pairs of cards, two different face values
     * @param hand a list of cards
     * @return a boolean based on whether hand meets conditions
     */
    public static boolean twoPair(List<Card> hand) {
        int[] histogram = createHistogramFromHand(hand);
        int rankCountIs2 = 0;
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] == 2) rankCountIs2++;
        }
        return (rankCountIs2 == 2);
    }

    /**
     * Checks for three cards with the same face values, with the remaining two being of unique face values
     * @param hand a list of cards
     * @return a boolean based on whether hand meets conditions
     */
    public static boolean threeOfAKind(List<Card> hand) {
        int[] histogram = createHistogramFromHand(hand);
        int rankCountIs3 = 0;
        int rankCountIs1 = 0;
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] == 3) rankCountIs3++;
            if (histogram[i] == 1) rankCountIs1++;
        }
        return (rankCountIs3 == 1 && rankCountIs1 == 2);
    }

    /**
     * Checks for consecutive number not of same suit. Checks for 'wheel' where ace is low first.
     * Then checks low and high card using the threshold outlined by blogpost implementation.
     *
     * @param hand a list of cards
     * @return a boolean based on whether hand meets conditions
     */
    public static boolean straight(List<Card> hand) {
        hand.sort(Comparator.comparing(Card::getFace));
        Collections.reverse(hand);
        if (hand.get(0).getFace() == Face.ACE && hand.get(1).getFace() == Face.FIVE) return true;
        return ((hand.get(0).getValue() - hand.get(4).getValue()) == 4);
    }

    /**
     * Checks that all cards are in the same suit
     * @param hand a list of cards
     * @return a boolean based on whether hand meets conditions
     */
    public static boolean flush(List<Card> hand) {
        Set<Suit> suitSet = new HashSet<Suit>();
        for (Card c :
                hand) {
            suitSet.add(c.getSuit());
        }
        return (suitSet.size() == 1);
    }

    /**
     * Checks for a pair and a three of a kind
     * @param hand a list of cards
     * @return a boolean based on whether hand meets conditions
     */
    public static boolean fullHouse(List<Card> hand) {
        int[] histogram = createHistogramFromHand(hand);
        int rankCountIs3 = 0;
        int rankCountIs2 = 0;
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] == 3) rankCountIs3++;
            if (histogram[i] == 2) rankCountIs2++;
        }
        return (rankCountIs3 == 1 && rankCountIs2 == 1);
    }

    /**
     * Check for four cards being of the same face value with the remaining being different
     * @param hand a list of cards
     * @return a boolean based on whether hand meets conditions
     */
    public static boolean fourOfAKind(List<Card> hand) {
        int[] histogram = createHistogramFromHand(hand);
        int rankCountIs4 = 0;
        int rankCountIs1 = 0;
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] == 4) rankCountIs4++;
            if (histogram[i] == 1) rankCountIs1++;
        }
        return (rankCountIs4 == 1 && rankCountIs1 == 1);
    }

    /**
     * Checks that conditions for flush and straight are true, while the conditions for a royal flush are false
     * @param hand a list of cards
     * @return a boolean based on whether hand meets conditions
     */
    public static boolean straightFlush(List<Card> hand) {
        return ((flush(hand) && straight(hand)) && !(royalFlush(hand)));
    }

    /**
     * checks for the conditions of a flush being true while also having the cards be of face value 10, J, Q, K, A
     * @param hand a list of cards
     * @return a boolean based on whether hand meets conditions
     */
    public static boolean royalFlush(List<Card> hand) {
        Set<Face> royals = new HashSet<>(List.of(Face.ACE, Face.KING, Face.QUEEN, Face.JACK, Face.TEN));

        hand.sort(Comparator.comparing(Card::getFace));
        Collections.reverse(hand);
        Set<Face> handFaceSet = new HashSet<>();
        for (Card c :
                hand) {
            handFaceSet.add(c.getFace());
        }
        return royals.equals(handFaceSet) && flush(hand);
    }
}
