class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];
        int left = 0;
        int INF = n+1;
        int ans =INF;
        int sum=0;
        int minLength = INF;

        for(int right=0;right<n;right++){
            sum+=arr[right];

            while(sum>target){
                sum-=arr[left];
                left++;
            }
            if(sum == target){
                int currentLength = right-left+1;

                if(left>0 && best[left-1]!=INF){
                    ans=Math.min(ans,best[left-1]+currentLength);

                }
                minLength = Math.min(minLength,currentLength);
            }
            best[right] = minLength;
        }

        return ans == INF ? -1 : ans;

    }
}