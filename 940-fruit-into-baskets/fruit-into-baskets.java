class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        int high=0,low=0,res=-1;
       int maxlen=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(high=0;high<n;high++){
            map.put(fruits[high],map.getOrDefault(fruits[high],0)+1);
            while(map.size()>2){
                int left=fruits[low];
                map.put(left,map.get(left)-1);
                if(map.get(left)==0){
                    map.remove(left);
                }
                low++;
            }
            maxlen=high-low+1;
            res=Math.max(res,maxlen);
        }
        return res;
    }
}