class Solution {
    public int minimumPushes(String word) {
       

        int[] freq=new int[26];
        for(char ch:word.toCharArray()){
            freq[ch-'a']++;
        }
        Arrays.sort(freq);
        int ans=0,index=0;
        for(int i=25;i>=0;i--){
            if(freq[i]==0){
                break;
            }
            int pushes=index/8+1;
            ans+=pushes*freq[i];
            index++;
        }
        return ans;
    }
}