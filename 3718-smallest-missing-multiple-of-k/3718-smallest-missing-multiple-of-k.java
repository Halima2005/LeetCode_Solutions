class Solution {
    public int missingMultiple(int[] nums, int k) {

        HashSet<Integer> set = new HashSet<>();

        int multiple = k;
        for(int num:nums){
            set.add(num);
        }      
        while(set.contains(multiple)){
            multiple+=k;
        }
     
        return multiple;

























        // int multiple =k;

        // while(true){
        //     boolean found = false;

        //     for(int num:nums){
        //         if(num==multiple){
        //             found=true;
        //             break;
        //         }
        //     }
        //     if(!found){
        //         return multiple;
        //     }
        //     multiple+=k;
        // }
        
    }
}