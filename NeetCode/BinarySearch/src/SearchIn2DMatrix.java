/*
 * You are given an m x n 2-D integer array matrix and an integer target.
 *
 * Each row in matrix is sorted in non-decreasing order.
 * The first integer of every row is greater than the last integer of the previous row.
 * Return true if target exists within matrix or false otherwise.
 *
 * Can you write a solution that runs in O(log(m * n)) time?
 *
 * Example 1:
 * Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 10
 * Output: true
 *
 * Example 2:
 * Input: matrix = [[1,2,4,8],[10,11,12,13],[14,20,30,40]], target = 15
 * Output: false
 */
public class SearchIn2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        int top = 0, bottom = rowLength-1;
        while(top <= bottom)
        {
            int mid = top + (bottom - top)/2;
            if( matrix[mid][colLength-1] < target)
            {
                top = mid+1;
            }
            else if(matrix[mid][colLength-1] > target){
                bottom = mid - 1;
            }
            else {
                break;
            }
        }
        if(!(top <= bottom))
        {
            return false;
        }
        int row = (top+bottom)/2;
        int left = 0, right = colLength-1;
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            if(matrix[row][mid] == target)
            {
                return true;
            }
            else if(matrix[row][mid] < target)
            {
                left = mid+1;
            }
            else {
                right = mid - 1;
            }
        }
        return false;
    }
}
