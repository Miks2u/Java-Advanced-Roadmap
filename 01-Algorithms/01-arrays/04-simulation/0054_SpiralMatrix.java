//54.螺旋矩阵
//中等
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {

        List<Integer> res = new ArrayList<>();

        int top = 0 , left = 0;
        int bottom = matrix.length -1 , right = matrix[0].length -1;

        //开始返回

        while(true){
            for(int i = left ; i <= right ; i++){
            res.add(matrix[top][i]);
        }
        if(++top > bottom) break;

        for(int i = top ; i <= bottom ; i++){
            res.add(matrix[i][right]);
        }
        if(--right < left) break;

        for(int i = right ; i >= left ; i--){
            res.add(matrix[bottom][i]);
        }
        if(--bottom < top) break;

        for(int i = bottom ; i >= top ; i--){
           res.add(matrix[i][left]);
        }
        if(++left > right) break;
        }
        
        return res;


    }
}