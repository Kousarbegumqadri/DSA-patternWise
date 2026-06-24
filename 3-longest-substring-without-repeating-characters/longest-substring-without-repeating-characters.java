class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n=s.length();
        int high=0,low=0,res=0,len=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for(high=0;high<n;high++){
            char ch=s.charAt(high);
            map.put(ch,map.getOrDefault(ch,0)+1);
            int k=high-low+1;
            while(map.size()<k){
                char leftchar=s.charAt(low);
                map.put(leftchar,map.get(leftchar)-1);
                if(map.get(leftchar)==0){
                    map.remove(leftchar);
                }
                low++;
                k=high-low+1;
            }
            len=high-low+1;
            res=Math.max(len,res);
        }
        return res;
    }
}