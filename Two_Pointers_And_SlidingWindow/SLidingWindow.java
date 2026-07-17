import java.util.*;

public class SLidingWindow {
    public static int kSumSubarray(int[] a,int k){
        int n = a.length;
        int count =0;
        int l =0,r=l;
        int sum =0;
        while(r<n){
            sum +=a[r];
            if(sum == k){
                count++;
            }
            while(sum>k){
                sum -= a[l];
                l++;
            }
            r++;
        }
        return count;
    }
    public static int LongestSubarrayWithSumK(int[] a,int k){
        int n = a.length;
        int l =0;
        int r = l;
        int maxLen = 0,sum=0;
        while(r<n){
            sum += a[r];
            while(sum>k){
                sum -=a[l];
                l++;
            }
            maxLen=Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
    public static int longestSubstringWithNonRepeatingCharacters(String s){
        int n = s.length();
        int len =0;
        HashSet<Character> set = new HashSet<>();
        int l=0,r=0;
        while(r<n){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
            }else{
               while(set.contains(s.charAt(r))){
                    set.remove(s.charAt(l));
                    l++;
               }
            }
            len = Math.max(len,r-l-1);
            r++;
        }
        return len;
    }
    public static int LongestSubWIthKDIstinct(String s,int k){//close but its not it
        int n = s.length();
        int maxLen= 1;
        int l=0,r=0;
        HashSet<Character> set = new HashSet<>();
        while(r<n){
            if(set.size()<=k){
                set.add(s.charAt(r));
            }else{
                while(set.size()>k){
                    set.remove(s.charAt(l));
                    l++;
                }
                set.add(s.charAt(r));
            }
            maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
        return maxLen;
    }
    public static int LongestSubKdis(String s,int k){
        int n = s.length();
        HashMap<Character,Integer> map = new HashMap<>();
        int l =0,r=0;
        int maxLen = 0;
        while(r<n){
            char rigth = s.charAt(r);
            map.put(rigth,map.getOrDefault(rigth, 0)+1);
            while(map.size()>k){
                char left = s.charAt(l);
                map.put(left,map.get(left)-1);
                if(map.get(left)<=0){
                    map.remove(left);
                }
                l++;
            }maxLen = Math.max(maxLen,r-l+1);
            r++;
        }
            
        return maxLen;
    }
    public static boolean equal(char[] a,char[] b){
        for(int i=0;i<a.length&&i<b.length;i++){
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
    public static List<Integer> anagrams(String s,String p){
        int n1 = s.length();
        char[] pattern = p.trim().toCharArray();
        Arrays.sort(pattern);
        int k = pattern.length;
        int l=0,r=k;
        List<Integer> list = new ArrayList<>();
        while(r<=n1){
            char [] curr = s.substring(l,r).toCharArray();
            Arrays.sort(curr);
            if(equal(curr,pattern)){
                list.add(l);
            }
            l++;r++;
        }
        return list;
    }
    public static String minWindowSubstring(String s,String p){
        if(p.isBlank() || s.isBlank()) return "";
        HashMap<Character,Integer> reqFreq = new HashMap<>();
        HashMap<Character,Integer> window = new HashMap<>();
        for(char c:p.toCharArray()){
            reqFreq.put(c,reqFreq.getOrDefault(c,0)+1);
        }
        int formed = 0;
        int n = s.length();
        int l=0,r=0;
        String minSub = "";
        int minWin = Integer.MAX_VALUE;
        while(r<n){
            char right = s.charAt(r);
            if(reqFreq.containsKey(right)){
            window.put(right,window.getOrDefault(right,0)+1);
            if(window.get(right)==reqFreq.get(right)){
                formed++;
            }
            //extendingWIndow
            if(formed == reqFreq.size()){
                if (r-l+1<minWin) {
                    minWin = r-l+1;
                    minSub = s.substring(l,r+1);
                    }
                }
        }
            //Shrinking window
            while(formed == reqFreq.size()){
                if (r-l+1<minWin) {
                    minWin = r-l+1;
                    minSub = s.substring(l,r+1);
                    }
                
                char left = s.charAt(l);
                if(window.containsKey(left)){
                window.put(left,window.get(left)-1);
                if(window.get(left)<reqFreq.get(left)){
                    formed--;
                }
            } l++;}r++;
           
        }
        return (minWin==Integer.MAX_VALUE)?"":minSub;
        
        }
    public static void main(String[] args) {
        String s = "adobecodebanc";
        String p = "abc";
        System.out.println(minWindowSubstring(s,p));
    }
}
