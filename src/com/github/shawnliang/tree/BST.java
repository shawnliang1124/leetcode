package com.github.shawnliang.tree;

import sun.reflect.generics.tree.VoidDescriptor;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2020/5/11
 */
public class BST<E extends Comparable<E>> {

  private class Node {

    public E e;
    public Node left, right;

    public Node(E e) {
      this.e = e;
      left = null;
      right = null;
    }
  }

  private Node root;
  private int size;

  public BST() {
    root = null;
    size = 0;
  }

  public int size() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }



   public void addV2(E e) {
      addElementV2(root, e);
   }

  /**
   *对addElement进行优化
   *减少判断的条件，再调用一次递归，如果节点是空的情况下，
   * 就直接return
   * 递归的终止条件，新增节点的位置为空
   * 递归的循环条件， 新增节点位置的值和要加入的节点的值的比较
   * @param node  .
   * @param e 要加入的节点
   * @return  ..
   */
   public Node addElementV2(Node node, E e) {
     if (node == null) {
       size++;
       node = new Node(e);
       return node;
     }
     if (e.compareTo(node.e) < 0) {
       node.left = addElementV2(node.left, e);
     } else if (e.compareTo(node.e) > 0) {
       node.right = addElementV2(node.right, e);
     }
     return node;
   }


  /**
   * 判断二分搜索树中是否含有某个元素
   * @param e .
   * @return  包含的结果
   */
   public boolean contains(E e) {
      return contains(root, e);
   }

   private boolean contains(Node node,E e) {
      if (node == null) {
        return false;
      }
      if (e.compareTo(node.e) == 0) {
        return true;
      }
      // 如果比node的值小，就递归拿node的左子树去比较
      else if (e.compareTo(node.e) < 0 ) {
        return contains(node.left, e);
      }
      else {
        return contains(node.right, e);
      }
   }





  /**
   * v1版本，相对V2来说判断复杂了一点
   * @param node  、
   * @param e   、
   */
  @Deprecated
   private void addElement(Node node, E e) {
      if (e.equals(node.e)) {
        return;
      }
      else if (e.compareTo(node.e) < 0 && node.left == null) {
          node.left = new Node(e);
      }
      else if (e.compareTo(node.e) > 0 && node.right == null) {
          node.right = new Node(e);
      }
      else if (e.compareTo(node.e) < 0) {
          addElement(node.left, e);
     } else { //e.compareTo(node.e) > 0
          addElement(node.right, e);
      }
   }


  /**
   * 插入方法
   * addV2 方法取代了它，优化后的代码
   * @param  e  要插入的元素
   */
  @Deprecated
  public void add (E e) {
    if (root == null) {
      root = new Node(e);
      size++;
    } else {
      addElement(root, e);
    }
  }


}
