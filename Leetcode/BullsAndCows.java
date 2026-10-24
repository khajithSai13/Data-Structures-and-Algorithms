package Leetcode;

import java.util.*;

import javax.print.attribute.HashAttributeSet;

public class BullsAndCows {
    public static String bullsandcows(String secret, String guess){
        int n = secret.length();
        int bulls = 0;
        int cows = 0;
        int duplicates = 0;
        //HashMap<Character,Boolean> map = new HashMap();
        HashSet<Character> set = new HashSet<>();
        for(int i=0;i<n;i++){
            if(secret.charAt(i) == guess.charAt(i)){
                bulls++;
            }
            if(set.contains(guess.charAt(i))){
                duplicates++;
            }
            set.add(guess.charAt(i));
        }
        for(int i=0;i<n;i++){
            char ch = secret.charAt(i);
            if(set.contains(ch)){
                cows++;
            }
        }
        cows -= (bulls+duplicates);
        return bulls+"A"+cows+"B";
    }
    public static void main(String[] args) {
        String secret = "1807";
        String guess = "7817 ";
        System.out.println(bullsandcows(secret,guess));
    }
}
