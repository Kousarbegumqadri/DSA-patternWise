class Solution {
    public boolean uniformArray(int[] nums1) {
        int minodd=Integer.MAX_VALUE;
        //int mineven=Integer.MAX_VALUE;
        for(int x:nums1){
            if(x%2!=0){
                minodd=Math.min(minodd,x);
            }
        }
        boolean allodd=true;
        //change all odd
        for(int x:nums1){
            if(x%2==0){
                if( minodd==Integer.MAX_VALUE || minodd>=x){
                    allodd=false;
                    break;
                }
            }
        }
        if(allodd){
            return true;
        }
         boolean alleven=true;
        //change all odd
        for(int x:nums1){
            if(x%2!=0){
                if(minodd==Integer.MAX_VALUE || minodd>=x){
                    alleven=false;
                    break;
                }
            }
        }
        return alleven;
    }
}