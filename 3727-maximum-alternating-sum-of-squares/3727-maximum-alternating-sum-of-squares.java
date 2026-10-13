class Solution {
    public long maxAlternatingSum(int[] nums) {
        long[] square = new long[nums.length];
        for(int i =0;i<nums.length;i++){
          square[i] = (long) nums[i]*nums[i];
        }
        Arrays.sort(square);
        long score = 0;
        int n= square.length;

        for(int i =0;i<n;i++){
            if(i<n/2){
                score -= square[i];
            }else{
                score +=square[i];
            }
        }
        return score;
    }
}