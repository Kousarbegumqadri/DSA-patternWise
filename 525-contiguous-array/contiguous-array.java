class Solution {
    public int findMaxLength(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int zero=0,one=0,res=0;
        int diff=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                zero++;
            }
            else{
                one++;
            }
            
            diff=zero-one;
            if(diff==0){
                res=Math.max(res,i+1);
                continue;
            }
            if (map.containsKey(diff)) {
                 int index = map.get(diff);
                 int len = i - index;
                res = Math.max(res, len);
            } else {
                map.put(diff, i);
            }
        }
        return res;
    }
}