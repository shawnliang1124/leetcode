package com.github.shawnliang.reversion;

/**
 * Description : 使用递归进行数组的求和
 *
 * @author : Phoebe
 * @date : Created in 2020/3/16
 */
public class Sum {

  /**
   * 数组求和
   * @param arr 需要求和的数组
   * @return 数组的求和结果
   */
  public static int sum(int[] arr) {
    return sum(arr, 0);
  }

  /**
   * 递归对数组求和
   * @param arr 需要求和的数组
   * @param pos 数组的下标
   * @return 数组的求和结果
   */
  private static int sum(int[] arr , int pos) {
    if (arr == null || arr.length == pos) {
      return 0;
    }
    return arr[pos] + sum(arr, pos + 1);
  }

  public static void main(String[] args) {
    int[] array = new int[10];

    for (int i = 0; i < 10; i++) {
      array[i] = i;
    }
    int sum = Sum.sum(array);
    System.out.println(sum);

  }

}
