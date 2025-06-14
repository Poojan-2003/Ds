public class P10 {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        int ans=Integer.MAX_VALUE;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]>=nums[low]){
                ans = Math.min(ans,nums[low]);
                low = mid+1;
            }else{
                ans = Math.min(ans,nums[mid]);
                high = mid-1;
            }
        }
        return ans;
    }
}
