// O(Log N)
public class P13 {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1)return 0;
        if(nums[0]>nums[1]){
            return 0;
        }else if(nums[nums.length-2]<nums[nums.length-1]){
            return nums.length-1;
        }else{
            int low = 1;
            int high = nums.length-2;

            while(low<=high){
                int mid = low + (high-low)/2;

                if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]){
                    return mid;
                }else{
                    if(nums[mid]>nums[mid-1]){
                        low = mid+1;
                    }else{
                        high = mid-1;
                    }
                }
            }
            return -1;
        }
    }
}
