package Strings;
import java.util.*;
public class TextJustification {
    public static List<String> textJust(String[] words, int maxWidth){
        List<String> list = new ArrayList<>();
        if(maxWidth == 0) return list;
        int n = words.length;
        int curr = 0,currWords = 0;
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i< n){
            curr = 0;
            int j = i;
            sb.setLength(0);
            currWords = 0;
            while(curr < maxWidth && j<n){
                curr += words[j].length();
                currWords++;
                j++;
                System.out.println(curr+" "+maxWidth+" "+currWords);
            }
            if(curr > maxWidth){
                curr -= words[j].length();
                currWords--;
            }
            System.out.println(curr+" "+maxWidth+" "+currWords);
            int gaps = maxWidth-curr;
            int numb = gaps/currWords;
            for(int val =i;val<=j-1;val++){
                sb.append(words[val]);
                for(int k=0;k<numb;k++){
                    sb.append(" ");
                }
            }
            if(gaps%currWords!=0){
                for(int k=0;k<gaps%currWords;k++){
                    sb.append(" ");
                }
            }
            //System.out.println(curr+" "+maxWidth+" "+currWords);
            i=j;
            System.out.println("lenght : "+sb.length());
            list.add(sb.toString());
        }
        return list;
    }
    public static void main(String[] args) {
        String [] words = {"What","must","be","acknowledgment","shall","be"};
        System.out.println(textJust(words,16));
    }
}
