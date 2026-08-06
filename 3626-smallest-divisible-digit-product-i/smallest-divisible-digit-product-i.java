class Solution {
    public int smallestNumber(int n, int t) {
       while(true){
        int mul=1;
        int x=n;
            while(x>0){
                int m=x%10;
                mul*=m;
                x=x/10;
            }
            if(mul%t==0){
                return n;
            }
            n++;
       }
    }
}