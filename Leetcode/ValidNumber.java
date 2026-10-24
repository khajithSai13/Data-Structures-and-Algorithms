package Leetcode;
import java.util.*;
class ValidNumber{
    public static boolean isValid(String s){
        int n = s.length();
        if( n == 1) return Character.isDigit(s.charAt((0)));
        boolean sign = false;
        boolean decimalPoint = false;
        boolean exponent  = false;
        boolean number = false;
        int start = 0;
        if(s.charAt(start) == '-' || s.charAt(start) == '+') sign = true;
        start = sign ? 1:0;
        while(start < n){
            char ch = s.charAt(start);
            if(!Character.isDigit(ch)){
                if(ch =='.'){
                    if(decimalPoint) return false;
                    if(exponent) return false;
                    decimalPoint = true;
                    if(start == n-1) return false;
                }else if(ch =='e' || ch =='E'){
                    if(exponent || start ==n-1 || start ==0|| !number ) return false;
                    exponent = true;
                    sign = false;
                    if(start == n-1) return false;
                }else if(ch =='+' || ch =='-'){
                    if(sign){
                        if(decimalPoint){
                            if(!exponent) return false;
                            sign = true;
                        }
                    }else if(decimalPoint){
                        if(!exponent) return false;
                        sign = true;
                    }
                }
                else{
                    return false;
                }
            }else{
                number = true;
            }
            start++;
        }
        return true;
    }
    public static void main(String [] args){
        System.out.println(isValid("-.e3"));
    }
}