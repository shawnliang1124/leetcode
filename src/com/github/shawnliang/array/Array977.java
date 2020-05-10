package com.github.shawnliang.array;

/**
 * Description :   有序数组的平方.
 * @url https://leetcode-cn.com/problems/squares-of-a-sorted-array/
 * @author : Phoebe
 * @date : Created in 2020/5/5
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 示例 1：
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 */
public class Array977 {

  /**
   * 双指针解题
   * 因为给出的数组已经是排好序了，所以用两个指针，
   * i负责遍历
   * @param A 数组对象
   * @return  排序后的对象
   */
  public int[] sortedSquares(int[] A) {
    int n = A.length;
    int[] result = new int[n];
    // 正数代表的下标
    int i = 0;
    while (i <n && A[i] < 0 ) {
      i++;
    }
    // 负数开始的下标
    int j = i-1;
    int t = 0;
    while (j >= 0 && i < n) {
      if (A[i] * A[i] < A[j] * A[j]) {
        result[t] = A[i] * A[i];
        i++;
      } else {
        result[t] = A[j] * A[j];
        j--;
      }
      t++;
    }
    // t代表的是将要操作的元素的位置
    // 考虑边界情况
    if (j >= 0) {
      while (j >= 0) {
        result[t++] = A[j] * A[j];
        j--;
      }
    } else {
      while (i < n) {
        result[t++] = A[i] * A[i];
        i++;
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Array977 array977 = new Array977();
    int A[] = {-1};
    int[] ints = array977.sortedSquares(A);
    System.out.println(ints);
    for (int i = 0; i < ints.length; i++) {
      System.out.println(ints[i]);

    }
  }

}
