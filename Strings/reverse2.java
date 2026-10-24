public class reverse2 {
    public static String rev(String s,int k){
        int n = s.length();
        if(n<k){
            return new StringBuilder(s).reverse().toString();
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder curr = new StringBuilder();
        int temp = 0;
        boolean up = true;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            curr.append(ch);
            temp++;
            if(temp == k){
                if(up){
                    sb.append(curr.reverse().toString());
                }else{
                    sb.append(curr.toString());
                }
                up = !up;
                temp =0;                    
                curr.setLength(0);
            }
        }
        sb.append(curr.toString());
        return sb.toString();
    }
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(rev(s,2));
    }
}
