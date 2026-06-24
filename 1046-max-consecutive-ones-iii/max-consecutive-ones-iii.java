class Solution {
    private int find(int[] freq){
        int maxcount=-1;
        for(int i=0;i<2;i++){
            maxcount=Math.max(maxcount,freq[i]);
        }
        return maxcount;
    }
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int high=0,low=0,len=1,res=0,diff=0;
        int[] arr=new int[2];
        for(high=0;high<n;high++){
            arr[nums[high]]++;
            diff=arr[0];
            while(diff>k){
                arr[nums[low]]--;
                low++;
                diff=arr[0];
            }

            len=high-low+1;
            res=Math.max(len,res);
        }
        return res;
    }
}