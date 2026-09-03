class Solution {
    public boolean uniformArray(int[] nums1) {
        int minEven = Integer.MAX_VALUE;
        int minOdd = Integer.MAX_VALUE;
    for(int num:nums1){
        if(num%2 == 0){
            minEven = Math.min(minEven,num);

        }else{
            minOdd = Math.min(minOdd,num);
        }
    }
        if(minEven == Integer.MAX_VALUE){
            return true;
        }
         if(minOdd == Integer.MAX_VALUE){
            return true;
        }
    
        return minOdd<minEven;
    }
}