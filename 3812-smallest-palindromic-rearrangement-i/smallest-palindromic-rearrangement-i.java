class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        if(n==1){
            return s;
        }
        int[] freq=new int[26];
        for( char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

        StringBuilder sb=new StringBuilder();
        String middle= "";

        for(int i=0;i<26;i++){
            if(freq[i]%2==1){
                middle=String.valueOf((char)(i + 'a'));
            }
            for(int j=0;j<freq[i]/2;j++){
                sb.append((char)(i+'a'));
            }
        }
        String second=new StringBuilder(sb).reverse().toString();
        return sb.toString()+middle+second;
    }
}