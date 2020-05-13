package com.github.shawnliang.tree;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/5/11
 */
public class BSTDemo {

  public static void main(String[] args) {
    BST<Integer> bst = new BST<>();


    bst.add(8);
    bst.add(4);
    bst.add(10);

    bst.add(6);
    bst.add(5);
    System.out.println(bst);
  }

}
