class Solution {
    public int minimumPushes(String word) {
        int[] freq=new int[26];
        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        int index=0,ans=0,push=0;
        Arrays.sort(freq);
        for(int i=25;i>=0;i--){
            if(freq[i]==0){
                break;
            }
            push= (index/8)+1;
            ans+=push*freq[i];
            index++;
         }
        return ans;
    }
}