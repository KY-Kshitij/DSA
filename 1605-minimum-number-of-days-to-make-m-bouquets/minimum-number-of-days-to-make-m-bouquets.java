class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        // If there aren't enough flowers overall to make m bouquets,
        // it's impossible.
        if ((long) m * k > bloomDay.length) {
            return -1;
        }
        
        // Find the range for binary search.
        int low = 1; // earliest possible day (could also be set to min(bloomDay))
        int high = 0; // latest bloom day among all flowers
        for (int day : bloomDay) {
            high = Math.max(high, day);
        }
        
        int ans = -1;
        // Binary search on days.
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;
                high = mid - 1;  // try to find a smaller day
            } else {
                low = mid + 1;   // not enough bouquets, wait longer
            }
        }
        return ans;
    }
    
    // Helper method to check if it is possible to make m bouquets by 'day'.
    private boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int consecutive = 0;
        for (int bloom : bloomDay) {
            // If the flower blooms by 'day', count it; otherwise, reset.
            if (bloom <= day) {
                consecutive++;
                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0; // reset for next bouquet
                }
            } else {
                consecutive = 0;
            }
            // Early exit if we've already made enough bouquets.
            if (bouquets >= m) {
                return true;
            }
        }
        return bouquets >= m;
    }
}
