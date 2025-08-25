class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        
        int low=1;
        int Max=bloomDay[0];
        int n=bloomDay.length;
        if((long)m*k > n) return -1;
        
        for(int i=0; i<bloomDay.length ;i++){
            Max=Math.max(Max,bloomDay[i]);
        }
        
        int high=Max;
        int count=0;
        int z=0;
        
        while(low<high){
            int mid=low+(high-low)/2;
            z=0;  // reset every time
            
            count=0;
            for(int i=0 ; i<bloomDay.length;i++){
                if(mid >= bloomDay[i]){
                    count++;
                    if(k==count){
                        z++;
                        count=0;
                    }
                } else {
                    count=0;
                }
            }
            
            if(z>=m) high=mid;
            else low=mid+1;
        }
        return low; // final answer is low
    }
}
