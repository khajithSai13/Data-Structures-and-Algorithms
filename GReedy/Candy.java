class Candy{
    public static int candy(int[] ratings){ // time = O(n) Space = O(n)
        int n = ratings.length;
        if(n==1) return 1;
        int[] left = new int[n];
        int right[] = new int[n];
        left[0] = 1;
        int minimum = 1;
        right[n-1] = 1;
        for(int i=1;i<n;i++){
            if(ratings[i]>ratings[i-1]){ 
                left[i] = left[i-1]+1;    
            }else{
                left[i] = minimum;
            }
        }
        for(int i = n-2;i>=0;i--){
            if(ratings[i+1] <ratings[i]){
                right[i] = right[i+1]+1;
            }else{
                right[i] = minimum;
            }
        }
        int min = 0;
        for(int i=0;i<n;i++){
            min += Math.max(left[i],right[i]);
        }
        return min;
    }
    // public static int candy2(int[] ratings){
    //     int n = ratings.length;
    //     int left = 1;
    //     int right = 1;
    //     int minimum = 1;
    //     int currLeft = 1;
    //     int currRight = (ratings[0] > ratings[1])? minimum : minimum+1;
    //     int totalCandies = 0;
    //     for(int i =0;i<n;i++){
    //         left = (i>0) ?(ratings[i-1] < ratings[i] ? currLeft+1:minimum) :minimum;
    //         right = (i<n-1) ? (ratings[i]>ratings[i+1] ? currRight+1: minimum):minimum;
    //         totalCandies += Math.max(left,right);
    //         currLeft = left;
    //         currRight = ;
    //     }
    //     return totalCandies;
    // }
    public static void main(String[] args) {
        int[] ratings = {1,2,3,4,5};
        System.out.println(candy(ratings));
    }
}
