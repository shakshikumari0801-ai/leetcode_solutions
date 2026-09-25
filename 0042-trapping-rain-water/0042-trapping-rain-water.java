class Solution {
    public int trap(int[] height) {
        int l = 0 , r = height.length-1;
        int leftmax = 0 ,  rightmax = 0;
        int water = 0;

        while(l < r){
            if(height[l] <= height[r]){
                if(height[l] >= leftmax){
                    leftmax = height[l];
                }else{
                    water += leftmax -height[l];
                }
                l++;
            }else{
                if(height[r] >= rightmax){
                    rightmax = height[r];
                }else{
                    water += rightmax - height[r];
                }
                r--;
            }
        }
        return water;
    }
}