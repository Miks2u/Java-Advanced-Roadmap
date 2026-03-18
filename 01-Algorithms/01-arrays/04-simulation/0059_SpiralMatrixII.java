//59.螺旋矩阵II
//中等
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;

        //上和左边界(对应索引为0)
        int top=0,left=0;
        //下和右边界(对应索引为0)
        int right = n-1,bottom = n-1;

        //

        while(count <= n*n){

            for(int i = left ; i <= right ; i++){
            res[top][i] = count++; 
            }
            if(++top > bottom) break; //撞墙

        for(int i = top ; i <= bottom ; i++){
            res[i][right] = count++;
            }
            if(--right < left) break;

        for(int i = right ; i >= left ; i--){
            res[bottom][i] = count++;
            }
            if(--bottom < top) break;

         for(int i = bottom ; i >= top ; i--){
            res[i][left] = count++;
           }
            if(++left > right) break;

        }

        return res;
        

    }
}