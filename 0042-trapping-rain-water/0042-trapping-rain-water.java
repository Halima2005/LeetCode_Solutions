class Solution {
    public int trap(int[] arr) {

        int left =0;
        int right = arr.length-1;
        int lmax =arr[left],rmax=arr[right];
        int ans =0;

        while(left<=right){
            if(lmax<rmax){
                lmax = Math.max(lmax,arr[left]);
                ans+=lmax-arr[left];
                left++;
            }else{
                rmax = Math.max(rmax,arr[right]);
                ans+=rmax-arr[right];
                right--;
            }
        }
        return ans;

















    //     int l =0,r=arr.length-1;
    //     int lmax=0,rmax=0,ans=0;
    //     while(l<r){
    //     lmax = Math.max(lmax,arr[l]);
    //     rmax= Math.max(rmax,arr[r]);

    //     if(lmax<rmax){
    //         ans+=lmax-arr[l];
    //         l++;
    //     }else{
    //         ans+=rmax-arr[r];
    //         r--;
    //     }
    // }
    // return ans;

    }
}