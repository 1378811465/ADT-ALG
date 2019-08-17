package Student.DataStructure;

import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树：n（n>=0）个结点的有限集合，该集合或者为空集（空二叉树），
 * 或者为由一个根结点和两颗互不相交的、分别称为根结点的左子树和右子树的二叉树组成。
 * @param <E>
 */
public class TreeStudent<E> {
    private int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    private static List<Node> nodeList = null;

    private static class Node<T>{
        Node leftChild;
        Node rightChild;
        T data;

        Node(T newData){
            leftChild = null;
            rightChild = null;
            data = newData;
        }
    }

    public void createBinaryTree(){
        //实例化nodeList
        nodeList = new LinkedList<Node>();

        //将数组元素添加到节点集合
        for(int i = 0;i < array.length;i++){
            nodeList.add(new Node(array[i]));
        }

        //对前lastParentIndex - 1个节点按照父节点与孩子节点数字关系 建立二叉树
        for(int parentIndex = 0;parentIndex <= array.length / 2 - 1;parentIndex++){
            //左子树
            nodeList.get(parentIndex).leftChild = nodeList.get(parentIndex * 2 + 1);

            //右子树
            if(parentIndex != array.length / 2 - 1){
                nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
            }else{
                //最后一个父节点：由于最后一个节点可能没有右子树，所以需要判断是否可以添加
                //右子树添加时，需要判断数组长度是否为奇数才能建立右子树
                if(array.length % 2 == 1){
                    nodeList.get(parentIndex).rightChild = nodeList.get(parentIndex * 2 + 2);
                }
            }
        }
    }

    /**
     * 遍历树方式
     * 这三种不同的遍历结构都是一样的，只是先后顺序不一样而已
     */

    //1、先序遍历
    public static void preOrderTraverse(Node node){
        if(node == null)
            return;
        System.out.print(node.data + " ");
        preOrderTraverse(node.leftChild);
        preOrderTraverse(node.rightChild);
    }

    //2、中序遍历
    public static void inOrderTraverse(Node node){
        if(node == null)
            return;
        inOrderTraverse(node.leftChild);
        System.out.print(node.data + " ");
        inOrderTraverse(node.rightChild);
    }

    //3、后序遍历
    public static void lastOrderTraverse(Node node){
        if(node == null)
            return;
        lastOrderTraverse(node.leftChild);
        lastOrderTraverse(node.rightChild);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args){
        TreeStudent tree = new TreeStudent();
        tree.createBinaryTree();
        //树的根节点
        Node root = nodeList.get(0);

        //先序遍历
        System.out.println("先序遍历");
        preOrderTraverse(root);
        System.out.println();

        //中序遍历
        System.out.println("中序遍历");
        inOrderTraverse(root);
        System.out.println();

        //后序遍历
        System.out.println("后序遍历");
        lastOrderTraverse(root);
        System.out.println();
    }


}
