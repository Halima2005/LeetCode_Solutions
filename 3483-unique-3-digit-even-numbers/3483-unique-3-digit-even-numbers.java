class Solution {
    public int totalNumbers(int[] digits) {
        int count =0;
        boolean[] seen = new boolean[1000];
        for(int i =0;i<digits.length;i++){
            if(digits[i] == 0){
                continue;
            }

            for(int j =0;j<digits.length;j++){
                if(j == i){
                    continue;
                }
                for(int k =0;k<digits.length;k++){
                    if(k == i || k == j){
                        continue;
                    }

                    if(digits[k] % 2 != 0 ){
                        continue;
                    }
                    
                 int number = digits[i]*100+ digits[j]*10+digits[k];
                if(!seen[number]){
                    seen[number] = true;
                    count++;

                }
                }
            }
            
        }
       
           
        
        return count;
    }
}