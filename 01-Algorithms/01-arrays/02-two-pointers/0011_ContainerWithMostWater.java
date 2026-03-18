//盛最多水的容器
//中等
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int minH = height[left]<height[right]?height[left]:height[right];
            int nowArea = (right - left) * minH;
                maxArea = nowArea>maxArea?nowArea:maxArea;
                if(height[left]<height[right]) left++;
                else right--;
            }

        }
        return maxArea;
    }
}