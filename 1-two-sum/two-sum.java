class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        /*//Arrays.sort(nums);
        
        for(int i=0;i<n;i++){
            int j=i+1;
            int sum=nums[i]+nums[j];
            if(sum==target){
                return new int[] {i,j};
            }
            j++;
        }
        return new int[] {-1};*/
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<n;i++){
            int val=target-nums[i];
            if(map.containsKey(val)&& map.get(val)!=i){
                return new int[]{i,map.get(val)};
          }   
        }
        return new int[] {-1};
    }
}