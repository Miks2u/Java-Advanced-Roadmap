//0042.接雨水
//困难！
class Solution {
    public int trap(int[] height) {
        //动态规划
        //从左往右
        int[] leftMax = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1; i < height.length ; i++){
            leftMax[i] = leftMax[i-1]>height[i]?leftMax[i-1]:height[i];
        }
        //从右往左
        int[] rightMax = new int[height.length];
        rightMax[height.length -1] = height[height.length -1];
        for(int i = height.length - 2; i >= 0; i--){
            rightMax[i] = rightMax[i+1]>height[i]?rightMax[i+1]:height[i];
        }

        //开始接水
        int[] water = new int[height.length];
        int sum = 0;
        for(int i = 0; i < height.length ; i++){
            water[i] = leftMax[i]<rightMax[i]?leftMax[i]:rightMax[i];
            water[i] -= height[i];
            sum += water[i];
        }
        return sum;
    }
}