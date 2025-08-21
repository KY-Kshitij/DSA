class Solution {
    public int minEatingSpeed(int[] piles, int h) {
     // The minimum possible speed is 1
        int left = 1;
        // The maximum possible speed is the maximum pile size
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        int result = right; // Initialize result with the maximum possible speed
        
        // Binary search to find the minimum valid eating speed
        while (left <= right) {
            int mid = left + (right - left) / 2;
            long hours = 0;
            
            // Calculate total hours needed at the current eating speed (mid)
            for (int pile : piles) {
                // Equivalent to: hours += Math.ceil((double) pile / mid)
                // Using integer math to avoid floating point operations:
                hours += (pile + mid - 1) / mid;
            }
            
            // If Koko can finish within h hours at speed mid,
            // try to see if there is a slower (smaller) valid speed.
            if (hours <= h) {
                result = mid;
                right = mid - 1;
            } else {
                // Otherwise, she needs to eat faster.
                left = mid + 1;
            }
        }
        
        return result;

 
    }
}