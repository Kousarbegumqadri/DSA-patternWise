class Solution {
    public int totalNumbers(int[] digits) {
        int count=0;
        for(int num=100;num<=999;num++){
            if(num%2!=0){
                continue;
            }
            int[] freq=new int[10];
            for(int d:digits){
                freq[d]++;
            }
            int n=num;
            int d1=n/100;
            n%=100;
            int d2=n/10;
            n%=10;
            int d3=n%10;
            if(freq[d1]>0){
                freq[d1]--;
            }
            else{
                continue;
            }
            if(freq[d2]>0){
                freq[d2]--;
            }
            else{continue;}
            if(freq[d3]>0){
                count++;
            }
            else{continue;}
        }
        return count;
    }
}