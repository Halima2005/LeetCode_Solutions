class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int zeroIndex = -1;

        for(int i =0;i<n;i++){
            if(nums[i] == 0){
                zeroIndex=i;
                break;
            }
        }
        boolean asending = true;

        for(int i =1;i<n;i++){
            if(nums[i] != (nums[i-1]+1)%n){
            asending=false;
            break;
            }
        }
        if(asending){
            return Math.min(zeroIndex,n-zeroIndex+2);
        }

        boolean desending = true;
        for(int i =1;i<n;i++){
            if(nums[i] != (nums[i-1]-1+n)%n){
            desending=false;
            break;
        }
        }

        if(desending){
            int rotations = n-1-zeroIndex;
            return Math.min(rotations+1,n-rotations+1);
        }

        return -1;
    }
}