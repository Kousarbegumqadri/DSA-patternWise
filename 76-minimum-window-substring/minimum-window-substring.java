class Solution {
     public boolean sahi(int[] have,int[]needed){
            for(int i=0;i<256;i++){
                if(needed[i]>have[i]){
                    return false;
                }
            }
            return true;
        }
    public String minWindow(String s, String t) {
        int n=s.length();
        int m=t.length();
        int high=0,low=0,start=0,res=Integer.MAX_VALUE;
        int[] have=new int[256];
        int[] needed=new int[256];
        for(int i=0;i<m;i++){
            needed[t.charAt(i)]++;
        }
        for(high=0;high<n;high++){
            char ch=s.charAt(high);
            have[ch]++;
            while(sahi(have,needed)){
                int len=high-low+1;
                if(res>len){
                    res=len;
                    start=low;
                }
                char left=s.charAt(low);
                have[left]--;
                low++;
            }
        }
        return res==Integer.MAX_VALUE ? "" : s.substring(start,start+res);
    }
}