class Solution {
     public int find(int freq[]){
            int maxcount=-1;
            for(int i=0;i<256;i++){
                maxcount=Math.max(freq[i],maxcount);
            }
            return maxcount;
        }
    public int characterReplacement(String s, int k) {
        int n=s.length();
        int[] arr=new  int[256];
        int high=0,low=0,len=0,res=1,diff=0;
        for(high=0;high<n;high++){
            char ch=s.charAt(high);
            arr[ch]++;
            int maxcount=find(arr);
            len=high-low+1;
            diff=len-maxcount;
            while(diff>k){
                char left=s.charAt(low);
                arr[left]--;
                low++;
            maxcount=find(arr);
            len=high-low+1;
            diff=len-maxcount;
            }
            len=high-low+1;
            res=Math.max(res,len);
        }
        return res;
    }
}