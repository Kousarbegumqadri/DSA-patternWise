class Solution {
    public String largestPalindromic(String num) {
        int n=num.length();
        int[] freq=new int[10];
        for(char ch:num.toCharArray()){
            freq[ch-'0']++;
        }
        StringBuilder first=new StringBuilder();
        String middle="";
        int val=0;
        for(int i=9;i>=0;i--){
           for(int j=0;j<freq[i]/2;j++){
            first.append((char)(i+'0'));
           }
        }
        if (first.length() > 0 && first.charAt(0) == '0') {
            first.setLength(0);
        }
        for(int i=9;i>=0;i--){
            if(freq[i]%2!=0){
                middle=String.valueOf(i);
                break;
            }
        }
        String second=new StringBuilder(first).reverse().toString();
        String ans=first.toString()+middle+second;
        if(ans.length()==0){
            return "0";
        }
        return ans;
    }
}