public class P8 {
    class Solution {
        public int search(int[] nums, int target) {
            int low =0;
            int high = nums.length-1;
            // if(nums.length == 2){
            //     if(nums[0] == target)return 0;
            //     else if(nums[1] == target)return 1;
            // }
            while(low<=high){
                int mid = low + (high-low)/2;
    
                if(nums[mid] == target)return mid;
    
                if(nums[mid]>=nums[low]){
                    if(target<=nums[mid] && target>=nums[low]){
                        high = mid-1;
                    }else{
                        low = mid+1;
                    }
                }else{
                    if(target<=nums[high] && target>=nums[mid]){
                        low = mid+1;
                    }else{
                        high = mid-1;
                    }
                }
            }
    
            // if(low<0 || low == nums.length)return -1;
            return -1;
        }
    }
}
