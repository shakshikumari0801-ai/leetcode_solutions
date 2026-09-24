class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int l = 0 , r = n-1;
        int max = 0;

        while(l < r){
            int h = Math.min(height[l] , height[r]);

            max = Math.max(max , h*(r-l));

            if(height[l] < height[r]) l++;
            else r--;
        }
        return max;
    }
}