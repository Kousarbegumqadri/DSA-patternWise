class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n=nums.length;
        int result=0;
        int maxDiff=Integer.MAX_VALUE;
        for(int i=0;i<n-2;i++){
            int left=i+1;
            int right=n-1;
            while(left<right){
                int sum=nums[i]+nums[left]+nums[right];
                if(sum==target){
                return sum;
                }
                else{
                    int diff=Math.abs(sum-target);
                    if(diff<maxDiff){
                        maxDiff=diff;
                        result=sum;
                    }
                }
                if(sum<target){
                    left++;
                }
                else{
                    right--;
                }
            }
        }
        return result;
    }
}