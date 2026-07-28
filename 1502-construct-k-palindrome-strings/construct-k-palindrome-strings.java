class Solution {
    public boolean canConstruct(String s, int k) {
        int n=s.length();
        if(n==k){
            return true;
        }
        if(n<k){
            return false;
        }
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }
        int odd=0;
        for(int i=0;i<26;i++){
            if(freq[i]%2!=0){
                odd++;
            }
            if(odd>k){
                return false;
            }
        }
       return true; 
    }
}