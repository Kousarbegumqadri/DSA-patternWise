class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int sum=0,res=0;

        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        for(int i=0;i<n;i++){
            sum+=nums[i];
            int qest=sum-k;
            if(map.containsKey(qest)){
            res+=map.get(qest);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}