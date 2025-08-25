class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int Max = 0;
        
        for (int value : nums) {
            Max = Math.max(Max, value);
        }
        
        int high = Max;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            int sum = 0;
            
            for (int i = 0; i < nums.length; i++) {
                sum += (nums[i] + mid - 1) / mid;  // ceil(nums[i] / mid)
            }
            
            if (sum > threshold)
                low = mid + 1;
            else
                high = mid;
        }
        
        return low;
    }
}
