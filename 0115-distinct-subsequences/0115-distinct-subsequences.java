class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(m<n){
            return 0;
        }

        int[] dp = new int[n+1];
        dp[n]=1;

        for(int i = m-1;i>=0;i--){
            int sChar = s.charAt(i);
            for(int j = 0;j<n;j++){
                int tChar = t.charAt(j);

                if(sChar == tChar){
                    dp[j] = dp[j+1]+dp[j];
                }
            }
        }
        return dp[0];
    }
}