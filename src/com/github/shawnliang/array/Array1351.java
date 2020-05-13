package com.github.shawnliang.array;

/**
 * Description :   1351. 统计有序矩阵中的负数.
 *
 * @author : Phoebe
 * @date : Created in 2020/5/12
 */
public class Array1351 {

  public int countNegatives(int[][] grid) {
    int count = 0;
    for (int i = 0; i < grid.length; i++) {
      int lineLength = grid[i].length;
      for (int j = 0; j < lineLength; j++) {
           if (grid[i][j] < 0 ) {
             count= count + lineLength - j;
             break;
           }
      }
    }
      return count;
  }

  public static void main(String[] args) {
    Array1351 array1351 = new Array1351();
    int[][] grid = {{4,3,2,1}, {3,2,1,-1}, {1,1,1,-2}, {-1,-1,-2,-3}};
    int countNegatives = array1351.countNegatives(grid);
    System.out.println(countNegatives);
  }

}
