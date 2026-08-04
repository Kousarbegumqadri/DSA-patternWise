class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=1;i<nums.length;i++){
            int pre=nums[i-1];
            int curr=nums[i];
            for(int j=pre+1;j<curr;j++){
                list.add(j);
            }
        }
        return list;
    }
}