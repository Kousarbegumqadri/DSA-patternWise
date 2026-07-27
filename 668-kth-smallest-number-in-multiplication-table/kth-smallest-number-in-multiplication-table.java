class Solution {
    public int fun(int m,int n,int guess,int k){
        int row=m,col=1;
        int count=0;
        while(row>=1 && col<=n){
            int x=row*col;
            if(x<=guess){
                count=count+row;
                col++;
            }
            else{
            row--;
            }
        }
        return count;
    }
    public int findKthNumber(int m, int n, int k) {
        int low=0,high=m*n;
        int res=-1;
        while(low<=high){
            int guess=(low+high)/2;
            int ans=fun(m,n,guess,k);
            if(ans<k){
                low=guess+1;
            }
            //ans>=k
            else{
                res=guess;
                high=guess-1;
            }
        }
        return res;
    }
}