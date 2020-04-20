package com.github.shawnliang.study;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/3/17
 */
public class Study1 {

  public static boolean isLegal(String str) {
    char[] chars = str.toCharArray();
    for (int i = 0; i < chars.length-1; i++) {
      if (!Character.isUpperCase(chars[i]) && Character.isUpperCase(chars[i+1])) {
          return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String str =  "ABBaddAd";
    System.out.println(Study1.isLegal(str));
  }

}
