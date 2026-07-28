class Solution {
    public int longestPalindrome(String s) {
        int n=s.length();
        if(n==1){
            return 1;
        }
        int[] freq=new int[52];
        for(char ch:s.toCharArray()){
           if(Character.isLowerCase(ch)){
            freq[ch-'a']++;
           }
           else{
            freq[ch-'A'+26]++;
           }
        }
        int count=0;
        boolean odd=false;
        for(int i=0;i<52;i++){
            if(freq[i]%2==0){
                count=count+freq[i];
            }
            else{
              count=count+freq[i]-1;
              odd=true;
            }
        }
        if(odd){
            count++;
        }
        return count;
    }
}