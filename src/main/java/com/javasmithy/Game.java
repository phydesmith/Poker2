package com.javasmithy;

import java.util.Arrays;
import java.util.List;


/**
 * Algorithms for evaluating poker hands taken from http://nsayer.blogspot.com/2007/07/algorithm-for-evaluating-poker-hands.html
 */
public class Game {


    /**
     * Returns an array of integers that act as a 'histogram' for counting how many cards of each rank there are
     * @param hand a list of cards to convert into a histogram
     * @return an array of integers
     */
    private static int[] createHistogramFromHand(List<Card> hand){
        int[] histogram = new int[14];
        for (Card c:
                hand) {
            histogram[c.getValue()]++;
        }
        System.out.println(Arrays.toString(histogram));
        return histogram;
    }

    public static boolean onePair(List<Card> hand){
        int[] histogram = createHistogramFromHand(hand);
        int ranks = 0;
        for (int i = 0; i < histogram.length; i++){
            if (histogram[i] > 0) ranks ++;
        }
        return (ranks == 4);
    }
    public static boolean twoPair(List<Card> hand){ return false;}
    public static boolean threeOfAKind(List<Card> hand){return false;}
    public static boolean straight(){return false;}
    public static boolean flush(){return false;}
    public static boolean fullHouse(){return false;}
    public static boolean fourOfACKind(List<Card> hand){ return false;}
    public static boolean straightFlush(List<Card> hand){return false;}
    public static boolean royalFlush(List<Card> hand){return false;}
}
