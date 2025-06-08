public class P3 {
    class Solution {
        public int search(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            int ans = nums.length;
            int x = target;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (x >= nums[mid]) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            return ans;
        }
    }
}
