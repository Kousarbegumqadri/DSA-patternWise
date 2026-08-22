class Solution {
    public boolean checkDivisibility(int n) {
        int m=n;
        int sum=0,prod=1;
        while(m>0){
            int x=m%10;
            sum=sum+x;
            prod=prod*x;
            m=m/10;
        }
        int ans=sum+prod;
        if(n%ans==0){
            return true;
        }
        else{
          return  false;
        }
       // return true;
    }
}