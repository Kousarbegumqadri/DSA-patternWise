class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        int low=0;
        int high=n-1;
        int index=-1;
        int mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]>nums[n-1]){
                low=mid+1;
            }
            else{
            index=mid;
            high=mid-1;
            }
        }
        low=0;
        high=index-1;
        mid=0;
        while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        low=index;
        high=n-1;
        mid=0;
          while(low<=high){
            mid=(low+high)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return -1;
    }
}