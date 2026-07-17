class rotateArray{
    public static void rotate(int[] a){
        int n = a.length;
        int next = a[n-1];
        for(int i=0;i<n;i++){
            int curr = a[i];
            a[i]=next;
            next =curr;
        }
    }
    public static void main(String[] args) {
        int [] a = {1,2,3,4,5};
        rotate(a);
        for(int val :a){
            System.out.print(val+" ");
        }
    }
}